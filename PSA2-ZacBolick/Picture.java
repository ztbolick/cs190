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
  
  public void increaseRed()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    
    int value = 0;
    int index = 0;
    
    while (index < pixelArray.length)
    {
     pixel = pixelArray[index];
     value = pixel.getRed();
     value = (int) (value * 1.8);
     pixel.setRed(value);
     index++;
    }
  }
  /*
   * This method take three parameters red, green, and blue 
   * then uses them to make a colored picture using a for each loop
   */
  
  public void createSolid(int r, int g, int b)
  {    
    Pixel[] pixelArray = this.getPixels();
    Color myColor = new Color (r, g, b);
    
    for (Pixel pix : pixelArray)
    {
      pix.setColor(myColor);
    }
  }
  
  /*
   *  This method take three parameters red, green, and blue 
   * then uses them to make a stripped picture using two while loops
   * one iterates over the even digits the other over the odd digits
   */
  
  public void createPattern(int r, int g, int b)
  {
    // convert image matrix into pixel array
    Pixel[] pixelArray = this.getPixels();
    
    // Initialize color variables
    Color myColor = new Color (r, g, b);
    Color black = new Color (0,0,0);
    
    // Pix will store the individual pixel in the
    Pixel pix = null;
    int index = 0;
    while (index < pixelArray.length)
    {
      pix = pixelArray[index];
      pix.setColor(myColor);        
      index+= 2;
    }
    
    index = 1;
    while (index < pixelArray.length)
    {
      pix = pixelArray[index];
      pix.setColor(black);
      index += 2;
    }
  }
    
} // this } is the end of class Picture, put all new methods before this
 