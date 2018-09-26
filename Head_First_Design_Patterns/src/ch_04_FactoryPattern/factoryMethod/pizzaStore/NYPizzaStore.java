package ch_04_FactoryPattern.factoryMethod.pizzaStore;

import ch_04_FactoryPattern.factoryMethod.NYStyle.NYStyleCheesePizza;
import ch_04_FactoryPattern.factoryMethod.NYStyle.NYStyleClamPizza;
import ch_04_FactoryPattern.factoryMethod.NYStyle.NYStylePepperoniPizza;
import ch_04_FactoryPattern.factoryMethod.NYStyle.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else
			return null;
	}
}
