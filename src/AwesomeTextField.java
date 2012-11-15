import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalBorders;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 * The textfield used for input and output messages.
 * @author Isaac Travers
 *
 */
public class AwesomeTextField extends JTextField{
	
	/**
	 * The constructor
	 * @param text The default text to have in the textfield.
	 */
	public AwesomeTextField(String text){
		super(text, 20);
		setupTextField();
	}
	
	/**
	 * Sets the textfields color, alignment, border and fonts.
	 */
	private void setupTextField(){
		this.setOpaque(true);
		this.setBackground(Color.gray);
		Font font = new Font("Thoma", Font.BOLD,14);
		setFont(font);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setCaretColor(Color.white);
		
		this.setForeground(Color.white);
		this.setBorder(null);
		this.setBorder(MetalBorders.getTextFieldBorder());
	}
	
	/**
	 * Makes sure the text written in the text box is an ip address or a
	 * .com .net or .org domain name.
	 * @return true if it's good input, false if it's bad input.
	 */
	public boolean validateTyping(){
		if(Functions.isValidInput(this.getText())){
			this.setForeground(Color.GREEN);
			return true;
		}else{
			this.setForeground(Color.WHITE);
			return false;
		}
	}
}
