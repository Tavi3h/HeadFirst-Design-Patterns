package ch_04_FactoryPattern.abstractFactory.IngredientFactory;

import ch_04_FactoryPattern.abstractFactory.Ingredient.Cheese.ReggianoCheese;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Clams.Clams;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Clams.FreshClams;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Dough.Dough;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Dough.ThinCrustDough;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Pepperoni.Pepperoni;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Pepperoni.SlicedPepperoni;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Sauce.MarinaraSauce;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Sauce.Sauce;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Cheese;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Garlic;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Mushroom;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Onion;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.RedPepper;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
