
/**
 * Tests pings, unused in final version.
 * @author Isaac Travers
 *
 */
public class Tester {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		String pingAddress = args[0];
		// TODO Auto-generated method stub
		JavaPing jPing = new JavaPing();
		
		for(int i = 0; i < 100; i++){
			System.out.println("Ping Time to " + pingAddress + " is " + jPing.ping(pingAddress));
		}
		

	}

}
