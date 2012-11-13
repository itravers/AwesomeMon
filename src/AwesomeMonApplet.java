import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Date;

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
	 * The class that manages the gui.
	 */
	GUIManager guiManager;
	
	
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
	
	public void start(){
		new Thread(
	            new Runnable() {
	                public void run() {
	                	while(true){
	                		 try {
	 	                        Thread.sleep(200);
	 	                    } catch (Exception e) {
	 	                        e.printStackTrace();
	 	                    }
	 	                    Functions.DEBUG(
	 	                        "child thread  " + new Date(System.currentTimeMillis()));
	 	                    repaint();
	                	}
	                   
	                }
	            }).start();
	}
	
	/**
	 * Constructs the main window of the applet.
	 */
	private void buildWindow(){
		this.setSize(new Dimension(600, 400));
		Functions.setDebug(true);
		guiManager = new GUIManager(this);
		mainCanvas = new MainCanvas(this);
		
		add(mainCanvas);
		
	}
	
	 
}
