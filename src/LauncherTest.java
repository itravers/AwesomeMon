import javax.swing.JFrame;

/**
 * Encapsulates the applet so it can be launched without a webpage or ide.
 * @author Isaac Travers
 *
 */
public class LauncherTest {

	/**
	 * The applet to encapsulate
	 */
	AwesomeMonApplet applet;
	
	/**
	 * Launcher
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new LauncherTest();
		
	}
	
	/**
	 * Constructor.
	 */
	public LauncherTest(){
		JFrame frame = new JFrame("test");
		frame.setVisible(true);
	
		applet = new AwesomeMonApplet();
		applet.init();
		applet.start();
		frame.add(applet);
		frame.setSize(applet.getSize());
	}

}
