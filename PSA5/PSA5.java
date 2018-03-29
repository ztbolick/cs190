/**
 * Auto Generated Java Class.
 */
import java.awt.Color;

public class Derp {
  public static void main(String[] args) { 
	Picture p1 = new Picture("/Users/ztbolick/Downloads/PSA5/resources/a.jpg");
	Picture p2 = new Picture("/Users/ztbolick/Downloads/PSA5/resources/b.jpg");
	Picture p3 = new Picture("/Users/ztbolick/Downloads/PSA5/resources/c2.jpg");
	Picture p4 = new Picture("/Users/ztbolick/Downloads/PSA5/resources/d.jpg");
	Picture p5 = new Picture("/Users/ztbolick/Downloads/PSA5/resources/f.jpg");
	Picture p6 = new Picture("/Users/ztbolick/Downloads/PSA5/resources/e.jpg");
	
	Picture collage = new Picture(684,504);
	
	Pixel sourcePix = null;
	Pixel targetPix = null;

	Color blue = new Color(0, 0, 255);
	
	// Copy the first image as background
	for (int y = 0; y < p1.getHeight(); y++) {
		for (int x =0; x < p1.getWidth(); x++) {
			sourcePix = p1.getPixel(x, y);
			targetPix = collage.getPixel(x, y);
			targetPix.setColor(sourcePix.getColor());
		}
	}
	
	// copy second image
	for (int y1 = 0, y2 = 0; y2 < p2.getHeight(); y1++, y2++) {
		for (int x1 = 459, x2 = 0; x2 < p2.getWidth(); x1++, x2++) {
			sourcePix = p2.getPixel(x2, y2);
			targetPix = collage.getPixel(x1, y1);
			targetPix.setColor(sourcePix.getColor());
		}
	}

	// copy third image
	for (int y1 = (collage.getHeight()/4) * 3, y2 = 0; y2 < p3.getHeight(); y1++, y2++) {
		for (int x1 = 0, x2 = 0; x2 < p3.getWidth(); x1++, x2++) {
			sourcePix = p3.getPixel(x2, y2);
			targetPix = collage.getPixel(x1, y1);
			if (sourcePix.getColor() == blue) {
				System.out.println("yey");
			} else {
				targetPix.setColor(sourcePix.getColor());
				//System.out.println("boo");
			}
		}
	}

	// copy forth image
	for (int y1 = 350, y2 = 0; y2 < p4.getHeight(); y1++, y2++) {
		for (int x1 = 500, x2 = 0; x2 < p4.getWidth(); x1++, x2++) {
			sourcePix = p4.getPixel(x2, y2);
			targetPix = collage.getPixel(x1, y1);
			targetPix.setColor(sourcePix.getColor());
		}
	}

	// copy forth image
	for (int y1 = 325, y2 = 0; y2 < p5.getHeight(); y1++, y2++) {
		for (int x1 = 250, x2 = 0; x2 < p5.getWidth(); x1++, x2++) {
			sourcePix = p5.getPixel(x2, y2);
			targetPix = collage.getPixel(x1, y1);
			targetPix.setColor(sourcePix.getColor());
		}
	}

	// copy forth image
	for (int y1 = 10, y2 = 0; y2 < p6.getHeight(); y1++, y2++) {
		for (int x1 = 26, x2 = 0; x2 < p6.getWidth(); x1++, x2++) {
			sourcePix = p6.getPixel(x2, y2);
			targetPix = collage.getPixel(x1, y1);
			targetPix.setColor(sourcePix.getColor());
		}
	}
	
	collage.explore();
  }
}
