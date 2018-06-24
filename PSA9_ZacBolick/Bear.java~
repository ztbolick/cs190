/**
 * PSA9 BEAR CLASS
 * GROUP: FIRST ROW
 */

import java.awt.Color; // need this to be able to use Color

public class Bear extends Critter {
  
  private int numMoves = 0;
  
  
  //this color is brown, default is grizzly bear
  private Color   myColor   = new Color(190,110,50);
  
  public Bear(boolean grizzly) {
    if(!grizzly) {
      //if not a grizzly, then polar bear
      myColor = Color.WHITE;
    }   
  }
  
  public Color getColor() {
    
    return myColor;
    
  }
  
  // bears always return true
  @Override
  public boolean eat() {
    return true;
  }
  // bears always scratch
  @Override
  public Attack fight(String opponent) {
    return Attack.SCRATCH;
  }
  
  @Override
  public Direction getMove() {
    // Alternates between north and west move beginning with north
    if(numMoves % 2 == 0){
      numMoves++;
      return Direction.NORTH;
    }
    else{
      numMoves++;
      return Direction.WEST;
    }
  }
  
  
  @Override
  public String toString() {
    return "B";
  } 
}