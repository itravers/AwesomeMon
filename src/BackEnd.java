
public interface BackEnd {
	public void ping(String address);
	public void removePing(String address);
	public void reportPing(int pingTime, String address);
}
