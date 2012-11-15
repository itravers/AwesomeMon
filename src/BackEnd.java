/**
 * Backend interface. Any class that communicates with a backend has to do so through this interface.
 * @author Isaac Travers
 *
 */
public interface BackEnd {
	public void ping(String address);
	public void removePing(String address);
	public void reportPing(int pingTime, String address);
}
