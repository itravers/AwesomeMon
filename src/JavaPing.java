
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;



/**
 * Backend class that actually does the ping work
 * @author Isaac Travers
 *
 */
public class JavaPing{
	
	/**
	 * Constructor
	 */
	JavaPing(){
		//do nothing
	}
	
	/**
	 * Pings a given address
	 * @param addr The Address to ping.
	 * @return The ping time.
	 */
	public int ping(String addr){
		String os = Functions.getOs();
		if(os.equals("windows")){
			return windowsPing(addr);
		}else if(os.equals("linux")){
			return linuxPing(addr);
		}else{
			return 0;
		}
	}
	
	
	/**
	 * The ping commands that run on windows.
	 * @param addr The address to ping
	 * @return The ping time
	 */
	private int windowsPing(String addr){
		int pingTime = 0;
		List<String> commands = new ArrayList<String>();
	    commands.add("ping");
	    commands.add("-n");
	    commands.add("2");
	    commands.add(addr);
	    
	    try {
			pingTime = doCommand(commands);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return pingTime;
	}
	
	
	/**
	 * The ping commands that run on linux
	 * @param addr The address to ping
	 * @return The ping time.
	 */
	private int linuxPing(String addr){
		int pingTime = 0;
		List<String> commands = new ArrayList<String>();
	    commands.add("ping");
	    commands.add("-c");
	    commands.add("2");
	    commands.add(addr);
	    
	    try {
			pingTime = doCommand(commands);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    return pingTime;
	}
	
	  
	  /**
	   * Executes command line commands. Parses and returns ping time.
	   * @param command The list of commands to send the operating system.
	   * @return The parsed time of a ping.
	   * @throws IOException Throws exception if no access to command line.
	   */
	  private int doCommand(List<String> command) 
			  throws IOException
			  {
			    String s = null;
			    String answer = "";
			    
			    ProcessBuilder pb = new ProcessBuilder(command);
			    Process process = pb.start();

			    BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
			    BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			    // read the output from the command
			    //System.out.println("Here is the standard output of the command:\n");
			    while ((s = stdInput.readLine()) != null)
			    {
			    	answer = answer + " " + s;
			     // System.out.println(s);
			    }
			    
			    int pingTime = getPingFromToken(answer);
			    //System.out.println("ping is:" + ping);

			    // read any errors from the attempted command
			    //System.out.println("Here is the standard error of the command (if any):\n");
			    while ((s = stdError.readLine()) != null)
			    {
			     // System.out.println(s);
			    }
			    
			    return pingTime;
			  }
	  
	  
	  /**
	   * Parses the command line output, looks for ping time and returns it.
	   * This method decides between operating systems and calls the correct sub-function.
	   * @param answer The string that was returned from the command line.
	   * @return The parsed ping time from command line output.
	   */
	  int getPingFromToken(String answer){
		  String os = Functions.getOs();
			if(os.equals("windows")){
				return WINDOWS_getPingFromToken(answer);
			}else if(os.equals("linux")){
				return LINUX_getPingFromToken(answer);
			}else{
				return 0;
			}
	  }
	  
	  /**
	   * Parses the command line output from a windows machine (tested on windows 7)
	   * @param answer The command line output from windows.
	   * @return The parsed ping time
	   */
	  int WINDOWS_getPingFromToken(String answer){
		  StringTokenizer tokenizer = new StringTokenizer(answer);
		  Integer pingTime = new Integer(0);
		  
		  String token = "0";
		
		  if(answer.contains("host unreachable") || answer.contains("timed out")){
				token = "0";
			}else{
				do{
					token = tokenizer.nextToken();
				  }while(!token.contains("Average"));
				  
				  token = tokenizer.nextToken();
				  token = tokenizer.nextToken();
				  
				  if(token.endsWith("ms")){
					  token = token.substring(0, token.length()-2);
				  }
			}
	  
		 pingTime = Integer.parseInt(token);
		  
		  return pingTime;
		  
	  }
	  
	  /**
	   * Parses the command line output from a linux machine (tested on CentOS)
	   * @param answer The command line output from windows.
	   * @return The parsed ping time
	   */
	  int LINUX_getPingFromToken(String answer){
		  StringTokenizer tokenizer = new StringTokenizer(answer);
		  Integer pingTime = new Integer(0);
		  
		  String token = "0";
		
		  if(answer.contains("Host Unreachable") || answer.contains("100% packet loss")){
				token = "0";
			}else{
				do{
					token = tokenizer.nextToken();
				  }while(!token.contains("min/avg/max/mdev"));
				  
				  token = tokenizer.nextToken();
				  token = tokenizer.nextToken();
				  
				    //  token = token.substring(token.indexOf('/')+1);
					  token = token.substring(0, token.indexOf('/'));
					  Functions.DEBUG("token " + token);
				  
			}
	     
		 float floatTime = Float.parseFloat(token);
		 
		  if(token.contains(".")){
		  token = token.substring(0, token.indexOf('.'));
	  }
		 pingTime = Integer.parseInt(token);
		 
		 if(floatTime < 1 && floatTime > 0 ){
			 pingTime = 1;
		 }
		 
		 //Functions.setDebug(true);
		 Functions.DEBUG("floattime " + floatTime);
		 Functions.DEBUG("pingtime " +  pingTime);
		  
		  return pingTime;
		  
	  }
}