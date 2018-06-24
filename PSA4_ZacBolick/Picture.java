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
  
  /**
   * Method to create a collage from three Picture objects.
   * @param p1 the first, left-most pic to include in the collage
   * @param p2 the second, middle pic to include in the collage
   * @param p3 the third, right-most pic in the collage
   * 
   */
  public void collage( Picture p1, 
                       Picture p2, 
                       Picture p3)
  {
    
    // pixelCanvas is the selected pixel on the canvas, the pixel
    // which is being copied from the original picture 
    Pixel pixelCanvas;
    
    // Initialize integers to store the return of getWidth and getHeight
    int p1Width = p1.getWidth();
    int p1Height = p1.getHeight();
    
    // Loop through the picture matrix, copying the color
    
    for (int sourceX = 0, targetX = 0;
         sourceX < p1Width;
         sourceX++, targetX++)
    {
      for (int sourceY = 0, targetY = 0;
           sourceY < p1Height;
           sourceY++, targetY++)
      {
        Pixel pixelP1 = p1.getPixel(sourceX, sourceY);
        pixelCanvas = this.getPixel(targetX, targetY);
        pixelCanvas.setColor(pixelP1.getColor());
      }
    }
    
    // Copy Picture p2 to the canvas
    int widthP2 = p2.getWidth();
    int heightP2 = p2.getHeight();
    int x2 = 0;
    int y2 = 0;
    
    Pixel pixelP2;
    
    // Copying p2 to the middle picture, begins after p1
    int p2Offset = p1.getWidth();
    
    // Do the copy! 
    for ( x2 = 0; x2 < widthP2; x2++ ) 
    {
      for ( y2 =0; y2 < heightP2; y2++ )
      {
        pixelP2 = p2.getPixel(x2, y2);
        pixelCanvas = this.getPixel( p2Offset + x2, y2);
        pixelCanvas.setColor(pixelP2.getColor());
      }
    }

    // Copy Picture p2 to the canvas
    int widthP3 = p3.getWidth();
    int heightP3 = p3.getHeight();
    int x3 = 0;
    int y3 = 0;
    
    Pixel pixelP3;
    
    // Copying p3 to the rightmost picture, begins after p2
    int p3Offset = p2Offset + p2.getWidth();
    
    // Do the copy! 
    for ( x3 = 0; x3 < widthP3; x3++ ) 
    {
      for ( y3 =0; y3 < heightP3; y3++ )
      {
        pixelP3 = p3.getPixel(x3, y3);
        pixelCanvas = this.getPixel( p3Offset + x3, y3);
        pixelCanvas.setColor(pixelP3.getColor());
      }
    }
    
  }
  
  
  /**
   * Method to increase the blue value in a picture by the 
   * specified amount.
   * @param blue the amount to increase the blue value
   **/
  public void increaseBlue ( int addBlue )
  {
    Pixel[] pixelArray = this.getPixels();
    int index = 0;
    int length = pixelArray.length;
    while ( index < length)
    {
      //Set the RGB value
      int value = pixelArray[index].getBlue() + addBlue;
      pixelArray[index].setBlue( value );
      index++;
    }  
  }
  
  /*
   * This method finds the median gray for a pixel then modifies the brightness using a passed integer value
   * @param intensity is an integer between -10 & 10 and specifies the amount the image will be brightened/darkened
   */
  
  public void lighten(int intensity)
  {
    // Create variables
    Pixel[] pixelArray = this.getPixels();
    int i = 0;
    
    // This will loop through the pixel array and subtract by 50% the green value
    while (i < pixelArray.length) 
    {
      Pixel pix = pixelArray[i];
      int kvalue = (int) (pix.getRed() + pix.getBlue() + pix.getGreen())/3;
      kvalue = kvalue / 10;
      kvalue = kvalue * intensity;
      pix.setRed(pix.getRed() + kvalue);
      pix.setGreen(pix.getGreen() + kvalue);
      pix.setBlue(pix.getBlue() + kvalue);
      i++;
    }
  }
  
  public void mirrorVertical()
  {
    int mirrorPoint = (int)(getWidth()/2);
    Pixel leftPixel = null;
    Pixel rightPixel = null;
// loopthroughtherows
    for(int y = 0;y < getHeight(); y++)
    {
// loop from 1 to just before the mirrorpoint
      for(int x=1; x < mirrorPoint; x++)
      {
        leftPixel = getPixel((mirrorPoint - x), y);
        rightPixel = getPixel((mirrorPoint + x), y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  
  public static void main(String[] args) 
  {
    String fileName = FileChooser.pickAFile();
    Picture pictObj = new Picture(fileName);
    pictObj.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
