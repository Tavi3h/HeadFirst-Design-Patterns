package ch_03_DecoratorPattern.carDemo;

// ConcreteDecoratorA

public class FlyCar extends SuperCar {

	public FlyCar(AbstractCar absCar) {
		super(absCar);
	}
	
	// 增加的新功能
	public void fly() {
		System.out.println("空中行驶");
	}

	@Override
	public void move() {
		super.move();
		fly();
	}

}
