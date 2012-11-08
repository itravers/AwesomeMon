


/**
 * Contains global functions for the program.
 * @author Isaac Travers
 *
 */
public class Functions {
	
	private static boolean isDebug = false;
	
	/**
	 * Returns the OS the code is being ran on
	 * @return "windows", "linux", or "mac"
	 */
	public static String getOs(){
		String os = System.getProperty("os.name");
		os = os.toLowerCase();

		if(os.contains("windows")){
			return "windows";
		}else if(os.contains("linux")){
			return "linux";
		}else if(os.contains("mac")){
			return "mac";
		}else{
			return null;
		}
	}
	
	public static void DEBUG(String type, String message){
		if(isDebug){
			System.err.println(type + " DEBUG: " + message);
		}
	}
	
	public static void setDebug(boolean b){
		isDebug = b;
	}
	
	public static boolean getDebug(){
		return isDebug;
	}

}
