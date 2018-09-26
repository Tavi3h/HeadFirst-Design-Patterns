package ch_04_FactoryPattern.factoryMethod.ChicagoStyle;

import ch_04_FactoryPattern.factoryMethod.pizzaStore.Pizza;

public class ChicagoStyleVeggiePizza extends Pizza {
	public ChicagoStyleVeggiePizza() {
		name = "Chicago Deep Dish Veggie Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.add("Shredded Mozzarella Cheese");
		toppings.add("Black Olives");
		toppings.add("Spinach");
		toppings.add("Eggplant");
	}
 
	protected void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
