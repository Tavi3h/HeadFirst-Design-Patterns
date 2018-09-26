package ch_04_FactoryPattern.factoryMethod.pizzaStore;

import ch_04_FactoryPattern.factoryMethod.ChicagoStyle.ChicagoStyleCheesePizza;
import ch_04_FactoryPattern.factoryMethod.ChicagoStyle.ChicagoStyleClamPizza;
import ch_04_FactoryPattern.factoryMethod.ChicagoStyle.ChicagoStylePepperoniPizza;
import ch_04_FactoryPattern.factoryMethod.ChicagoStyle.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new ChicagoStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new ChicagoStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new ChicagoStylePepperoniPizza();
		} else
			return null;
	}
}
