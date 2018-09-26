package ch_03_DecoratorPattern.starbuzz.concreteDecorator;

import ch_03_DecoratorPattern.starbuzz.component.Beverage;
import ch_03_DecoratorPattern.starbuzz.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {
	
	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {

		return .15 + beverage.cost();
	}

}
