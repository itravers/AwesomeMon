import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.imageio.ImageIO;

/**
 * Contains global functions for the program.
 * 
 * @author Isaac Travers
 * 
 */
public class Functions {

	private static boolean isDebug = false;

	/**
	 * Returns the OS the code is being ran on
	 * 
	 * @return "windows", "linux", or "mac"
	 */
	public static String getOs() {
		String os = System.getProperty("os.name");
		os = os.toLowerCase();

		if (os.contains("windows")) {
			return "windows";
		} else if (os.contains("linux")) {
			return "linux";
		} else if (os.contains("mac")) {
			return "mac";
		} else {
			return null;
		}
	}

	/**
	 * Prints a message only if debug mode is on
	 * 
	 * @param message
	 *            The Message to print
	 */
	public static void DEBUG(String message) {
		if (isDebug) {
			System.err.println(" DEBUG: " + message);
		}
	}

	/**
	 * Turns debug mode on or off.
	 * 
	 * @param b
	 *            True if turning on, False if turning off.
	 */
	public static void setDebug(boolean b) {
		isDebug = b;
	}

	/**
	 * Tells us if debug mode is on or not.
	 * 
	 * @return
	 */
	public static boolean getDebug() {
		return isDebug;
	}

	/**
	 * Checks input to see if it is valid
	 * 
	 * @param input
	 *            The input to check
	 * @return True if input is okay, false if input is bad.
	 */
	public static boolean isValidInput(String input) {
		boolean isValid = false;
		if (input.contains(".com") || input.contains(".net")
				|| input.contains(".org") || input.contains(".us")
				|| input.contains(".co.uk")) {
			isValid = true;
		} else if (isIpAddress(input)) {
			isValid = true;
		}

		if (input.contains(" ")) {
			return false;
		}

		return isValid;
	}

	/**
	 * Checks if input is an IP Address or not
	 * 
	 * @param input
	 *            The String to Check
	 * @return Returns true if an ip address is present, false if else.
	 */
	public static boolean isIpAddress(String input) {
		if (input == null || input.isEmpty())
			return false;
		input = input.trim();
		if ((input.length() < 6) & (input.length() > 15))
			return false;

		try {
			Pattern pattern = Pattern
					.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
			Matcher matcher = pattern.matcher(input);
			return matcher.matches();
		} catch (PatternSyntaxException ex) {
			return false;
		}
	}

	
	
	public static BufferedImage getPic(URL u){
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return img;
	}

	public static BufferedImage scaleImage(BufferedImage img, int width, int height) {
		
		BufferedImage newImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = newImage.createGraphics();
		try {
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			g.clearRect(0, 0, width, height);
			g.drawImage(img, 0, 0, width, height, null);
		} finally {
			g.dispose();
		}
		return newImage;
	}
	
	public static BufferedImage scale(BufferedImage img, int width, int height){
		return (BufferedImage) img.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);
	}

	/**
	 * Converts a base 4 number to base 10
	 * 
	 * @param i
	 *            First Digit of base 4 num.
	 * @param n
	 *            Second Digit of base 4 num.
	 * @return Base 10 num
	 */
	public static int convertBase4(int i, int n) {
		int tens = i * 4;
		int ones = n * 1;
		int answer = tens + ones;
		// System.err.println("tens: " + i + " Ones: " + n + " Answer: " +
		// answer);
		return answer;
	}

}
