package ch_01_StrategyPattern.duck.ducks;

import ch_01_StrategyPattern.duck.flyBehavior.FlyNoWay;
import ch_01_StrategyPattern.duck.quackBehavior.Quack;

public class ModelDuck extends Duck {
	
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		System.out.println("I'm a model duck");
	}

}
