package ch_03_DecoratorPattern.humanDemo;

//ConcreteDecoratorB

public class Decorator_one extends Decorator {

	public Decorator_one(Human human) {
		super(human);
	}

	// 新增功能
	public void goClothespress() {
		System.out.println("去衣柜找找看。。");
	}

	public void findPlaceOnMap() {
		System.out.println("在Map上找找。。");
	}

	@Override
	public void wearClothes() {
		super.wearClothes();
		goClothespress();
	}

	@Override
	public void walkToWhere() {
		super.walkToWhere();
		findPlaceOnMap();
	}

}
