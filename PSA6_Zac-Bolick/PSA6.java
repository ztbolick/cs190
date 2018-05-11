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
    Picture stang = new Picture("./resources/stang-sized-1.jpg"); 
    Picture me = new Picture("./resources/me2.jpg");
    Picture pattern = new Picture ("./resources/pattern.jpg");
    Picture peopleRunning = new Picture ("./resources/business_people_running.jpg");
    Picture businessGuy = new Picture ("./resources/business-man-running.jpg");
    Picture healthBar = new Picture ("./resources/healthbar.jpg");
    
    // Create two colors for the blue and green screen
    Color customBlue = Color.BLUE;
    Color customGreen = Color.GREEN;
    
    // Call the chromakeyX methods to remove the backgrounds and copy images into place
    bg.chromakeyGreen(175, stang, 1200, 546, customGreen);
    bg.chromakeyBlue(180, peopleRunning, 252, 526, customBlue);
    bg.chromakeyBlue(170, businessGuy, 2200, 624, customBlue);
    bg.chromakeyGreen(170, healthBar, 1700, 50, customGreen);
    pattern.chromakeyBlue(100, me, 0, 0, customBlue);
    bg.chromakeyGreen(150, pattern, 1550+25-3, 525+10+3, customGreen);
    
    // Show the copied images
    bg.explore();
    bg.write("./collage_zac.jpg");
  }
}
