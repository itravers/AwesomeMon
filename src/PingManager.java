
/**
 * The PingManager contains the workqueue. 
 * It is itself contained by a backend.
 * @author Isaac Travers
 *
 */
public class PingManager{

	BackEnd parent;
	WorkQueue workQueue;

	/**
	 * The constructor
	 * @param p The backend. (Parent)
	 */
	public PingManager(BackEnd p){
		workQueue = new WorkQueue(5, this);
		parent = p;
	}
	
	/**
	 * Creates a Pinger from the address and Adds that Pinger to the workqueue.
	 * @param address The address to make a new pinger object with.
	 */
	public void addPing(String address){
		addPing(new Pinger(this, address));
	}
	
	/**
	 * Removes the ping from the workqueue.
	 * @param address The address of the ping to remove.
	 */
	public void removePing(String address){
		workQueue.removeFromQueue(address);
	}
	
	/**
	 * Adds a pinger to the workqueue that's already created.
	 * @param p The pinger to add.
	 */
	public void addPing(Pinger p){
		workQueue.addToQueue(p);
	}
	
	/**
	 * This reports the pingtime from the backend back to the gui so the gui knows how to update things.
	 * It reports back to the parent. The parent reports to it's parent, until it gets to the gui.
	 * @param pingTime The pingtime being reported.
	 * @param address The address the pingTime is being reported on.
	 */
	public void reportPing(int pingTime, String address){
		parent.reportPing(pingTime, address);
	}
	
}
