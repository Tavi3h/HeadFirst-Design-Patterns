package ch_03_DecoratorPattern.carDemo;

// ConcreteComponent

public class Car implements AbstractCar {

	@Override
	public void move() {
		System.out.println("陆上行驶");
	}

}
