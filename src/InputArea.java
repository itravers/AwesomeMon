import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The area where the user gets to input information.
 * @author Isaac Travers
 *
 */
public class InputArea extends JPanel{
	
	/**
	 * The Text Field the user types in.
	 */
	AwesomeTextField textField;
	
	/**
	 * The Button the user uses.
	 */
	AwesomeButton button;
	AwesomeButton testButton;

	/**
	 * The parent of this class.
	 */
	MainCanvas parent;
	
	/**
	 * The Constructor
	 * @param p The parent of this class.
	 */
	public InputArea (MainCanvas p){
		parent = p;
		
		setupInputArea();
	}
	
	/**
	 * Sets up the Input Area.
	 */
	private void setupInputArea(){
		button = new AwesomeButton("Add");
		testButton = new AwesomeButton("Test");
		textField = new AwesomeTextField("Input Address Here");
		button.addActionListener(parent.parent.guiManager);
		testButton.addActionListener(parent.parent.guiManager);
		textField.addMouseListener(parent.parent.guiManager);
		textField.addKeyListener(parent.parent.guiManager);
		
		add(textField);
		add(button);
		add(testButton);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintVersion(g);
	}
	
	private void paintVersion(Graphics g){
		String version = Functions.getVersion();
		g.drawString(version, 10, 10);
	}
}
