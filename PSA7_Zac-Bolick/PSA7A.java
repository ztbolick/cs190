/**
 * PSA7A.java
 *
 * Created by: Zac Bolick, Huy Ha
 *
 * Date: 04/23/18
 *
 *
 */

import java.util.Scanner;
import java.awt.Color;

public class PSA7A
{
  public static void main(String[] args)
  {
    /* Connecting a Scanner object to the keyboard */
    Scanner keyboard = new Scanner(System.in);
    Color[] boxColors = {Color.RED, Color.GREEN, Color.BLUE};
    
    /* Choosing a picture and initializing variables. */
    Picture pic = new Picture(FileChooser.pickAFile());
    int x, y, width, height;
    pic.show();
    int pictureWidth = pic.getWidth();
    int pictureHeight = pic.getHeight();
    System.out.println("Picture loaded - width: " + pictureWidth +" height: "+ pictureHeight);
    
    // Attempt to draw 3 boxes
    int boxesDrawn = 0;
    while (boxesDrawn < 3)
    {
      /* Prompting the user for coordinates. */
      String prompt = "Please enter the upper left corner (first x, then y) of ";
      String prompt2 = "the box to draw.";
      System.out.println(prompt + prompt2);
      
      
      /* Converting coordinates to ints. */
      x = keyboard.nextInt();
      y = keyboard.nextInt();
      
      
      /* Prompting the user for width and height. */
      System.out.println("Please enter the width of the box to flip.");
      width = keyboard.nextInt();
      
      System.out.println("Please enter the height of the box to flip.");
      height = keyboard.nextInt();
      
      // Check if input is within bounds before drawing
      if (x < pictureWidth && y < pictureHeight && x + width < pictureWidth && y + height < pictureHeight
        && x + width > 0 && y + height > 0 && x > 0 && y > 0) {
        pic.drawBoxAtOffset (x, y, width, height, boxColors[boxesDrawn]);
        
        /* Repainting the picture with the box drawn. */
        pic.repaint();
        
        // Draw the box
        boxesDrawn++;
      }
      else {
        String error = "ERROR: Range is out of bound. Please choose a range that is within (0,0) and ";
        System.out.println(error + "(" + pictureWidth + ", " + pictureHeight + ")" + "!!!");
      }
    }
  }
}