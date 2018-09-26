package ch_10_StatePattern.gumball.firstVer;

public class GumballMachine {

	// 设定状态
	private final static int SOLD_OUT = 0; 					// 糖果售罄
	private final static int NO_QUARTER = 1; 				// 没有25分钱
	private final static int HAS_QUARTER = 2; 				// 有25分钱
	private final static int SOLD = 3; 						// 出售糖果

	private int state = SOLD_OUT; 							// 设定初始状态为糖果售罄
	private int count = 0; 									// 用于追踪机器内的糖果数量

	// 初始化糖果机，得到一定量的糖果，并设置状态为没有25分钱
	public GumballMachine(int count) {
		this.count = count;
		state = NO_QUARTER;
	}

	// 当顾客投入25分钱时，执行该方法
	public void insertQuarter() {
		if (state == HAS_QUARTER) {																// 如果已经投入了25分钱，则告知顾客
			System.out.println("You can't insert another quarter");								
		} else if (state == NO_QUARTER) {														// 如果在没有25分钱的状态下，则接受25分钱，并转为有25分钱的状态
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter");
		} else if (state == SOLD_OUT) {															// 如果糖果售罄，则拒绝收钱
			System.out.println("You can't insert a quarter, coz the machine is sold out");
		} else if (state == SOLD) {																// 如果顾客刚买了糖果，就需要稍等一下，好让状态转换完毕，恢复到没有25分钱的状态
			System.out.println("Please wait, we're already giving you a gumball");
		}
	}

	// 当顾客退回25分钱时，执行该方法
	public void ejectQuarter() {
		if (state == HAS_QUARTER) {																// 如果有25分钱，则退钱。并回到没有25分钱的状态。
			System.out.println("Quarter returned");
			state = NO_QUARTER;
		} else if (state == NO_QUARTER) {														// 如果没有25分钱，当然不能退钱
			System.out.println("You haven't insert a quarter");
		} else if (state == SOLD) {																// 如果顾客已经转动曲柄，则不能再退钱了
			System.out.println("Sorry, you already turned the crank");
		} else if (state == SOLD_OUT) {															// 如果糖果售罄，则不会接受25分钱，自然也不能退钱
			System.out.println("You can't eject, you haven't inserted a quarter yet");
		}
	}
	
	// 当顾客转动曲柄时，执行该方法
	public void turnCrank() {
		if (state == SOLD) {																    // 别想骗过机器拿两次糖果
			System.out.println("Turning twice doesn't get you another gumball!!");
		} else if (state == NO_QUARTER) {														// 我们需要先投入25分钱
			System.out.println("You turned but there is no quarter");
		} else if (state == SOLD_OUT) {															// 糖果售罄，我们给不出糖果了
			System.out.println("You turned but there are no gumballs");
		} else if (state == HAS_QUARTER) {														// 可以拿到糖果，改变机器状态，然后调用dispense()方法
			System.out.println("You turned...");
			state = SOLD;
			dispense();
		}
	}

	// 调用此方法，发放糖果
	private void dispense() {
		if (state == SOLD) {																	// 售出糖果
			System.out.println("A gumball comes rolling out the slot");
			if (--count == 0) {                          										// 如果售出后糖果数量减为0，则调整状态为售罄
				System.out.println("Oops, out of gumballs");
				state = SOLD_OUT;
			} else {																			// 否则进入没有25分钱的状态
				state = NO_QUARTER;
			}
		// 以下这些情况不应该发生，如果顾客这么做了，则出现错误信息
		} else if (state == NO_QUARTER) {
			System.out.println("You need to pay first");
		} else if (state == SOLD_OUT) {
			System.out.println("No gumball dispensed");
		} else if (state == HAS_QUARTER) {
			System.out.println("No gumball dispensed");
		}
	}
	
	// 向糖果机内装入糖果的方法
	public void refill(int numGumBalls) {
		this.count = numGumBalls;
		state = NO_QUARTER;
	}

	// toString
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is ");
		if (state == SOLD_OUT) {
			result.append("sold out");
		} else if (state == NO_QUARTER) {
			result.append("waiting for quarter");
		} else if (state == HAS_QUARTER) {
			result.append("waiting for turn of crank");
		} else if (state == SOLD) {
			result.append("delivering a gumball");
		}
		result.append("\n");
		return result.toString();
	}
}
