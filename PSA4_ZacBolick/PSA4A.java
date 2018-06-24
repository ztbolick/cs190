/* Filename: PSA4A.java
 * Created by: M. Judge
 *        and: Zac
 * Date: March 5, 2018
 *
 * Description: This class is designed to create a collage by
 * repeating a user selected picture three times, applying a 
 * different filter each time.
 *
 */

public class PSA4A
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
            
      // Select file to use for this exercise
      String fileName = FileChooser.pickAFile();
      System.out.println("File selected is: " + fileName);
      
      // Create the orignal Picture object and two copies
      Picture origPic = new Picture(fileName);
      Picture filterOnePic = new Picture( origPic );
      Picture filterTwoPic = new Picture( origPic );
      origPic.explore();
      
      // Apply filters to each part of the collage
      origPic.increaseBlue( 50 );
      filterOnePic.lighten(-7);
      filterTwoPic.mirrorVertical();
 
      // Calulate the size needed for the collage picture
      int width = origPic.getWidth();
      int height = origPic.getHeight();
      Picture collagePic = new Picture( width*3, height);
      
      // Create the collage picture & explore it
      collagePic.collage( origPic, filterOnePic, filterTwoPic );
      collagePic.explore();
      
      // Write the collage to a file
      collagePic.write("./collage_zac_michele.jpg");

    }
}

