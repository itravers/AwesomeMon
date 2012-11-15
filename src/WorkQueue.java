import java.util.LinkedList;


/**
 * This class has a Thread pool that loops over the queue and executes all the 
 * runnable Pingers.
 * @author Isaac Travers
 *
 */
public class WorkQueue
{
	PingManager parent;
    private final int nThreads;
    private final PoolWorker[] threads;
    private final LinkedList queue;
    private final LinkedList queueList;

    /**
     * Constructor
     * @param nThreads The number of threads you want in this workqueues threadpool
     * @param p The parent of this class.
     */
    public WorkQueue(int nThreads, PingManager p)
    {
    	parent = p;
        this.nThreads = nThreads;
        queue = new LinkedList();
        queueList = new LinkedList();
        threads = new PoolWorker[nThreads];

        for (int i=0; i<nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    /**
     * The instruction to add a runnable to the thread queue.
     * It should automagically start processing.
     * @param r The Runnable Pinger you want the workqueue to run.
     */
    public void execute(Runnable r) {
        synchronized(queue) {
            queue.addLast(r);
            queue.notify();
        }
        synchronized(queueList){
        	queueList.addLast(r);
        	queueList.notify();
        }
    }
    

    /**
     * Adds the runnable to the queue. This only calls execute.
     * @param r The runnable Pinger to add.
     */
    public void addToQueue(Runnable r){
    		execute(r);
    }
    
    /**
     * This method removes the pinger from the queuelist. Later when the pool worker
     * finishes executing a ping, it checks to see if the current item it is executing
     * is still in the pingList, if it is it adds that item back to the queue.
     * If it is not in the queuelist, it just drops the queue. Letting the garabage
     * manager take care of it later.
     * @param address The address to take out of the workqueue
     */
    public void removeFromQueue(String address){
    	for(int i = 0; i < queueList.size(); i++){
    		
    			if(((Pinger)queueList.get(i)).address.equals(address)){
    				queueList.remove(i);
    			}
    	}
    	
    }
    
    /**
     * This is the method that checks to see if the current item is in the queuelist.
     * If it is it adds the item back to the queue, if it is not present it just drops it.
     * @param r The object to check and add.
     */
    private void checkAndAddToQueue(Runnable r){
    	
    	if(queueList.contains(r)){
    		synchronized(queue){
        		queue.addLast(r);
        	}
    	}else{
    		Functions.DEBUG("Removing " + ((Pinger)r).address);
    	}
    	
    }

    /**
     * This is the worker thread that process the queue
     * @author Isaac Travers
     *
     */
    private class PoolWorker extends Thread {
        public void run() {
            Runnable r;

            while (true) {
                synchronized(queue) {
                    while (queue.isEmpty()) {
                        try
                        {
                            queue.wait();
                        }
                        catch (InterruptedException ignored)
                        {
                        }
                    }

                    r = (Runnable) queue.removeFirst();
                }

                // If we don't catch RuntimeException, 
                // the pool could leak threads
                try {
                    r.run();
                }
                catch (RuntimeException e) {
                    // You might want to log something here
                }
                
                	checkAndAddToQueue(r);
                
            }
        }
    }
}