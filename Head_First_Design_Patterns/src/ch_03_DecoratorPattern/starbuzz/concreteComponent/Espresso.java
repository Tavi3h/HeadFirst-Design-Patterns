package ch_03_DecoratorPattern.starbuzz.concreteComponent;

import ch_03_DecoratorPattern.starbuzz.component.Beverage;

public class Espresso extends Beverage {
	
	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		return 1.99;
	}

}
