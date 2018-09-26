package ch_01_StrategyPattern.duck.ducks;

import ch_01_StrategyPattern.duck.flyBehavior.FlyWithWings;
import ch_01_StrategyPattern.duck.quackBehavior.Quack;

public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}

}
