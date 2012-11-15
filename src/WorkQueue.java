import java.util.LinkedList;

public class WorkQueue
{
	PingManager parent;
    private final int nThreads;
    private final PoolWorker[] threads;
    private final LinkedList queue;

    public WorkQueue(int nThreads, PingManager p)
    {
    	parent = p;
        this.nThreads = nThreads;
        queue = new LinkedList();
        threads = new PoolWorker[nThreads];

        for (int i=0; i<nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable r) {
        synchronized(queue) {
            queue.addLast(r);
            queue.notify();
        }
    }
    

    public void addToQueue(Runnable r){
    	
    		execute(r);
    	
    }
    
    public Runnable removeFromQueue(){
    	synchronized(queue){
    		return (Runnable) queue.removeFirst();
    	}
    }
    
    public Runnable removeFromQueue(Runnable r){
    	int index = queue.indexOf(r);
    	return (Runnable) queue.remove(index);
    }
    
    public void removeFromQueue(String address){
    	for(int i = 0; i < queue.size(); i++){
    		synchronized(queue){
    			if (((Pinger)queue.get(i)).address.equals(address)){
    				queue.remove(i);
    			}
    		}
    	}
    }

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
                
                synchronized(queue){
                	queue.addLast(r);
                }
            }
        }
    }
}