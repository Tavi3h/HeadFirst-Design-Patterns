package ch_10_StatePattern.gumball.thirdVer;
/*
 * Q :	为什么需要WinnerState？为什么不直接在SoldState中随机发放两个糖果？
 * A :	当然可以将发放两颗糖果的代码放在SoldState中，但是这么做存在缺点。
 * 	 	这样做等于将两个状态用一个状态类来代表。违背了一个类一个责任的原则。
 * 		等于让SoldState拥有两个责任。同时当我们改变了对Winner的定义后又要修改
 * 		SoldState的代码。
 */
public class WinnerState implements State {
	private GumballMachine gumballMachine;

	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a Gumball");
	}

	public void ejectQuarter() {
		System.out.println("Please wait, we're already giving you a Gumball");
	}

	public void turnCrank() {
		System.out.println("Turning again doesn't get you another gumball!");
	}

	public void dispense() {
		System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0) {
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			if (gumballMachine.getCount() > 0) {
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				System.out.println("Oops, out of gumballs!");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}

	public String toString() {
		return "despensing two gumballs for your quarter, because YOU'RE A WINNER!";
	}
}
