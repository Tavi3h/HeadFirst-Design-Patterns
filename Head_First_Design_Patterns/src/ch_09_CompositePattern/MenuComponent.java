package ch_09_CompositePattern;

import java.util.Iterator;

/*
 * 所有组件都必须继承该抽象类。
 * 然而组合节点和叶节点的角色不同，所以有些方法可能并不适合某种节点。所以在这种情况下默认方法最好是抛出运行时异常。
 * 这样如果子类不支持某个操作，那么我们不需要做任何事，只要继承默认实现就可以了。
 */
public abstract class MenuComponent {
	/*
	 * 组合方法
	 */
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}

	public MenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}
	
	/*
	 * 操作方法
	 */
	public String getName() {
		throw new UnsupportedOperationException();
	}

	public String getDescription() {
		throw new UnsupportedOperationException();
	}

	public double getPrice() {
		throw new UnsupportedOperationException();
	}

	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}

	public void print() {
		throw new UnsupportedOperationException();
	}
	
	// 定义一个抽象方法来生成迭代器
	public abstract Iterator<MenuComponent> createIterator();
}
