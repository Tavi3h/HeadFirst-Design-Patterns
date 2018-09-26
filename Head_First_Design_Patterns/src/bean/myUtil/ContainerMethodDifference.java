package bean.myUtil;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContainerMethodDifference {
	
	// 获取一个类的方法的集合
	static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<>();
		for(Method m : type.getDeclaredMethods()) 
			result.add(m.getName());		
		return result;
	}
	// Output line 1
	
	// 获取一个类的接口并打印
	static void interfaces(Class<?> type) {
		System.out.print("Interfaces in " + type.getSimpleName() + ":");
		List<String> result = new ArrayList<>();
		for(Class<?> c : type.getInterfaces())
			result.add(c.getSimpleName());
		System.out.println(result);
	}
	// Output line 2
	
	// 获取Object类的方法并存入object中
	static Set<String> object = methodSet(Object.class);
	
	// 获取两个类方法的交集
	static void difference(Class<?> subset, Class<?> superset) {
		System.out.print(subset.getSimpleName() +" extends " + superset.getSimpleName() + ", add: ");
		Set<String> comp = Sets.difference(methodSet(subset), methodSet(superset));
		comp.removeAll(object); // Don't show 'Object' methods， 在交集中去掉Object类的方法
		System.out.println(comp);
		interfaces(subset);
	}
	
	public static void main(String[] args) {
		System.out.println("Collection " + methodSet(Collection.class));
		interfaces(Collection.class);
		difference(TreeSet.class, Set.class);
	}

}
// output:
/*
Collection [add, addAll, clear, contains, containsAll, equals, forEach, hashCode, isEmpty, iterator, parallelStream, remove, removeAll, removeIf, retainAll, size, spliterator, stream, toArray]
Interfaces in Collection:[Iterable]
TreeSet extends Set, add: [headSet, descendingIterator, descendingSet, pollLast, subSet, floor, tailSet, ceiling, last, lower, comparator, pollFirst, first, higher]
Interfaces in TreeSet:[NavigableSet, Cloneable, Serializable]
*/
