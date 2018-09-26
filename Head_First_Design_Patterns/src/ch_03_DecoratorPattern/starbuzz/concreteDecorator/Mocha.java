package ch_03_DecoratorPattern.starbuzz.concreteDecorator;

import ch_03_DecoratorPattern.starbuzz.component.Beverage;
import ch_03_DecoratorPattern.starbuzz.decorator.CondimentDecorator;

public class Mocha extends CondimentDecorator {
	
	private Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {

		return .20 + beverage.cost();
	}

}
