
public class Pinger implements Runnable{
	
	PingManager parent;
	JavaPing javaPing;
	String address;
	
	public Pinger(PingManager p, String addr){
		parent = p;
		address = addr;
		javaPing = new JavaPing();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int pingTime = javaPing.ping(address);
		reportPing(pingTime);
		
	}
	
	private void reportPing(int pingTime){
		parent.reportPing(pingTime, address);
	}

}
