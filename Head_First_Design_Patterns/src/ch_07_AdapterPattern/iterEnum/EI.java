package ch_07_AdapterPattern.iterEnum;

import java.util.*;

public class EI {
	
	public static void main(String args[]) {

		// Vector<T>容器兼具可以产生Enumeration<T>和Iterator<T>的方法
		String[] arr = { "High", "On", "Love", "You" };
		Vector<String> v = new Vector<String>(Arrays.asList(arr));

		// Enumeration 转 Iterator
		Enumeration<String> enumeration_1 = v.elements();
		Iterator<String> iterator_1 = new EnumerationIterator<>(enumeration_1);
		while (iterator_1.hasNext()) {
			System.out.print(iterator_1.next() + " ");
		}

		System.out.println();

		// Iterator 转 Enumeration 
		Iterator<String> iterator_2 = v.iterator();
		Enumeration<String> enumeration_2 = new IteratorEnumeration<>(iterator_2);
		while (enumeration_2.hasMoreElements()) {
			System.out.print(enumeration_2.nextElement() + " ");
		}
	}
}
