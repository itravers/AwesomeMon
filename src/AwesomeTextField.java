import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalBorders;
import javax.swing.text.DefaultCaret;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;


public class AwesomeTextField extends JTextField{
	
	public AwesomeTextField(String text){
		super(text, 20);
		setupTextField();
	}
	
	private void setupTextField(){
		Font font = new Font("Thoma", Font.BOLD,12);
		setFont(font);
		this.setHorizontalAlignment(JTextField.CENTER);
		this.setCaretColor(Color.white);
		this.setOpaque(true);
		this.setBackground(Color.gray);
		this.setForeground(Color.white);
		this.setBorder(null);
		this.setBorder(MetalBorders.getTextFieldBorder());
	}
	
	
	

}
