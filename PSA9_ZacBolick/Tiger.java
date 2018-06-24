import java.awt.Color;
import java.lang.Object.*;
import java.util.*;

public class Tiger extends Critter {
  private int eatCount;
  private int tigerDir;
  private int tigerMove;
  private static Random tigerRan = new Random();
  
  
  public Tiger(int hunger) {
    eatCount = hunger;
    tigerMove = 0;
  }
  
  public boolean eat() {
    if (eatCount > 0) {
      eatCount--;
      return true;
    }
    else 
      return false;
 }

 public Attack fight(String opponent) {
   if (eatCount > 0)
     return Attack.SCRATCH;
   else
     return Attack.POUNCE;
 }

 public Color getColor() {
  return Color.YELLOW;
 }

 public Direction getMove() {
  tigerMove++;
  if (tigerMove % 3 ==0)
    tigerDir = tigerRan.nextInt(4);
  if (tigerDir == 0)
    return Direction.EAST;
  else if (tigerDir == 1)
    return Direction.SOUTH;
  else if (tigerDir == 2)
    return Direction.NORTH;
  else
    return Direction.WEST;
  
 }

 public String toString() {
   String tally = "" + eatCount;
  return tally;
 }
  
}