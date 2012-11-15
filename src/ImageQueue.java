import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import javax.imageio.ImageIO;

/**
 * The Image Queue to be displayed by the gui.
 * 
 * @author Isaac Travers
 * 
 */
public class ImageQueue extends LinkedList<PingDisplay> {
	DisplayArea parent;

	/** The Display Area. Parent of This Class. */

	/**
	 * Constuctor
	 */
	public ImageQueue(DisplayArea p) {
		super();
		parent = p;
	}

	/**
	 * Adds a picture the the queue. If more than 16 pictures are present it
	 * removes the first picture before adding them.
	 * 
	 * @param img
	 *            The picture to add.
	 */
	public void addPic(PingDisplay img) {
		super.addLast(img);
	}

	/**
	 * Removes an image from the queue.
	 * @param img The image to remove
	 */
	public void removePic(PingDisplay img) {
		if (this.contains(img)) {
			this.remove(this.indexOf(img));
		}
	}

	/**
	 * Checks to see if the queue contains an image with the passed in name.
	 * @param name The passed in name.
	 * @return True or False.
	 */
	public boolean containsName(String name) {
		boolean value = false;
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).name.equals(name)) {
				value = true;
				return value;
			}
		}
		return value;
	}

	/**
	 * Removes a picture from the image queue if it has this same name.
	 * @param name The address to remove.
	 */
	public void removeName(String name) {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).name.equals(name)) {
				this.remove(i);
			}
		}
	}

}
