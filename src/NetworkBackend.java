
public class NetworkBackend implements BackEnd{

	BackendConnector parent;
	
	public NetworkBackend(BackendConnector p){
		parent = p;
	}
	
	@Override
	public void ping(String address) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean networkGood(){
		return false;
	}

	@Override
	public void removePing(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportPing(int pingTime, String address) {
		// TODO Auto-generated method stub
		
	}

}
