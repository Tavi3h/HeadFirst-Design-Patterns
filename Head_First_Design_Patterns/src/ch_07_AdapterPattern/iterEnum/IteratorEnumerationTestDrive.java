package ch_07_AdapterPattern.iterEnum;

import java.util.*;

public class IteratorEnumerationTestDrive {

	public static void main(String args[]) {

		Character[] arr2 = { 'T', 'E', 's', 't' };

		ArrayList<Character> list = new ArrayList<>(Arrays.asList(arr2));

		Enumeration<Character> enumeration = new IteratorEnumeration<Character>(list.iterator());
		while (enumeration.hasMoreElements()) {
			System.out.print(enumeration.nextElement() + " ");
		}
	}
}
