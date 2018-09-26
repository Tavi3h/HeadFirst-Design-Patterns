package ch_03_DecoratorPattern.starbuzz.concreteComponent;

import ch_03_DecoratorPattern.starbuzz.component.Beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "DarkRoast";
	}

	@Override
	public double cost() {

		return .99;
	}

}
