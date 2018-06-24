import java.util.*;
import java.awt.*;

/**
 * Class that represents a turtle which is similar to a Logo turtle.
 * This class inherts from SimpleTurtle and is for students
 * to add methods to.
 *
 * Copyright Georgia Institute of Technology 2004
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class Turtle extends SimpleTurtle
{
  ////////////////// constructors ///////////////////////
  
  /** Constructor that takes the x and y and a picture to
   * draw on
   * @param x the starting x position
   * @param y the starting y position
   * @param picture the picture to draw on
   */
  public Turtle (int x, int y, Picture picture) 
  {
    // let the parent constructor handle it
    super(x,y,picture);
  }
  
  /** Constructor that takes the x and y and a model
   * display to draw it on
   * @param x the starting x position
   * @param y the starting y position
   * @param modelDisplayer the thing that displays the model
   */
  public Turtle (int x, int y, 
                 ModelDisplay modelDisplayer) 
  {
    // let the parent constructor handle it
    super(x,y,modelDisplayer);
  }
  
  /** Constructor that takes the model display
   * @param modelDisplay the thing that displays the model
   */
  public Turtle (ModelDisplay modelDisplay) 
  {
    // let the parent constructor handle it
    super(modelDisplay);
  }
  
  /**
   * Constructor that takes a picture to draw on
   * @param p the picture to draw on
   */
  public Turtle (Picture p)
  {
    // let the parent constructor handle it
    super(p);
  }  
  
  /////////////////// methods ///////////////////////


  public static void main(String[] args)
  {
    World earth = new World();
    Turtle t1 = new Turtle(earth);
    t1.forward();
  }

    public void drawRect(int width, int height) {
        this.turnRight();
        this.forward(width);
        this.turnRight();
        this.forward(height);
        this.turnRight();
        this.forward(width);
        this.turnRight();
        this.forward(height);
    }
    
    
// Draw the Z as a method
 public void drawZ(int zLength) {
   int zSlope = 125;
   this.turnRight();
   this.forward(zLength);
   this.turn(zSlope);
   this.forward(zLength + zLength/2);
   this.turn(-zSlope);
   this.forward(zLength);
   this.turnLeft();
 }
 
 
 // Drawing the A
public void drawA (int length) {
   int angle = 20;
   this.turn(angle);
   this.forward(length);
   this.turn(-angle*2);
   this.backward(length-length/2);
   this.turn(angle-90);
   this.forward(length/3);
   this.backward(length/3);
   this.turn(-angle+90);
   this.backward(length-length/2);
   this.turn(angle);
  }

 
 
  // Drawing the C
 public void drawC(int length) {
   this.penUp();
   this.turnRight();
   this.forward(100);
   this.penDown();
   this.turn(180);
 for (int i = 0; i < 20; i++) {
  this.forward(length);
  this.turn(10);
 }
 }


} // this } is the end of class Turtle, put all new methods before this


