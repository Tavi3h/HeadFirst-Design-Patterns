package ch_03_DecoratorPattern.starbuzz.concreteComponent;

import ch_03_DecoratorPattern.starbuzz.component.Beverage;

public class Decaf extends Beverage {
	
	public Decaf() {
		description = "Decaf";
	}

	@Override
	public double cost() {

		return 1.05;
	}

}
