package ch_09_IteratorPattern;

import java.util.Iterator;
// 菜单接口，每个菜单都应该实现这个接口，并提供适当的迭代器
public interface Menu<T> {
	public Iterator<T> createIterator();
}
