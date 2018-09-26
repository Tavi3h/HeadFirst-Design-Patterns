package ch_03_DecoratorPattern.starbuzz.component;

// Component
public abstract class Beverage {

	protected String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost(); // 该方法在子类中实现

}
