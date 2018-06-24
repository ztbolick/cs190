/* Filename: CreateMultipleShapes.java
 * Created by: M. Judge     
 *        and: Zac
 * 
 * Date: March 7, 2018
 *
 * Description: This class prompts user for input and
 * uses it to draw a number shapes. This class
 * draws a rhombus. The size and location of each shape 
 * is input by the user.
 *
 */

import java.util.Scanner;

public class CreateMultipleShapes
{
  
  //WORLD DECLARATIONS
  public static final int WORLD_WIDTH  = 800;
  public static final int WORLD_HEIGHT = 600;            
  
  public static void main(String[] args)
  {   
    
    // Values are input by the user
    int xLocation = 0;
    int yLocation = 0;    
    int numShapes = 0;
    int size = 0;
    
    //CREATE A Scanner OBJECT CONNECTED TO System.in  
    Scanner keyboard = new Scanner(System.in);   
    
    // Ask user for number of shapes to draw, and get response
    System.out.println("How many times do you want to draw the shape?");
    numShapes = keyboard.nextInt();
    
    // Create World in which the turtles will draw shapes.
    World w = new World(WORLD_WIDTH, 
                        WORLD_HEIGHT);
    
    // Create Turtle
    Turtle pepe = new Turtle(w);  
    
    // Draw multiple shapes, asking user where they want to 
    // position the shape
    for(int index = 0; index < numShapes; index++) {
      
      // Determine the correct ordinal indicator string
      String ordIntStr;
      switch (index + 1 )
      {
        case 0: ordIntStr = "th";
        break;
        
        case 1: ordIntStr = "st";
        break;
        
        case 2: ordIntStr = "nd";
        break;
        
        case 3: ordIntStr = "rd";
        break;
        
        default: ordIntStr = "th";
      }
      
      // Ask user where to position the shapes, and get response
      System.out.print("Please enter the x position for the "
                         + (index+1) + ordIntStr + " of " 
                         + numShapes + " shapes. \n");
      xLocation = keyboard.nextInt();
      
      // Ask user where to position the shapes, and get response
      System.out.print("Please enter y position for the "
                         + (index+1) + ordIntStr + " of " 
                         + numShapes + " shapes. \n");
      yLocation = keyboard.nextInt();
      
      // Ask user for size to draw, and get response
      System.out.println("Please enter the length of one side as an integer: ");
      size = keyboard.nextInt();
      
      // Postion the turtle
      pepe.penUp();
      pepe.moveTo(xLocation, 
                  yLocation);
      pepe.penDown();
      
      // Draw the shape
      pepe.drawShape(size);
      
      // Hide the turtle
      pepe.hide();
    }  
  }
}