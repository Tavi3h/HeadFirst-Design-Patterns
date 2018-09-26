package ch_03_DecoratorPattern.carDemo;

//ConcreteDecoratorB

public class WaterCar extends SuperCar {

	public WaterCar(AbstractCar absCar) {
		super(absCar);
	}
		
	// 增加的新功能
	public void swim() {
		System.out.println("水上行驶");
	}

	@Override
	public void move() {
		super.move();
		swim();
	}

}
