/**
 * The runnable pinger that gets added to the backends workqueue.
 * @author Isaac Travers
 *
 */
public class Pinger implements Runnable{
	
	PingManager parent;
	JavaPing javaPing;
	String address;
	
	/**
	 * Constructor
	 * @param p The parent of this class
	 * @param addr The address to ping.
	 */
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
	
	/**
	 * Reports the ping back to the parent, and ultimately to the GUI.
	 * @param pingTime The pingtime to report.
	 */
	private void reportPing(int pingTime){
		parent.reportPing(pingTime, address);
	}

}
