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


	for (int i = 0; i < p1.getHeight(); i++) {
		for (int j = 0; j < p1.getWidth(); j++) {
			Pixel OGPix = p1.getPixel(i, j);
			Pixel NGPix = p2.getPixel(i, j);
			if (NGPix.getColor() == blue) {
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