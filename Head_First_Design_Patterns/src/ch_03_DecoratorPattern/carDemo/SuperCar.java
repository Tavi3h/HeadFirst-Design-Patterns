package ch_03_DecoratorPattern.carDemo;

// Decorator

public class SuperCar implements AbstractCar {
	
	protected AbstractCar absCar;
	
	public SuperCar(AbstractCar absCar) {
		this.absCar = absCar;
	}
	@Override
	public void move() {
		absCar.move();
	}

}
