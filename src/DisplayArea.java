import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
	ImageQueue imageQueue;

	/**
	 * Constructor
	 * 
	 * @param p
	 *            The Parent that contains this class.
	 */
	public DisplayArea(MainCanvas p) {
		parent = p;
		this.setPreferredSize(new Dimension(600, 350));
		this.setBackground(Color.blue);
		imageQueue = new ImageQueue(this);
		this.addMouseMotionListener(parent.parent.guiManager);
	}
	
	public void addToQueue(PingDisplay d){
		imageQueue.addPic(d);
	}
	
	public void removeFromQueue(PingDisplay d){
		imageQueue.remove(d);
	}
	
	public PingDisplay getFromQueue(PingDisplay d){
		int index = imageQueue.indexOf(d);
		return (PingDisplay) imageQueue.get(index);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintPingDisplays(g);
	}

	/**
	 * Paints all images in queue to screen.
	 * 
	 * @param g
	 *            The graphics context
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
