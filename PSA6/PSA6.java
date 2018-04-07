/* Filename: PSA6.java
 * Created by: Zac Bolick
 *
 * Date:
 *
 * Description: This class is designed to take six images as input and 
 * return a collage in the porm of a picure object
 *
 */

import java.awt.Color;

public class PSA6 {
  
  public static void main(String[] args) { 
    
    // make a bunch of picture objects
    Picture bg = new Picture("./resources/landscape.jpg");
    Picture stang = new Picture("./resources/stang-sized.jpg"); 
    Picture me = new Picture("./resources/side-view-green1.jpg");
    Picture pattern = new Picture ("./resources/pattern.jpg");
    Picture collage = new Picture(1184, 501);
    
    Color customBlue = new Color (0,0, 115);
    
    bg.chromakeyGreen(175, stang, 600*2, 273*2);
    bg.chromakeyGreen(175, me, 1615, 570);
    me.chromakeyBlue(20, pattern, 0, 0, customBlue);
    me.explore();
    //bg.explore();
    
    
    
    
    
  }
}
