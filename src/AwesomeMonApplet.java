import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The main applet. This class is referred to by the html file.
 * @author Isaac Travers
 *
 */
public class AwesomeMonApplet extends JApplet{

	/**
	 * The mainCanvas holds the display and input area's.
	 */
	MainCanvas mainCanvas;
	
	
	/**
	 * Called as soon as the applet is loaded into the browser.
	 */
	public void init(){
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					buildWindow();
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't complete successfully");
		}
	}
	
	/**
	 * Constructs the main window of the applet.
	 */
	private void buildWindow(){
		
		mainCanvas = new MainCanvas(this);
		add(mainCanvas);
		
	}
}
