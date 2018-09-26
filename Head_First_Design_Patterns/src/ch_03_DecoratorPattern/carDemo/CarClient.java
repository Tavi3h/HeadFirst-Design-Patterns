package ch_03_DecoratorPattern.carDemo;

public class CarClient {

	public static void main(String[] args) {
		
		Car car = new Car();
		car.move();

		System.out.println("-----增加新功能，空中行驶-----");
		FlyCar flyCar = new FlyCar(car);
		flyCar.move();

		System.out.println("-----增加新功能，水上行驶-----");
		WaterCar waterCar = new WaterCar(car);
		waterCar.move();

		System.out.println("-----增加新功能，空中行驶，水上行驶-----");
		WaterCar waterCar2 = new WaterCar(flyCar);
		waterCar2.move();
		
		System.out.println("----------------------------------------");
		SuperCar sc = new SuperCar(new WaterCar(new FlyCar(new Car())));
		sc.move();
	}

}
// output:
/*
陆上行驶
-----增加新功能，空中行驶-----
陆上行驶
空中行驶
-----增加新功能，水上行驶-----
陆上行驶
水上行驶
-----增加新功能，空中行驶，水上行驶-----
陆上行驶
空中行驶
水上行驶
*/