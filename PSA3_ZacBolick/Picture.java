import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from 
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
    // Main method
  }
  
  /*
   * This method subtracts color from an image, it takes three paramaters
   * @param red is an integer 0-255
   * @param green is an integer 0-255
   * @param blue is an integer 0-255
   * If a 0 is passed the color will be unaffected.
   */
  
  public void subtractColor (int red, int green, int blue)
  {
    // Create array and variables
    Pixel[] pixelArray = this.getPixels();
    int i = 0;
    while (i < pixelArray.length) 
    {
      Pixel pix = pixelArray[i];
      int oldRed = 0, oldGreen = 0, oldBlue = 0;
      
      // Create variable to store the original color values
      oldRed = pix.getRed();
      oldGreen = pix.getGreen();
      oldBlue = pix.getBlue();
      
      // subtract the user passed values from the original 
      // values and set the color after subtracting
      pix.setRed(oldRed - red);
      pix.setGreen(oldGreen - green);
      pix.setBlue(oldBlue - blue);
      i++;
    }
    
  }
  
  /*
   * This method finds the median gray for a pixel then modifies the brightness using a passed integer value
   * @param start is an integer that specifies the starting index you would like to modify
   * @param end is an integer that specifies the index you would your modification to end at
   * @param intensity is an integer between -10 & 10 and specifies the amount the image will be brightened/darkened
   */
  
  public void myFilter(int start, int end, int intensity)
  {
    // Create variables
    Pixel[] pixelArray = this.getPixels();
    
    // This will loop through the pixel array and subtract by 50% the green value
    while (start < end) 
    {
      Pixel pix = pixelArray[start];
      int kvalue = (int) (pix.getRed() + pix.getBlue() + pix.getGreen())/3;
      kvalue = kvalue / 10;
      kvalue = kvalue * intensity;
      pix.setRed(pix.getRed() + kvalue);
      pix.setGreen(pix.getGreen() + kvalue);
      pix.setBlue(pix.getBlue() + kvalue);
      start++;
    }
  }
  
  /*
   * This method makes an image appear as a negative, it takes two paramaters
   * @param start is an integer that specifies the starting index you would like to modify
   * @param end is an integer that specifies the index you would your modification to end at
   */
  
  public void negative(int start, int end)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pix = null;
    int redValue = 0, blueValue = 0, greenValue = 0;
    
    while (start < end) {
      pix = pixelArray[start];
      Color negative = new Color(255 - pix.getRed(), 255 - pix.getGreen(), 255 - pix.getBlue());
      pix.setColor(negative);
      start++;
    }
  }
  
  /*
   * This method makes an image appear greyscale, it takes two paramaters
   * @param start is an integer that specifies the starting index you would like to modify
   * @param end is an integer that specifies the index you would your modification to end at
   */
  
  public void greyScale(int start, int end) {
    Pixel[] pixelArray = this.getPixels();
    int kvalue = 0;
    Pixel pix = null;
    
    while (start < end) {
      pix = pixelArray[start];
      kvalue = (int) (pix.getRed() + pix.getBlue() + pix.getGreen())/3;
      pix.setColor(new Color(kvalue, kvalue, kvalue));
      start++;
    }  
  } 
  
}  // this } is the end of class Picture, put all new methods before this