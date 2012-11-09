import java.awt.Color;

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
		button = new AwesomeButton("Add");
		textField = new AwesomeTextField("Input Address Here");
		setupInputArea();
	}
	
	/**
	 * Sets up the Input Area.
	 */
	private void setupInputArea(){
		//this.setBackground(Color.green);
		add(textField);
		add(button);
	}
}