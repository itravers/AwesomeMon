
public class BackendConnector {

	AwesomeMonApplet parent;
	BackEnd backEnd;
	
	LocalBackend localBackend;
	NetworkBackend networkBackend;
	
	public BackendConnector(AwesomeMonApplet p){
		localBackend = new LocalBackend(this);
		networkBackend = new NetworkBackend(this);
		parent = p;
		connectBackend();
	}
	
	private void connectBackend(){
		if(networkBackend.networkGood()){
			backEnd = networkBackend;
		}else{
			backEnd = localBackend;
		}
	}
	
	public void ping(String address){
		backEnd.ping(address);
	}
	
	public void removePing(String address){
		backEnd.removePing(address);
	}
	
	public void reportPing(int pingTime, String address){
		parent.mainCanvas.displayArea.reportPing(pingTime, address);
	}
}
