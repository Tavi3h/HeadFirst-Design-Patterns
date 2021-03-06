package ch_03_DecoratorPattern.humanDemo;

// 定义Decorator基类

public abstract class Decorator implements Human {

	private Human human;
	
	public Decorator(Human human) {
		this.human = human;
	}

	@Override
	public void wearClothes() {
		human.wearClothes();
	}

	@Override
	public void walkToWhere() {
		human.walkToWhere();
	}

}
