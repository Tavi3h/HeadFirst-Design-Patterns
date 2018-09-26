package ch_03_DecoratorPattern.starbuzz.concreteDecorator;

import ch_03_DecoratorPattern.starbuzz.component.Beverage;
import ch_03_DecoratorPattern.starbuzz.decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {

	private Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {

		return .10 + beverage.cost();
	}

}
