import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import javax.imageio.ImageIO;
/**
* The Image Queue to be displayed by the gui.
* @author Isaac Assegai
*
*/
public class ImageQueue extends LinkedList<BufferedImage>{
DisplayArea parent; /** The Display Area. Parent of This Class. */

/**
* Constuctor
*/
public ImageQueue(DisplayArea p){
super();
parent = p;
}

/**
* Adds a picture the the queue. If more than 16 pictures
* are present it removes the first picture before adding them.
* @param img The picture to add.
*/
public void addPic(BufferedImage img){
super.addLast(img);
	}


public void removePic(BufferedImage img){
	if (this.contains(img)){
		this.remove(this.indexOf(img));
	}
}

}
