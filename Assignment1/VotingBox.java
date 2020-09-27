import stanford.karel.SuperKarel;

public class VotingBox extends SuperKarel {

	public void run() {

		while (frontIsClear()) {
			move();
			checkMiddleBeeper();
			cleanOtherBeepers();
			move();
		}
	}

	private void checkMiddleBeeper() {
		if (beepersPresent()) {
			move();
			move();
		}
	}

	private void cleanOtherBeepers() {
		if (noBeepersPresent()) {
			cleanBeepersSouth();
			cleanBeepersNorth();
		}
	}

	private void cleanBeepersSouth() {
		turnRight();
		move();
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
	}

	private void cleanBeepersNorth() {
		move();
		if (frontIsClear()) {
			move();
		}
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
		turnLeft();
	}
}
