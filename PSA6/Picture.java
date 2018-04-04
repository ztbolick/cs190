import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

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
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  
  public static void main(String[] args) 
  {
    String fileName = FileChooser.pickAFile();
    Picture pictObj = new Picture(fileName);
    pictObj.explore();
  }
  
  
  /*
   * This method creates a collage of seven images!
   * all paramaters are pictures and below is a breif description of their location in the final collage
   * @param1 background image
   * @param2 top left
   * @param3 bottom left
   * @param4 bottom right
   * @param5 bottom middle
   * @param6 bottom left
   * @param7 top right
   */
  
  public static Picture createCollage (Picture bg, Picture stang,
                                       Picture me) {
    
    Picture collage = new Picture(684,504);
    
    Pixel sourcePix = null;
    Pixel targetPix = null;
    
    // Copy the Background
    for (int y = 0; y < collage.getHeight(); y++) {
      for (int x = 0; x < collage.getWidth(); x++) {
        Pixel source = bg.getPixel (x, y); 
        Pixel target = collage.getPixel (x, y);
        target.setColor(source.getColor()); 
      }
    }
    
    // Copy stang
    for (int y = 280, y2 = 0; y2 < stang.getHeight(); y++, y2++) {
      for (int x = 585, x2 = 0; x2 < stang.getWidth(); x++, x2++) {
        Pixel source = stang.getPixel (x2, y2); 
        Pixel target = collage.getPixel (x, y);
        target.setColor(source.getColor()); 
      }
    }
    
    // copy me
    for (int y = 296, y2 = 0; y2 < me.getHeight(); y++, y2++) {
      for (int x = 813, x2 = 0; x2 < me.getWidth(); x++, x2++) {
        Pixel source = me.getPixel (x2, y2); 
        Pixel target = collage.getPixel (x, y);
        target.setColor(source.getColor());
      }
    }
    
    collage.explore();
    return collage;    
  }
  
  
  
  
  
  public void chromakeyGreen(int threshholdGreen, Picture sauce) {
    
    // Copy first image: background
    for (int y = 0; y < this.getHeight(); y++) {
      for (int x =0; x < this.getWidth(); x++) {
        // Make some pixels for the copying
        Pixel targetPix = this.getPixel(x,y);
        Pixel saucePix = sauce.getPixel(x,y);
        // find some color ranges
        if (saucePix.colorDistance(Color.GREEN) > threshholdGreen) {
          targetPix.setColor(sourcePix.getColor());
        }
      }
    }
  }
  
  public void chromakeyBlue(int threshholdBlue, Picture sauce) {
    
    // Copy first image: background
    for (int y = 0; y < this.getHeight(); y++) {
      for (int x =0; x < this.getWidth(); x++) {
        // Make some pixels for the copying
        Pixel targetPix = this.getPixel(x,y);
        Pixel saucePix = sauce.getPixel(x,y);
        // find some color ranges
        if (saucePix.colorDistance(Color.BLUE) > threshholdBlue) {
          targetPix.setColor(sourcePix.getColor());
        }
      }
    }
  }
  
  
}
