package ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states;

import java.util.Random;

import ch_11_ProxyPattern.remoteProxy.gumballWithProxy.GumballMachine;

public class HasQuarterState implements State {
	
	private static final long serialVersionUID = 2520342679931548257L;
	private Random randomWinner = new Random(System.currentTimeMillis());
	private transient GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}

	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setState(gumballMachine.getWinnerState());
		} else {
			gumballMachine.setState(gumballMachine.getSoldState());
		}
	}

	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	public String toString() {
		return "waiting for turn of crank";
	}
}
