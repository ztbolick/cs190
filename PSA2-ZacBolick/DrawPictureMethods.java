/**
 *
 * Filename: CreateShapes.java
 *
 * Created by: Zac Bolick, 5701490, ztbolick@gmail.com
 *
 * Date: 2/13/17
 * 
 * This Java program will call the two methods one that create a colored image
 * and one that creates a striped image which the same color as the first
 */
public class DrawPictureMethods {
  
  
  public static void main(String[] args) {
    // This method creates a solid picture and takes three parameters
    Picture pic1 = new Picture();
    pic1.createSolid(125,255,46);
    pic1.explore();
    // This method creates a dashed pattern
    Picture pic2 = new Picture();
    pic2.createPattern(125,255,46);
    pic2.explore();
  }
}
