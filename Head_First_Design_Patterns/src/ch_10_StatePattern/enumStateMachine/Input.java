package ch_10_StatePattern.enumStateMachine;

import java.util.Random;

public enum Input {

	NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100), TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),

	ABORT_TRANSACTION {
		public int amount() {
			// disallow
			throw new RuntimeException("ABORT.amount");
		}
	},
	STOP {
		// This must be the last instance.
		public int amount() {
			// disallow
			throw new RuntimeException("SHUT_DOWN.amount");
		}
	};

	int value; // In cents

	Input(int value) {
		this.value = value;
	}

	Input() {

	}

	int amount() {
		return value;
	}

	static Random rand = new Random(47);

	public static Input randomSelection() {
		// Don't include STOP
		return values()[rand.nextInt(values().length - 1)];
	}

}
