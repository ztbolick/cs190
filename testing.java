/*
 *
 *
 *
 *
 */

	import java.awt.Color;

public class testing {

  public static void main(String[] args) {
	Picture p1 = new Picture("/Users/ztbolick/Documents/Code/cs190/PSA5/resources/eagle.jpg");
	Picture p2 = new Picture(500,500);
	Color red = new Color (255, 0, 0);
	Color green = new Color (0, 255, 0);
	Color blue = new Color (0, 0, 254);


	for (int y = 0; y < p1.getHeight(); y++) {
		for (int x = 0; x < p1.getWidth(); x++) {
			Pixel OGPix = p1.getPixel(x, y);
			Pixel NGPix = p2.getPixel(x, y);
			if (OGPix.getBlue() > 250) {
				NGPix.setColor(green);
			} else {
				NGPix.setColor(red);
			}
		}
	}

	p1.explore();
	p2.explore();

  }
}