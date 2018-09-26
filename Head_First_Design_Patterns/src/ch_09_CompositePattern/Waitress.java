package ch_09_CompositePattern;

import java.util.Iterator;

public class Waitress {
	
	private MenuComponent allMenus;

	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
	}
	
	public void printMenu() {
		allMenus.print();
	}
	
	// 打印所有素食菜单项的方法
	public void printVegetarianMenu() {
		Iterator<MenuComponent> iterator = allMenus.createIterator();
		System.out.println("\nVEGETARIAN MENU\n----");
		while (iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			/*
			 * 如果不使用try/catch方法进行处理，
			 * 也可以在调用isVegetarian()前对每一个menuComponent进行instanceof检查，
			 * 检查其是否是MenuItem类型。 进而决定是否调用isVegetarian()方法。
			 * 
			 * 但是这么做会失去透明性，无法统一处理菜单和菜单项。
			 * 
			 * 这里真正想要表达的是：
			 * isVegetarian()是Menu类没有支持的操作，这和isVegetarian()方法返回false是不同的。
			 * 当前的处理方法也允许了后来人去实现一个合理的Menu类的isVegetarian()，而我们不比为此再修改这里的代码。
			 */
			try {
				if (menuComponent.isVegetarian()) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {
				// 只有菜单项的print()方法可以被调用，菜单的print()方法不能被调用。
				// 因为菜单(Menu)类没有覆盖MenuComponent超类的isVegetarian()方法，
				// 所以在if语句调用该方法时会抛出异常，这里我们对异常进行捕获，但是并不处理。
				// 使遍历正常进行。
			}
		}
	}
}
