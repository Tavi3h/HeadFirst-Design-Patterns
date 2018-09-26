package ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states;

import ch_11_ProxyPattern.remoteProxy.gumballWithProxy.GumballMachine;

public class SoldOutState implements State {
	
	private static final long serialVersionUID = -3714040808119242734L;
	@SuppressWarnings("unused")
	private transient GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("You can't insert a quarter, the machine is sold out");
	}

	public void ejectQuarter() {
		System.out.println("You can't eject, you haven't inserted a quarter yet");
	}

	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
	}

	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	public String toString() {
		return "sold out";
	}
}
