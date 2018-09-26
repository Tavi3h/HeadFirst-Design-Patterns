package ch_04_FactoryPattern.abstractFactory.IngredientFactory;

import ch_04_FactoryPattern.abstractFactory.Ingredient.Clams.Clams;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Dough.Dough;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Pepperoni.Pepperoni;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Sauce.Sauce;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Cheese;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Veggies;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
