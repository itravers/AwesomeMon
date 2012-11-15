import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class GUIManager implements ActionListener, MouseListener, KeyListener,
		MouseMotionListener {

	AwesomeMonApplet parent;
	int tracker;

	public GUIManager(AwesomeMonApplet p) {
		parent = p;
		Functions.DEBUG("GUI MANAGER RUNNING");
		tracker = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Functions.DEBUG("Action: " + e.getActionCommand());

		if (e.getActionCommand().equals("Add")) {
			if (validateInput()) {
				addPressed();
			} else {
				badInput();
			}
		} else if (e.getActionCommand().equals("Test")) {
			if (tracker == 0) {
				parent.mainCanvas.displayArea.imageQueue.get(0).setCurrentImage(parent.mainCanvas.displayArea.imageQueue.get(0).redPressed);
				tracker++;
			} else if (tracker == 1) {
				parent.mainCanvas.displayArea.imageQueue.get(0).currentImage = parent.mainCanvas.displayArea.imageQueue
						.get(0).greenUnpressed;
				tracker++;
			} else if (tracker == 2) {
				parent.mainCanvas.displayArea.imageQueue.get(0).currentImage = parent.mainCanvas.displayArea.imageQueue
						.get(0).greenPressed;
				tracker++;
			} else if (tracker == 3) {
				parent.mainCanvas.displayArea.imageQueue.get(0).currentImage = parent.mainCanvas.displayArea.imageQueue
						.get(0).yellowPressed;
				tracker++;
			} else if (tracker == 4) {
				parent.mainCanvas.displayArea.imageQueue.get(0).currentImage = parent.mainCanvas.displayArea.imageQueue
						.get(0).yellowUnpressed;
				tracker++;
			} else if (tracker == 5) {
				parent.mainCanvas.displayArea.imageQueue.get(0).currentImage = parent.mainCanvas.displayArea.imageQueue
						.get(0).redUnpressed;
				tracker = 0;
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Functions.DEBUG("Mouse Click: " + e.getComponent());

		if (e.getComponent() == parent.mainCanvas.inputArea.textField) {
			parent.mainCanvas.inputArea.textField.setText("");
		} else {

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

		if (KeyEvent.getKeyText(e.getKeyCode()).equals("Enter")) {
			if (validateInput()) {
				addPressed();
			} else {
				badInput();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public void addPressed() {
		Functions.DEBUG("Add Pressed");
		
		String text = parent.mainCanvas.inputArea.textField.getText();
		
		if(parent.mainCanvas.displayArea.imageQueue.containsName(parent.mainCanvas.inputArea.textField.getText())){
			parent.mainCanvas.displayArea.imageQueue.removeName(parent.mainCanvas.inputArea.textField.getText());
			parent.backendConnector.removePing(text);
		}else{
			PingDisplay pingDisplay = new PingDisplay(text, this);
			parent.mainCanvas.displayArea.imageQueue.add(pingDisplay);
			parent.mainCanvas.inputArea.textField.setText("");
			parent.backendConnector.ping(text);
		}
		
	}

	public void badInput() {
		Functions.DEBUG("Bad Input");
		parent.mainCanvas.inputArea.textField
				.setText(" Invalid: Domain or IP ONLY! ");
	}

	private boolean validateInput() {
		return parent.mainCanvas.inputArea.textField.validateTyping();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("Mouse: " + e.getX() + " " + e.getY());
		// check if mouse is over pingDisplays to make the ping display slightly
		// lighter.

	}

}
