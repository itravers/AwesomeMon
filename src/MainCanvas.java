import javax.swing.JPanel;

/**
 * The MainCanvas includes both the display area and the input area. This is added straight to the applet.
 * @author Isaac Travers
 *
 */
public class MainCanvas extends JPanel{

	/**
	 * The Main Applet
	 */
	AwesomeMonApplet parent;
	
	/**
	 * The Area where everything is displayed to the user.
	 */
	DisplayArea displayArea;
	
	/**
	 * The Area where the user input information
	 */
	InputArea inputArea;
	
	/**
	 * The Constructor
	 * @param p The Main applet
	 */
	public MainCanvas(AwesomeMonApplet p){
		parent = p;
		displayArea = new DisplayArea(this);
		inputArea = new InputArea(this);
	}
}
