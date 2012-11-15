
public class LocalBackend implements BackEnd{
	
	BackendConnector parent;
	PingManager pingManager;
	
	public LocalBackend(BackendConnector p){
		parent = p;
		pingManager = new PingManager(this);
	}

	@Override
	public void ping(String address) {
		// TODO Auto-generated method stub
		pingManager.addPing(address);
	}

	@Override
	public void removePing(String address) {
		// TODO Auto-generated method stub
		pingManager.removePing(address);
		
	}

	@Override
	public void reportPing(int pingTime, String address) {
		// TODO Auto-generated method stub
		parent.reportPing(pingTime, address);
	}

}
