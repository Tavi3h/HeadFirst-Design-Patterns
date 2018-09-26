package ch_03_DecoratorPattern.starbuzz.concreteComponent;

import ch_03_DecoratorPattern.starbuzz.component.Beverage;

public class HouseBlend extends Beverage {
	
	public HouseBlend() {
		description = "HouseBlend";
	}

	@Override
	public double cost() {

		return .89;
	}

}
