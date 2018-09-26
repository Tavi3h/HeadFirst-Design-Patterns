package ch_09_IteratorPattern;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinerMenu implements Menu<MenuItem> {

	private static final int MAX_ITEMS = 6;

	private int numberOfItems = 0;

	private MenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new MenuItem[MAX_ITEMS];

		addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
		addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
		addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
		addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
		addItem("Steamed Veggies and Brown Rice", "Steamed vegetables over brown rice", true, 3.99);
		addItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89);
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		if (numberOfItems >= MAX_ITEMS) {
			System.out.println("Sorry, menu is full! Can't add item to menu");
		} else {
			menuItems[numberOfItems++] = new MenuItem(name, description, vegetarian, price);
		}
	}

	// 使用匿名内部类实现一个迭代器
	public Iterator<MenuItem> createIterator() {

		return new Iterator<MenuItem>() {

			int size = menuItems.length;
			int position = 0;
			boolean okToRemove = false;

			@Override
			public boolean hasNext() {

				if (position >= size || menuItems[position] == null) {
					return false;
				} else {
					return true;
				}

			}

			@Override
			public MenuItem next() {
				if (!hasNext())
					throw new NoSuchElementException();
				okToRemove = true;
				return menuItems[position++];
			}

			@Override
			public void remove() {
				if (!okToRemove) {
					throw new RuntimeException("You should call 'next()' before you call 'remove()'");
				} else {
					for (int i = position - 1; i < size - 1; i++) {
						menuItems[i] = menuItems[i + 1];
					}
					menuItems[size - 1] = null;
				}
				okToRemove = false;
				position--;
				size--;
			}

		};

	}

	// 其它方法 ...

}
