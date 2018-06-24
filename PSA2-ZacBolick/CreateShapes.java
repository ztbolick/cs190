/*
 * This file creates four turtles who each draw a cube of variying size.
 * 
 * Filename: CreateShapes.java
 *
 * Created by: Zac Bolick, 5701490, ztbolick@gmail.com
 *
 * Date: 2/13/17
 */
import java.awt.Color;


public class CreateShapes
{
 public static void main (String[] args)
 {
 World w = new World (800, 800);
 Turtle t1 = new Turtle (400, 400, w);
 Turtle t2 = new Turtle (400,400,w);
 Turtle t3 = new Turtle (400,400,w);
 Turtle t4 = new Turtle (400,400,w);

   t1.drawCube(50);
   t2.drawCube(100);
   t3.drawCube(200);
   t4.drawCube(250);
 
 }
}