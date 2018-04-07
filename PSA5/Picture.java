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

  public static Picture createCollage (Picture p1, Picture p2,
                                       Picture p3, Picture p4, 
                                       Picture p5, Picture p6,
                                       Picture p7) {
    
    Picture collage = new Picture(684,504);
    Color darkBlue = new Color (0,0,190);
    
    Pixel sourcePix = null;
    Pixel targetPix = null;
    
    // Copy first image: background
    for (int y = 0; y < p1.getHeight(); y++) {
      for (int x =0; x < p1.getWidth(); x++) {
        sourcePix = p1.getPixel(x, y);
        targetPix = collage.getPixel(x, y);
        targetPix.setColor(sourcePix.getColor());
      }
    }

    // copy seventh image: America text
    for (int y1 = 0, y2 = 0; y2 < p7.getHeight(); y1++, y2++) {
      for (int x1 = 90, x2 = 0; x2 < p7.getWidth(); x1++, x2++) {
        sourcePix = p7.getPixel(x2, y2);
        targetPix = collage.getPixel(x1, y1);
        // if the pixel is green don't copy it
        if (sourcePix.colorDistance(Color.GREEN) > 80) {
          targetPix.setColor(sourcePix.getColor());
        }
      }
    }
    
    // copy second image: lawnmower
    for (int y1 = 0, y2 = 0; y2 < p2.getHeight(); y1++, y2++) {
      for (int x1 = 0, x2 = 0; x2 < p2.getWidth(); x1++, x2++) {
        sourcePix = p2.getPixel(x2, y2);
        targetPix = collage.getPixel(x1, y1);
        // if the pixel is blue don't copy it
        if (sourcePix.colorDistance(Color.BLUE) > 25) {
          targetPix.setColor(sourcePix.getColor());
        }
      }
    }
    
    // copy sixth image: burger
    for (int y1 = 250, y2 = 0; y2 < p6.getHeight(); y1++, y2++) {
      for (int x1 = 0, x2 = 0; x2 < p6.getWidth(); x1++, x2++) {
        sourcePix = p6.getPixel(x2, y2);
        targetPix = collage.getPixel(x1, y1);
        if (sourcePix.colorDistance(Color.BLUE) > 25) {
          targetPix.setColor(sourcePix.getColor());
        }
      }
    }

    // copy third image: eagle looking right
    for (int y1 = (collage.getHeight()/4) * 3, y2 = 0; y2 < p3.getHeight(); y1++, y2++) {
      for (int x1 = 0, x2 = 0; x2 < p3.getWidth(); x1++, x2++) {
        sourcePix = p3.getPixel(x2, y2);
        targetPix = collage.getPixel(x1, y1);
        if (sourcePix.colorDistance(darkBlue) > 25) {
          targetPix.setColor(sourcePix.getColor());
        }
        
        if (sourcePix.getBlue() < 240 && sourcePix.getRed() > 16 && sourcePix.getGreen() > 16) {
          targetPix.setColor(sourcePix.getColor());
        } 
      }
    }
    
    // copy forth image: eagle looking left
    for (int y1 = 350, y2 = 0; y2 < p4.getHeight(); y1++, y2++) {
      for (int x1 = 500, x2 = 0; x2 < p4.getWidth(); x1++, x2++) {
        sourcePix = p4.getPixel(x2, y2);
        targetPix = collage.getPixel(x1, y1);
        if (sourcePix.colorDistance(Color.BLUE) > 60) {
          targetPix.setColor(sourcePix.getColor());
        }
      }
    }
    
    // copy five image: lady on keg scooter
    for (int y1 = 325, y2 = 0; y2 < p5.getHeight(); y1++, y2++) {
      for (int x1 = 225, x2 = 0; x2 < p5.getWidth(); x1++, x2++) {
        sourcePix = p5.getPixel(x2, y2);
        targetPix = collage.getPixel(x1, y1);
        if (sourcePix.colorDistance(Color.BLUE) > 25) {
          targetPix.setColor(sourcePix.getColor());
        }
      }
    } 
    return collage;    
  }
  

  /*
   * This method makes images have an american feel, by creating red, white, and blue stripes
   * it does not take any input but what it gives back is something truely special!!!
   */

  public void yoloBear() 
  {
    
    for(int y = 0; y < this.getHeight(); y++)
    {
      for(int x = 0; x < this.getWidth() - 5; x++)
      {
       // Designate pixels for modification indexed n, n+2, n+4
        Pixel p = this.getPixel(x,y);
        Pixel p2 = this.getPixel(x + 2,y);
        Pixel p3 = this.getPixel(x + 4,y);

        // modulo runs the modification if the coordinet is a factor of 5
        if (x % 5 == 0) {
          p.setRed((int) (p.getRed() * 3));
          
          p2.setRed((int) (p2.getRed() * 3));
          p2.setGreen((int) (p2.getGreen() * 3));
          p2.setBlue((int) (p2.getBlue() * 3));
          
          p3.setBlue((int) (p3.getBlue() * 3));
          
        }
      }
    }
  } 
  
  
  /*
   * This method finds the median gray for a pixel then modifies the brightness using a passed integer value
   * @param intensity is an integer between -10 & 10 and specifies the amount the image will be brightened/darkened
   */

  public void exposure(int intensity)
  {
    // Create variables
    Pixel[] pixelArray = this.getPixels();
    int start = 0;
    
    // This will loop through the pixel array
    while (start < pixelArray.length) 
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
  
  /*
   * This method takes the midpoint of an image along the x axis and copies 
   * all of the pixels in it to the opposit side. It does not take any input.
   */
  
  public void mirrorVertical()
  {
    int mirrorPoint = (int)(getWidth()/2);
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    
    // loop through the rows
    for(int y = 0;y < getHeight(); y++)
    {
      // loop from 1 to just before the mirrorpoint
      for(int x = 1; x < mirrorPoint; x++)
      {
        leftPixel = this.getPixel((mirrorPoint - x), y);
        rightPixel = this.getPixel((mirrorPoint + x), y);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  } 

  
}
