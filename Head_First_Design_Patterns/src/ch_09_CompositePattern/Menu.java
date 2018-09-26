package ch_09_CompositePattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// 菜单，组合类。此组合类可以持有菜单项或其它菜单
public class Menu extends MenuComponent {

	// 菜单可以持有任意数目的孩子，这些孩子都必须属于MenuComponent类型，使用一个内部的ArrayList来记录
	private ArrayList<MenuComponent> menuComponents = new ArrayList<>();
	private String name;
	private String description;

	// 给每个菜单一个名字和描述
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}

	@Override
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}

	@Override
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
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
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("-----------------------");
		// 递归遍历整个菜单
		Iterator<MenuComponent> iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			iterator.next().print();
		}
	}

	@Override
	public Iterator<MenuComponent> createIterator() {
		return new CompositeIterator(menuComponents.iterator());
	}

	private class CompositeIterator implements Iterator<MenuComponent> {
		private LinkedList<Iterator<MenuComponent>> linkedlist = new LinkedList<>();

		public CompositeIterator(Iterator<MenuComponent> iterator) {
			linkedlist.addFirst(iterator);
		}

		@Override
		public boolean hasNext() {

			if (linkedlist.isEmpty()) {
				return false;
			} else {
				Iterator<MenuComponent> iterator = linkedlist.getFirst();
				if (!iterator.hasNext()) {
					linkedlist.removeFirst();
					return hasNext();
				} else {
					return true;
				}
			}
		}

		@Override
		public MenuComponent next() {
			if (hasNext()) {
				Iterator<MenuComponent> iterator = linkedlist.getFirst();
				MenuComponent component = iterator.next();
				if (component instanceof Menu) {
					linkedlist.addFirst(component.createIterator());
				}
				return component;
			} else {
				return null;
			}
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
