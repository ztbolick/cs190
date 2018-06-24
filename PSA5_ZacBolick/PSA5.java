/* Filename: PSA5.java
 * Created by: Zac Bolick
 * CSIDL: 5701490
 *
 * Date: 4/4/18
 *
 * Description: This PSA is designed to use a static method createCollage to make a collage
 * this is returned as a picture object. More details about the method can be found in Picture.java enjoy!
 *
 */

import java.awt.Color;

public class PSA5 {
  
  public static void main(String[] args) { 
    
    // Make a bunch of picture objects
    Picture p1 = new Picture("./resources/background.jpg");
    Picture p2 = new Picture("./resources/lawnmower.jpg");
    Picture p3 = new Picture("./resources/eagle.jpg");
    Picture p4 = new Picture("./resources/eagle2.jpg");
    Picture p6 = new Picture("./resources/burger.jpg");
    Picture p5 = new Picture("./resources/lady.jpg");
    Picture p7 = new Picture("./resources/America.jpg");
    
    // Filter Images
    p1.yoloBear();
    p3.exposure(-8);
    p5.mirrorVertical();
        
    // Call static method
    Picture collage = Picture.createCollage(p1,p2,p3,p4,p5,p6, p7);
    collage.explore();
  }
}
