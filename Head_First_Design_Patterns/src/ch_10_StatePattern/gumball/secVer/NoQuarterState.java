package ch_10_StatePattern.gumball.secVer;

public class NoQuarterState implements State {
	
	private GumballMachine gumballMachine;
	
	// 我们通过构造器得到糖果机引用，然后将它记录再实例变量中。
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine	= gumballMachine;
	}

	/*
	 * 如果有人投入了25分钱，我们就打印出一条信息，说我们接受了25分钱
	 * 然后改变机器的状态到HasQuarterState
	 */
	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
	
	/*
	 * 如果没给钱，就不能要求退钱。
	 */
	@Override
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}

	/*
	 * 如果没给钱，就不能要求糖果。
	 */
	@Override
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	}

	/*
	 * 如果没得到钱，我们就不能发放糖果。
	 */
	@Override
	public void dispense() {
		System.out.println("You need to pay first");
	}
	
	public String toString() {
		return "waiting for quarter";
	}
}
