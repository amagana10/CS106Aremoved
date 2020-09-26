
/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	public void run() {

		while (true) {
			placeCheckers();

			moveNext();
		}
	}

	private void placeCheckers() {

		while (frontIsClear()) {
			if (counter % 2 == 0) {
				putBeeper();

			}
			counter++;

			move();
		}
		if (counter % 2 == 0) {
			putBeeper();

		}
		counter++;
	}

	private void moveNext() {
		if (facingEast()) {
			turnLeft();

			move();

			turnLeft();
		} else if (facingWest()) {
			turnRight();

			move();

			turnRight();
		}
	}

	private int counter = 0;

}
