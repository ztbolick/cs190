/**
 * PSA 1
 * Students:   Zac Bolick    5701490    ztbolick@gmail.com
 *             David Brown   1111111    davidgbrown111@gmail.com
 * 
 * In this assignment we will be drawing the name Zac. 
 * To add some simplicity to the code we have decided to make 
 * the movements into methods. Though this added some complexity
 * to the project it makes the final code much more readable.
 * 
 */
import java.awt.Color;
public class DrawZac {

 public static void main(String[] args) {
  // Create world, turtles, and colors
  World w = new World (800, 600);
  Turtle bg = new Turtle (0, 0, w);
  Turtle t = new Turtle (200, 100, w);
  Turtle c = new Turtle (440, 300, w);
  Color fuchsia = new Color (255,0,128);
  Color black = new Color (0, 0, 0);
  Color teal = new Color (3,239,250);

  // Background tutle draws our crazy pattern
  bg.turnRight();
  for (int i = 0; i <600; i++) {
   if (i % 2 == 0) {
    bg.setBodyColor(fuchsia);
   } else {
    bg.setBodyColor(black);
   }
   bg.forward(800);
   bg.turnRight();
   bg.forward(1);
   bg.turnRight();
   bg.forward(800);
   bg.turnLeft();
   bg.forward(1);
   bg.turnLeft();
  }
  
  // Create the crazy circle thing from aliasing
  c.setBodyColor(fuchsia);
  for (int i = 0; i < 361; i++) {
  c.forward(250);
  c.backward(250);
  c.turn(2);
  }
  // Get our letter turtle setup for drawing success
  t.setPenWidth(10);
  t.turn(20);
  int spacing = 20;
  t.setBodyColor(teal);
  // Actually draw letters
  t.drawZ(175);
  t.penUp();
  t.turnRight();
  t.forward(spacing);
  t.turnLeft();
  t.penDown();

  t.drawA(230);
  t.penUp();
  t.turnRight();
  t.forward(spacing);
  t.turnLeft();

  t.drawC(20);
  t.hide();
 }
}