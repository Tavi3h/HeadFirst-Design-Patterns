package ch_04_FactoryPattern.abstractFactory.pizzaStore;

import ch_04_FactoryPattern.abstractFactory.IngredientFactory.ChicagoPizzaIngredientFactory;
import ch_04_FactoryPattern.abstractFactory.IngredientFactory.PizzaIngredientFactory;
import ch_04_FactoryPattern.abstractFactory.pizzas.CheesePizza;
import ch_04_FactoryPattern.abstractFactory.pizzas.ClamPizza;
import ch_04_FactoryPattern.abstractFactory.pizzas.PepperoniPizza;
import ch_04_FactoryPattern.abstractFactory.pizzas.Pizza;
import ch_04_FactoryPattern.abstractFactory.pizzas.VeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

	protected Pizza createPizza(String item) {
		Pizza pizza = null;
		PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

		if (item.equals("cheese")) {

			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");

		} else if (item.equals("veggie")) {

			pizza = new VeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");

		} else if (item.equals("clam")) {

			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Style Clam Pizza");

		} else if (item.equals("pepperoni")) {

			pizza = new PepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");

		}
		return pizza;
	}
}
