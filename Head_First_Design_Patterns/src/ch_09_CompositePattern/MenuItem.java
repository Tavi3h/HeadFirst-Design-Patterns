package ch_09_CompositePattern;

import java.util.Iterator;

// 菜单项，组合类图中的叶节点
public class MenuItem extends MenuComponent {

	private String name;
	private String description;
	private boolean vegeterian;
	private double price;

	public MenuItem(String name, String description, boolean vegeterian, double price) {
		this.name = name;
		this.description = description;
		this.vegeterian = vegeterian;
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public boolean isVegetarian() {
		return vegeterian;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void print() {
		System.out.print("   " + getName());
		System.out.print(isVegetarian() ? "(V)" : "");
		System.out.println(", " + getPrice());
		System.out.println("     -- " + getDescription());
	}
	
	/*
	 * 菜单项内没有什么需要遍历的。
	 * 这里使用空迭代器来实现creatIterator方法
	 * 
	 * *返回一个迭代器，这个迭代器的hasNext永远返回false
	 * *这样客户不用担心返回值是否为null。
	 * *如果creatIterator方法返回null，我们的客户端代码就需要条件语句判断返回值是否是null。
	 */
	@Override
	public Iterator<MenuComponent> createIterator() {
		// 使用匿名内部类来实现
		return new Iterator<MenuComponent>() {
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public MenuComponent next() {
				return null;
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};		
	}
}
