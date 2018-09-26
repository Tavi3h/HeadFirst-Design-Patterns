package ch_12_CompoundPattern.thirdVer;

import java.util.ArrayList;
import java.util.Iterator;
// 组合模式，组合需要和叶节点元素同样的接口
public class Flock implements Quackable {
	
	private ArrayList<Quackable> quackers = new ArrayList<>();
	
	public void add(Quackable quacker) {
		quackers.add(quacker);
	}
	
	// 迭代器模式
	public void quack() {
		Iterator<Quackable> iterator = quackers.iterator();
		while (iterator.hasNext()) {
			iterator.next().quack();
		}
	}

}
/*
这里我们决定把组合维护孩子的方法和叶节点分开，也就是说，我们只打算让Flock具有add方法。
我们直到给一个Duck添加某些东西是无意义的，这样的设计比较“安全”，你不会调用无意义的方法，
但是透明性比较查。现在客户如果想调用add方法，得先确定这个Quackable对象是Flock才行。

提高透明性的做法：
将add方法添加到Quackable抽象类中，并做默认实现，抛出异常。
Flock覆盖add方法，实现向ArrayList中添加元素。
Duck类不进行覆盖，直接继承默认实现。
在测试类中使用try/catch对add进行环绕。
*/