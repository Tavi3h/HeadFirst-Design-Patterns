package ch_12_CompoundPattern.firstVer;

import ch_12_CompoundPattern.secVer.Quackable;

public class DuckSimulator {
	
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		simulator.simulate();
	}
	
	void simulate() {
		// 使用装饰器
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable redheadDuck = new QuackCounter(new RedheadDuck());
		Quackable duckCall =  new QuackCounter(new DuckCall());
		Quackable rubberDuck =  new QuackCounter(new RubberDuck());
		Quackable gooseDuck = new GooseAdapter(new Goose()); // 鹅暂时不使用装饰器装饰
 
		System.out.println("\nDuck Simulator");
 
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		simulate(gooseDuck);
		
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
	}
	
	public void simulate(Quackable duck) {
		duck.quack();
	}

}
