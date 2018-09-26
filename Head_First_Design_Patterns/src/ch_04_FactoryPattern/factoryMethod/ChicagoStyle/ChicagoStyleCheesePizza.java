package ch_04_FactoryPattern.factoryMethod.ChicagoStyle;

import ch_04_FactoryPattern.factoryMethod.pizzaStore.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {

	public ChicagoStyleCheesePizza() { 
		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.add("Shredded Mozzarella Cheese");
	}
 
	protected void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
