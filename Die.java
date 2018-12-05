package alex.andrew.monoplyproject;

import java.util.Random;

public class Die {
		public boolean doubleRoll = false;

	public int roll() {
		Random random = new Random();
		int rolledDouble = 0;
		int die1 = random.nextInt(7 - 1) + 1;
		int die2 = random.nextInt(7 - 1) + 1;
		if (die1 == die2) {
			doubleRoll = true;
			rolledDouble++;
		}
		doubleRoll = false;

		int totalMove = die1 + die2;
		return totalMove;
	}
}
