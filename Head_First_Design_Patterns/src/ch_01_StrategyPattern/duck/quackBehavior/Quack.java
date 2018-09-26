package ch_01_StrategyPattern.duck.quackBehavior;

public class Quack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("Quack");
	}
}
