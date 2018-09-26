package ch_10_StatePattern.gumball.secVer;

public class SoldState implements State {

	private GumballMachine gumballMachine;

	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	/*
	 * 这是一个对此状态不恰当的动作。
	 */
	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
	}
	
	/*
	 * 这是一个对此状态不恰当的动作。
	 */
	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}

	/*
	 * 这是一个对此状态不恰当的动作。
	 */
	@Override
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}

	@Override
	public void dispense() {
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() > 0) {
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumballs!");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}
	
	public String toString() {
		return "dispensing a gumball";
	}
}
