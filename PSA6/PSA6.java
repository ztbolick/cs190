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
	Picture p1 = new Picture("/Users/ztbolick/Documents/Code/cs190/PSA6/resources/stang.jpg");
	Picture p2 = new Picture("/Users/ztbolick/Documents/Code/cs190/PSA6/resources/pattern.jpg");
	
	
	p1.explore();
  }
}
