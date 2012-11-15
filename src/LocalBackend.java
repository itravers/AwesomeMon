
/**
 * The local backend. Implements the Backend interface.
 * @author Isaac Travers
 *
 */
public class LocalBackend implements BackEnd{
	
	BackendConnector parent;
	PingManager pingManager;
	
	/**
	 * The constructor.
	 * @param p The backend connector, parent of this class.
	 */
	public LocalBackend(BackendConnector p){
		parent = p;
		pingManager = new PingManager(this);
	}
	
	/**
	 * The method that initiates a ping.
	 * @param address The address to initate the ping to.
	 */
	public void ping(String address) {
		// TODO Auto-generated method stub
		pingManager.addPing(address);
	}

	/**
	 * Removes the ping from the ping manager.
	 * @param address The address of the ping to remove.
	 */
	public void removePing(String address) {
		// TODO Auto-generated method stub
		pingManager.removePing(address);
	}

	/**
	 * This is part of a chain that ultimately reports the ping back to the gui.
	 * This method triggers the report ping method in it's parent, (backendconnector).
	 */
	public void reportPing(int pingTime, String address) {
		// TODO Auto-generated method stub
		parent.reportPing(pingTime, address);
	}

}
