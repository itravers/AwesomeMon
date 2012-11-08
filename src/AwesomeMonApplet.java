import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class AwesomeMonApplet extends JApplet{

	JPanel mainPanel = new JPanel();
	JPanel northPanel = new JPanel();
	JPanel southPanel = new JPanel();
	
	
	//Called when applet is loaded into browser.
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
	
	private void buildWindow(){
		
		mainPanel = new JPanel(new BorderLayout());
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		northPanel.setBackground(Color.RED);
		southPanel.setBackground(Color.GREEN);
		

		mainPanel.add(northPanel, BorderLayout.NORTH);
                mainPanel.add(southPanel, BorderLayout.SOUTH);
		add(mainPanel);
		
	}
}
