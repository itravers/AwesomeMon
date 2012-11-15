
/**
 * This Class ties the applet to the backend. If a network connection is available
 * it will use the network backend. If no network connection is usable then it
 * uses a local backend.
 * @author Isaac Travers
 *
 */
public class BackendConnector {

	AwesomeMonApplet parent;
	BackEnd backEnd;
	
	LocalBackend localBackend;
	NetworkBackend networkBackend;
	
	/**
	 * The constructor	
	 * @param p The Parent of this class. (AwesomeMonApplet).
	 */
	public BackendConnector(AwesomeMonApplet p){
		localBackend = new LocalBackend(this);
		networkBackend = new NetworkBackend(this);
		parent = p;
		connectBackend();
	}
	
	/**
	 * Checks if a network back end is available and sets that to the current backend.
	 * If no network backend is good, then it changes it over to localbackend.
	 */
	private void connectBackend(){
		if(networkBackend.networkGood()){
			backEnd = networkBackend;
		}else{
			backEnd = localBackend;
		}
	}
	
	/**
	 * Adds a ping to the current backend.
	 * @param address The address of the ping to add.
	 */
	public void ping(String address){
		backEnd.ping(address);
	}
	
	/**
	 * Removes the ping from the backend, so it no longer executes.
	 * @param address
	 */
	public void removePing(String address){
		backEnd.removePing(address);
	}
	
	/**
	 * Reports the ping back to the GUI
	 * @param pingTime The ping time to report.
	 * @param address The address associated with the ping time.
	 */
	public void reportPing(int pingTime, String address){
		parent.mainCanvas.displayArea.reportPing(pingTime, address);
	}
}
