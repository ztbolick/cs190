/* Filename: PSA6.java
 * Created by: Zac Bolick
 *
 * Date:
 *
 * Description: This class is designed to take six images as input and 
 * return a collage in the porm of a picure object
 *
 */

 import java.awt.Color;

public class PSA6 {

  public static void main(String[] args) { 

	// make a bunch of picture objects
	Picture bg = new Picture("/Users/ztbolick/Documents/Code Project/cs190/PSA6/resources/landscape.jpg");
	Picture stang = new Picture("/Users/ztbolick/Documents/Code Project/cs190/PSA6/resources/stang-sized.jpg"); 
	Picture me = new Picture("/Users/ztbolick/Documents/Code Project/cs190/PSA6/resources/side-view-green1.jpg");
	Picture collage = new Picture(1184, 501);

	// Copy the Background
	for (int y = 0; y < collage.getHeight(); y++) {
		for (int x = 0; x < collage.getWidth(); x++) {
			Pixel source = bg.getPixel (x, y); 
			Pixel target = collage.getPixel (x, y);
			target.setColor(source.getColor());	
		}
	}

	for (int y = 280, y2 = 0; y2 < stang.getHeight(); y++, y2++) {
		for (int x = 585, x2 = 0; x2 < stang.getWidth(); x++, x2++) {
			Pixel source = stang.getPixel (x2, y2); 
			Pixel target = collage.getPixel (x, y);
			target.setColor(source.getColor());	
		}
	}

	for (int y = 296, y2 = 0; y2 < me.getHeight(); y++, y2++) {
		for (int x = 813, x2 = 0; x2 < me.getWidth(); x++, x2++) {
			Pixel source = me.getPixel (x2, y2); 
			Pixel target = collage.getPixel (x, y);
			target.setColor(source.getColor());
		}
	}

	collage.explore();
  }
}
