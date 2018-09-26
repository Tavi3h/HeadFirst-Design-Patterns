package ch_08_TemplateMethodPattern.barista;

public abstract class CaffeineBeverageWithHook {

	void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		/*
		 * 此处加入了一个条件，条件是否成立由一个具体方法来决定 如果顾客想要调料，我们才调用addCondiments()方法
		 */
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	abstract void brew();

	abstract void addCondiments();

	void boilWater() {
		System.out.println("Boiling water");
	}

	void pourInCup() {
		System.out.println("Pouring into cup");
	}

	/*
	 * 我们在这里定义了一个方法，（通常）是空的缺省的实现。这个方法只会返回true，不做别的事
	 * 
	 * 这就事一个钩子，子类可以覆盖这个方法，但不见得一定要这么做。
	 */
	boolean customerWantsCondiments() {
		return true;
	}
}
