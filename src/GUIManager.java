import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;


public class GUIManager implements ActionListener, MouseListener, KeyListener{

	AwesomeMonApplet parent;
	
	public GUIManager(AwesomeMonApplet p){
		parent = p;
		Functions.DEBUG("GUI MANAGER RUNNING");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Functions.DEBUG("Action: " + e.getActionCommand());
		
		if(e.getActionCommand().equals("Add")){
			if(validateInput()){
				addPressed();
			}else{
				badInput();
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Functions.DEBUG("Mouse Click: " + e.getComponent());
		
		if(e.getComponent() == parent.mainCanvas.inputArea.textField){
			parent.mainCanvas.inputArea.textField.setText("");
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		validateInput();
		
				if(KeyEvent.getKeyText(e.getKeyCode()).equals("Enter")){
					if(validateInput()){
						addPressed();
					}else{
						badInput();
					}
				}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	public void addPressed(){
		Functions.DEBUG("Add Pressed");
		String text = parent.mainCanvas.inputArea.textField.getText();
		String address = "images/redUnpressed.png";
		URL u;
		BufferedImage img = null;
		u = this.getClass().getResource(address);
		img = Functions.getPic(u);
		
		
		img = Functions.scaleImage(img, parent.mainCanvas.displayArea.getWidth()/4, parent.mainCanvas.displayArea.getHeight()/4);
		
		parent.mainCanvas.displayArea.imageQueue.add(img);
	}
	
	public void badInput(){
		Functions.DEBUG("Bad Input");
		parent.mainCanvas.inputArea.textField.setText(" Invalid: Domain or IP ONLY! ");
	}
	
	private boolean validateInput(){
		return parent.mainCanvas.inputArea.textField.validateTyping();
	}



}
