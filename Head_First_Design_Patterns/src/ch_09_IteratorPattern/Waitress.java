package ch_09_IteratorPattern;

import java.util.Iterator;
/*
 * 煎饼屋菜单和餐厅菜单的类现在都实现了Menu接口，于是Waitress类可以利用接口引用每一个菜单对象。
 * 实现“针对接口编程，而不针对实现编程”。
 * 减少了Waitress类与具体菜单类之间的依赖。
 * 
 * 使用菜单提供的迭代器对菜单进行遍历，无需知道菜单列表是如何实现的。
 * Waitress类与菜单类的具体实现解耦。
 */
public class Waitress {

	private Menu<MenuItem> pancakeHouseMenu;
	private Menu<MenuItem> dinerMenu;
	private Menu<MenuItem> cafeMenu;

	public Waitress(Menu<MenuItem> pancakeHouseMenum, Menu<MenuItem> dinerMenu, Menu<MenuItem> cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenum;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	/*
	 * 每次有新的菜单加入，我们就必须打开Waitress的实现，并加入更多的代码。
	 * *我们使用组合模式来解决这个问题*
	 */
	public void printMenu() {
		Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
		Iterator<MenuItem> caftIterator = cafeMenu.createIterator();
		System.out.println("Menu\n----\nBreakFast");
		printMenu(pancakeIterator);
		System.out.println("\nLunch");
		printMenu(dinerIterator);
		System.out.println("\nDinner");
		printMenu(caftIterator);
	}

	private void printMenu(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem mi = iterator.next();
			System.out.print(mi.getName() + ", " + mi.getPrice() + " -- " + mi.getDescription() + "\n");
		}
	}

}
