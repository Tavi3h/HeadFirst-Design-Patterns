package ch_04_FactoryPattern.abstractFactory.IngredientFactory;

import ch_04_FactoryPattern.abstractFactory.Ingredient.Cheese.MozzarellaCheese;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Clams.Clams;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Clams.FrozenClams;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Dough.Dough;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Dough.ThickCrustDough;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Pepperoni.Pepperoni;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Pepperoni.SlicedPepperoni;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Sauce.PlumTomatoSauce;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Sauce.Sauce;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.BlackOlives;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Cheese;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Eggplant;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Spinach;
import ch_04_FactoryPattern.abstractFactory.Ingredient.Veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), new Spinach(), new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
