package ch_08_TemplateMethodPattern.simplebarista;

// 抽象基类

public abstract class CaffeineBeverage {
	
	// 使用同一个prepareRecipe方法来处理茶和咖啡。
	// 声明为final，避免子类覆盖。
	// 该方法为模板方法
	final void prepareRecipe() {
		
		boilWater();
		brew();
		pourInCup();
		addCondiments();
		
	}
	
	/*
	 *  抽象方法具体由子类实现
	 */
	
	abstract void brew();
	
	abstract void addCondiments();
	
	void boilWater() {
		System.out.println("Boiling Water");
	}
	
	void pourInCup() {
		System.out.println("Pouring into cup");
	}

}
