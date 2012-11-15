import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * This was just to test applets. Isn't needed for final program.
 * @author Isaac Travers
 *
 */
public class AppletTest extends JApplet{

	JPanel mainPanel = new JPanel();
	//Called when applet is loaded into browser.
	public void init(){
		
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					JLabel lbl = new JLabel("Hello World");
					add(mainPanel);
					mainPanel.add(lbl);
				}
			});
		} catch (Exception e) {
			System.err.println("createGUI didn't complete successfully");
		}
	}
}
