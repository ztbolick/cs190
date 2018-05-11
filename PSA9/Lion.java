/*
 * 
 * 
 * 
 * 
 * 
 **/

import java.awt.*;

public class Lion extends Critter {
 private boolean recentFight;
 private int lionDirection;

 public Lion() {
  recentFight = false;
  lionDirection = 0;
 }

 // @Override
 public Color getColor() {
  return Color.RED;
 }

 public boolean eat() {
  if (recentFight == true) {
  return true;
  } else {
  return false;
  }
 }

 public Attack fight(String opponent) {
  if (opponent == "B") {
   recentFight = true;
   return Attack.ROAR;
  } else {
   recentFight = true;
   return Attack.POUNCE;
  }
 }
 public Direction getMove() {
  if (lionDirection < 5) {
   lionDirection++;
   return Direction.SOUTH;
  } else if (lionDirection < 10) {
   lionDirection++;
   return Direction.WEST;
  } else if (lionDirection < 15) {
   lionDirection++;
   return Direction.NORTH;
  } else if (lionDirection < 20) {
   lionDirection++;
   return Direction.EAST;
  } else {
   lionDirection = 1;
   return Direction.SOUTH;
   // recent lion direction 1 and send it south complete the loop
   // 
  }
 }

 public String toString() {
  return "L";
 }
}