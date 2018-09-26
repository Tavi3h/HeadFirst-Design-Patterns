package ch_08_TemplateMethodPattern;
// 如何定义一个带有模板的抽象类
public abstract class AbstractClass {

	// 模板
	final void templateMethod() {
		
		/*
		 * 内部调用方法的顺序视具体算法而定
		 */
		
		primitiveOperation1();
		primitiveOperation2();
		// ...
		concreteOperation1();
		concreteOperation2();
		// ...
		hook();
		// ...
	}

	/*
	 * 抽象方法由子类负责实现 
	 */
	
	abstract void primitiveOperation1();

	abstract void primitiveOperation2();

	// ...
	
	/*
	 * 父类已经实现的公有方法声明为final
	 */
	
	final void concreteOperation1() {
		// ...
	}

	final void concreteOperation2() {
		// ...
	}
	
	// ...
	
	/*
	 * 一个具体的方法，但是什么都不做
	 * 这种方法称为钩子。
	 * 子类可以视情况决定是否覆盖这个方法。
	 */
	void hook() {
		
	}

}
