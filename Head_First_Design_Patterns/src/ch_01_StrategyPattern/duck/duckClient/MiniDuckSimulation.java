package ch_01_StrategyPattern.duck.duckClient;

import ch_01_StrategyPattern.duck.ducks.Duck;
import ch_01_StrategyPattern.duck.ducks.MallardDuck;
import ch_01_StrategyPattern.duck.ducks.ModelDuck;
import ch_01_StrategyPattern.duck.flyBehavior.FlyRocketPowered;

public class MiniDuckSimulation {

	public static void main(String[] args) {
		
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
		
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

	}

}
// output:
/*
Quack
I'm flying
I can't fly
I'm flying with a rocket!
*/