import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * The AwesomeMon display.
 * 
 * @author Isaac Travers
 * 
 */
public class DisplayArea extends JPanel {
	MainCanvas parent;
	BufferedImage backgroundImage;
	ImageQueue imageQueue;

	/**
	 * Constructor
	 * 
	 * @param p The Parent that contains this class.
	 */
	public DisplayArea(MainCanvas p) {
		parent = p;
		setupBackground();
		this.setPreferredSize(new Dimension(600, 350));
		this.setBackground(Color.gray);
		imageQueue = new ImageQueue(this);
		
		this.addMouseMotionListener(parent.parent.guiManager);
	}
	
	/**
	 * This is the final report ping that connects straight to the GUI. It checks through every item in the
	 * display queue, if it's address matches the parameters address then that PingDisplay is updated
	 * with the new ping time. The display area will auto change colors depending on the values sent to it.
	 * @param pingTime The ping time to report.
	 * @param address The address associated with the pingtime.
	 */
	public void reportPing(int pingTime, String address){
		for(int i = 0; i < imageQueue.size(); i++){
			if(imageQueue.get(i).name.equals(address)){
				imageQueue.get(i).setPingTime(pingTime);
			}
		}
	}
	
	/**
	 * Adds a pingDisplay to the image queue.
	 * @param d The display to add.
	 */
	public void addToQueue(PingDisplay d){
		imageQueue.addPic(d);
	}
	
	/**
	 * Removes the ping display from the image queue.
	 * @param d The ping Display to remove.
	 */
	public void removeFromQueue(PingDisplay d){
		imageQueue.remove(d);
	}
	
	/**
	 * Gets a pingDisplay from the image queue without deleting it.
	 * @param d The ping display to find
	 * @return The ping display to return. Huh?
	 */
	public PingDisplay getFromQueue(PingDisplay d){
		int index = imageQueue.indexOf(d);
		return (PingDisplay) imageQueue.get(index);
	}

	/**
	 * Paints all the components in the display area.
	 * Paints ping displays and background image.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage,(getWidth()-backgroundImage.getWidth())/2, (getHeight()-backgroundImage.getHeight())/2, null);
		paintPingDisplays(g);
	}
	
	/**
	 * Finds the background image from the file system.
	 */
	private void setupBackground(){
		URL u = this.getClass().getResource("images/logo.png");
		backgroundImage = Functions.getPic(u);
	}

	/**
	 * Paints all images in queue to screen.
	 * 
	 * @param g  The graphics context
	 */
	private void paintPingDisplays(Graphics g) {
		for (int i = 0; i < 4; i++) {
			for (int n = 0; n < 4; n++) {
				int j = Functions.convertBase4(i, n);
				
				if(imageQueue.size() > j){
					BufferedImage img = imageQueue.get(j).currentImage;
					g.drawImage(img, n * img.getWidth(), i * img.getHeight(), null);
					g.setFont(new Font("Thoma", Font.BOLD,14));
					g.setColor(Color.white);
					int width = g.getFontMetrics().stringWidth(imageQueue.get(j).name);
					int height = g.getFontMetrics().getHeight();
					g.drawString(imageQueue.get(j).name, (n * img.getWidth())+((img.getWidth()-width)/2), (i * img.getHeight())+((img.getHeight()/2)+height/2));
				}
				
			}
		}
	}

}
