import java.awt.*;
import java.lang.Math;
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

public class PSA3B
{
  public static void main (String[] args)
  {
    // Create picture objects
    Picture pic = new Picture (FileChooser.pickAFile());
    int third = pic.getPixels().length/3;
    pic.explore();
    pic.negative(0, third);
    pic.greyScale(third, third*2);
    pic.myFilter(third*2, third*3, 5);
    pic.explore();    
  }
}