package ch_07_AdapterPattern.iterEnum;

import java.util.*;

public class EnumerationIteratorTestDrive {

	public static void main(String args[]) {

		Integer[] arr = { 1, 2, 3, 4, 5, 6 };

		Vector<Integer> v = new Vector<>(Arrays.asList(arr));
		Iterator<Integer> iterator = new EnumerationIterator<Integer>(v.elements());
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
	}
}
