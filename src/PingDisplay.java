import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * This class contains the images displayed. Later the images will be moved to a static class
 * and this class will only contain the currentImage.
 * @author Isaac Travers
 *
 */
public class PingDisplay extends Component{

	BufferedImage redUnpressed;
	BufferedImage redPressed;
	BufferedImage greenUnpressed;
	BufferedImage greenPressed;
	BufferedImage yellowUnpressed;
	BufferedImage yellowPressed;
	BufferedImage orangeUnpressed;
	BufferedImage orangePressed;
	BufferedImage currentImage;
	
	GUIManager parent;
	String name;
	int pingTime;

	/**
	 * Constructor
	 * @param name The address being pung, this is displayed in the middle of the ping display.
	 * @param pingTime The pingtime, this decides the current color image.
	 * @param parent The parent of this class, probably a GUImanager.
	 */
	public PingDisplay(String name, int pingTime, GUIManager parent) {
		this.name = name;
		this.pingTime = pingTime;
		this.parent = parent;
		initImages();
		initFocus();
		this.addMouseListener(parent);
	}
	
	/**
	 * Constructor
	 * @param name Make's a constructor that doesn't have a current pingtime
	 * @param parent
	 */
	public PingDisplay(String name, GUIManager parent){
		this(name, 0, parent);
	}

	/**
	 * Gets the current pingtime being shown by the pingdisplay.
	 * @return
	 */
	public int getPingTime() {
		return pingTime;
	}

	/**
	 * Sets the current pingtime. This will also change colors if pingtime is in a different latency category.
	 * @param time
	 */
	public void setPingTime(int time) {
		pingTime = time;
		setColor(pingTime);
	}
	
	/**
	 * Gets the current image of the pingDisplay.
	 * @return The current Image
	 */
	public BufferedImage getCurrentImage(){
		return currentImage;
	}
	
	/**
	 * Sets the current image to a new image.
	 * @param i The new image.
	 */
	public void setCurrentImage(BufferedImage i){
		currentImage = i;
	}
	
	private void initFocus(){
		
	}
	
	/**
	 * Decides the color of the pingDisplay based on latency.
	 * @param latency The latency of the ping.
	 */
	private void setColor(int latency){
		if(latency <= 0){
			setCurrentImage(redUnpressed);
		}else if(latency <= 100){
			setCurrentImage(greenUnpressed);
		}else if(latency >= 101){
			setCurrentImage(yellowUnpressed);
		}
	}
	
	/**
	 * Loads images.
	 */
	private void initImages(){
		String redUnpressedAddress = "images/redUnpressed.png";
		String redPressedAddress = "images/redPressed.png";
		String greenUnpressedAddress = "images/greenUnpressed.png";
		String greenPressedAddress = "images/greenPressed.png";
		String yellowPressedAddress = "images/yellowPressed.png";
		String yellowUnpressedAddress = "images/yellowUnpressed.png";
		
		BufferedImage img = null;
		URL u;
		
		u = this.getClass().getResource(redUnpressedAddress);
		redUnpressed = Functions.getPic(u);
		
		u = this.getClass().getResource(redPressedAddress);
		redPressed = Functions.getPic(u);
		
		u = this.getClass().getResource(greenUnpressedAddress);
		greenUnpressed = Functions.getPic(u);
		
		u = this.getClass().getResource(greenPressedAddress);
		greenPressed = Functions.getPic(u);
		
		u = this.getClass().getResource(yellowUnpressedAddress);
		yellowUnpressed = Functions.getPic(u);
		
		u = this.getClass().getResource(yellowPressedAddress);
		yellowPressed = Functions.getPic(u);
		
		
		redUnpressed = Functions.scaleImage(redUnpressed, parent.parent.mainCanvas.displayArea.getWidth()/4, parent.parent.mainCanvas.displayArea.getHeight()/4);
		redPressed = Functions.scaleImage(redPressed, parent.parent.mainCanvas.displayArea.getWidth()/4, parent.parent.mainCanvas.displayArea.getHeight()/4);
		greenUnpressed = Functions.scaleImage(greenUnpressed, parent.parent.mainCanvas.displayArea.getWidth()/4, parent.parent.mainCanvas.displayArea.getHeight()/4);
		greenPressed = Functions.scaleImage(greenPressed, parent.parent.mainCanvas.displayArea.getWidth()/4, parent.parent.mainCanvas.displayArea.getHeight()/4);
		yellowUnpressed = Functions.scaleImage(yellowUnpressed, parent.parent.mainCanvas.displayArea.getWidth()/4, parent.parent.mainCanvas.displayArea.getHeight()/4);
		yellowPressed = Functions.scaleImage(yellowPressed, parent.parent.mainCanvas.displayArea.getWidth()/4, parent.parent.mainCanvas.displayArea.getHeight()/4);
		
		//redUnpressed.
		
		
		
		setCurrentImage(redUnpressed);
	}

}
