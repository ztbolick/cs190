import java.awt.Color;
import java.lang.Object.*;
import java.util.*;

public class Zombie extends Critter {
		
		// Variables
		private int zombieDir;
		private int zombieChar;
		private int totalMoves;
		private static Random randomInt = new Random();


	public Color getColor() {
		return Color.RED;
	}
		
	public Zombie(int hunger) {
	}
		
	public boolean eat() {
		if (totalMoves > 200) {
			return true;
		}
		else 
			return false;
	}

	public Attack fight(String opponent) {
		if (opponent == "B") {
			return Attack.ROAR;
		} else if (opponent == "L") {
			return Attack.SCRATCH;
		} else if (opponent == "1" || opponent == "2" || opponent == "3" || opponent == "4" || opponent == "5" || 
				   opponent == "6" || opponent == "7" || opponent == "8" || opponent == "9") {
			return Attack.POUNCE;
		} else if (opponent == "0") {
			return Attack.ROAR;
		} else {
			zombieDir = randomInt.nextInt(2);

			if (zombieDir == 0)
				return Attack.ROAR;
			else if (zombieDir == 1)
				return Attack.POUNCE;
			else
				return Attack.SCRATCH;
		}
	}


	public Direction getMove() {
		totalMoves++;
		if (totalMoves < 200) {
			return Direction.NORTH;
		} else {
			zombieDir = randomInt.nextInt(3);

			if (zombieDir == 0)
				return Direction.EAST;
			else if (zombieDir == 1)
				return Direction.SOUTH;
			else if (zombieDir == 2)
				return Direction.NORTH;
			else
				return Direction.WEST;
		}
	}

	public String toString() {
	 	zombieChar = randomInt.nextInt(10);

	 	if (zombieChar == 0) {
	 		return "A";
	 	} else if (zombieChar == 1) {
	 		return "B";
	 	} else if (zombieChar == 2) {
	 		return "C";
	 	} else if (zombieChar == 3) {
	 		return "D";
	 	} else if (zombieChar == 4) {
	 		return "E";
	 	} else if (zombieChar == 5) {
	 		return "F";
	 	} else if (zombieChar == 6) {
	 		return "G";
	 	} else if (zombieChar == 7) {
	 		return "H";
	 	} else if (zombieChar == 8) {
	 		return "I";
	 	} else if (zombieChar == 9) {
	 		return "J";
	 	} else {
	 		return "K";
	 	} 
	}
}
