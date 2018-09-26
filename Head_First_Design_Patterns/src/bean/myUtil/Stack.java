package bean.myUtil;

import java.util.LinkedList;

/**
 * @ClassName: Stack
 * @Description: Making a stack from a LinkedList
 * @author: Tavish
 * @date: 2017年6月2日 下午3:13:22
 */
/*
 * Stack这个名称会与java.util中的Stack名称冲突，导入时注意。
 */
public class Stack<T> {
	private LinkedList<T> storage = new LinkedList<T>();
	public void push(T v) {
		storage.addFirst(v);
	}
	public T peek() {
		return storage.getFirst();
	}
	public T pop() {
		return storage.removeFirst();
	}
	public boolean empty() {
		return storage.isEmpty();
	}
	public String toString() {
		return storage.toString();
	}

}
