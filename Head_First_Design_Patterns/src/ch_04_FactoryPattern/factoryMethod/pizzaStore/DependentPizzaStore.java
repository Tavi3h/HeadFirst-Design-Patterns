package ch_04_FactoryPattern.factoryMethod.pizzaStore;

import ch_04_FactoryPattern.factoryMethod.ChicagoStyle.ChicagoStyleCheesePizza;
import ch_04_FactoryPattern.factoryMethod.ChicagoStyle.ChicagoStyleClamPizza;
import ch_04_FactoryPattern.factoryMethod.ChicagoStyle.ChicagoStylePepperoniPizza;
import ch_04_FactoryPattern.factoryMethod.ChicagoStyle.ChicagoStyleVeggiePizza;
import ch_04_FactoryPattern.factoryMethod.NYStyle.NYStyleCheesePizza;
import ch_04_FactoryPattern.factoryMethod.NYStyle.NYStyleClamPizza;
import ch_04_FactoryPattern.factoryMethod.NYStyle.NYStylePepperoniPizza;
import ch_04_FactoryPattern.factoryMethod.NYStyle.NYStyleVeggiePizza;

public class DependentPizzaStore {

	public Pizza createPizza(String style, String type) {
		Pizza pizza = null;
		if (style.equals("NY")) {
			if (type.equals("cheese")) {
				pizza = new NYStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new NYStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new NYStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new NYStylePepperoniPizza();
			}
		} else if (style.equals("Chicago")) {
			if (type.equals("cheese")) {
				pizza = new ChicagoStyleCheesePizza();
			} else if (type.equals("veggie")) {
				pizza = new ChicagoStyleVeggiePizza();
			} else if (type.equals("clam")) {
				pizza = new ChicagoStyleClamPizza();
			} else if (type.equals("pepperoni")) {
				pizza = new ChicagoStylePepperoniPizza();
			}
		} else {
			System.out.println("Error: invalid type of pizza");
			return null;
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
