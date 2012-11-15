
public class PingManager{

	BackEnd parent;
	WorkQueue workQueue;

	
	public PingManager(BackEnd p){
		workQueue = new WorkQueue(5, this);
		parent = p;
	}
	
	public void addPing(String address){
		addPing(new Pinger(this, address));
	}
	
	public void removePing(String address){
		workQueue.removeFromQueue(address);
	}
	
	public void addPing(Pinger p){
		workQueue.addToQueue(p);
	}
	
	public void removePing(Pinger p){
		workQueue.removeFromQueue(p);
	}
	
	public void reportPing(int pingTime, String address){
		parent.reportPing(pingTime, address);
	}
	
}
