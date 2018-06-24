/*
 * Filename: PSA3A.java
 * Created by: Zac Bolick,   5701490,   ztbolick@gmail.com
 *    and: Artis Dawkins,    5566017,   dawkins0126@aol.com
 *
 * Date: 2/28/17
 *
 * Description: This class is designed subtract color from an image using integers passed by the user
 *
 */

public class PSA3A
{
 public static void main (String[] args)
 {
  // Create picture objects
  Picture original = new Picture (FileChooser.pickAFile());
  Picture copy = new Picture(original);
  
  // Call method and pass parameters
  copy.subtractColor(255, 150, 0);
  
  // Explore the pictures
  original.explore();
  copy.explore();
 }
}