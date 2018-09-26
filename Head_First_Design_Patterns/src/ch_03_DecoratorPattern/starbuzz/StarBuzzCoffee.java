package ch_03_DecoratorPattern.starbuzz;

import ch_03_DecoratorPattern.starbuzz.component.Beverage;
import ch_03_DecoratorPattern.starbuzz.concreteComponent.DarkRoast;
import ch_03_DecoratorPattern.starbuzz.concreteComponent.Espresso;
import ch_03_DecoratorPattern.starbuzz.concreteComponent.HouseBlend;
import ch_03_DecoratorPattern.starbuzz.concreteDecorator.Mocha;
import ch_03_DecoratorPattern.starbuzz.concreteDecorator.Soy;
import ch_03_DecoratorPattern.starbuzz.concreteDecorator.Whip;

public class StarBuzzCoffee {

	public static void main(String[] args) {

		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage2 = new Whip(new Mocha(new Mocha(new DarkRoast())));
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

		Beverage beverage3 = new Whip(new Mocha(new Soy(new HouseBlend())));
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

	}

}
// output:
/*
Espresso $1.99
DarkRoast, Mocha, Mocha, Whip $1.49
HouseBlend, Soy, Mocha, Whip $1.34
*/