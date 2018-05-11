import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.awt.Color;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
 /**
   * Method that takes a picture object as input and copies it to the calling picture object
   * If the picture being passed has green content greater than the green threshold it will be copied
   * @param threshholdGreen, the threshold at which a pixel is too green and will not be copied
   * @param sauce, the source picture that will be copied to the calling picture object
   * @param startX, x coordinet on the calling object that will start the copying
   * @param startY, y coordinet on the calling object that will start the copying
   * @param customColor, a green color object that is evaluated using color distance
   * 
   */

  public void chromakeyGreen (int threshholdGreen, Picture sauce, int startX, int startY, Color customColor) {

    // Horizontal Loop
    for (int x = 0, x2 = startX; x < sauce.getWidth(); x++, x2++) {

      // Verticle Loop
      for (int y = 0, y2 = startY; y < sauce.getHeight(); y++, y2++) {

        // Create Pixel for target and sauce pix from x,y and x2, y2
        Pixel targetPix = this.getPixel(x2, y2);
        Pixel saucePix = sauce.getPixel(x, y);

        // If the distance from saucePix to customColor is greater than the threashhold
        // replace the color of targetPix with the color from saucePix
        if (saucePix.colorDistance(customColor) > threshholdGreen) {
          targetPix.setColor(saucePix.getColor());
        }
      }
    }
  }

 /**
   * Method that takes a picture object as input and copies it to the calling picture object
   * If the picture being passed has green content greater than the green threshold it will be copied
   * @param threshholdBlue, the threshold at which a pixel is too green and will not be copied
   * @param sauce, the source picture that will be copied to the calling picture object
   * @param startX, x coordinet on the calling object that will start the copying
   * @param startY, y coordinet on the calling object that will start the copying
   * @param customColor, a blue color object that is evaluated using color distance
   * 
   */
  
  public void chromakeyBlue (int threshholdBlue, Picture sauce, int startX, int startY, Color customColor) {

    // Horizontal Loop
    for (int x = 0, x2 = startX; x < sauce.getWidth(); x++, x2++) {

      // Verticle Loop
      for (int y = 0, y2 = startY; y < sauce.getHeight(); y++, y2++) {

        // Create Pixel for target and sauce pix from x,y and x2, y2
        Pixel targetPix = this.getPixel(x2, y2);
        Pixel saucePix = sauce.getPixel(x, y);

        // If the distance from saucePix to customColor is greater than the threashhold
        // replace the color of targetPix with the color from saucePix
        if (saucePix.colorDistance(customColor) > threshholdBlue) {
          targetPix.setColor(saucePix.getColor());
        }
      }
    }
  }
  
  public static void main(String[] args) 
  {
    String fileName = FileChooser.pickAFile();
    Picture pictObj = new Picture(fileName);
    pictObj.explore();
  }
}
