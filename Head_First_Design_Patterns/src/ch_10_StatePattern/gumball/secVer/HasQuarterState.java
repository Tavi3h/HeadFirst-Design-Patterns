package ch_10_StatePattern.gumball.secVer;

public class HasQuarterState implements State {
	
	private GumballMachine gumballMachine;
	 
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	/*
	 * 这是一个对此状态不恰当的动作。
	 */
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}

	/*
	 * 推出顾客的25分钱，并将状态转换到NoQuarterState状态。
	 */
	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	/*
	 * 当曲柄转动时，我们就调用它的setState()方法，并传入SoldState对象作为参数，
	 * 将机器的状态转换到SoldState状态。这个SoldState对象可以通过getSoldState()
	 * 方法取得。
	 */
	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	/*
	 * 这是此状态的另一个不恰当动作。
	 */
	@Override
	public void dispense() {
		 System.out.println("No gumball dispensed");
	}
	
	public String toString() {
		return "waiting for turn of crank";
	}
}
