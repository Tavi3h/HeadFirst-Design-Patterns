package ch_03_DecoratorPattern.humanDemo;

// 定义ConcreteComponent

public class Person implements Human {

	@Override
	public void wearClothes() {
		System.out.println("穿什么呢。。");
	}

	@Override
	public void walkToWhere() {
		System.out.println("去哪里呢。。");
	}

}
