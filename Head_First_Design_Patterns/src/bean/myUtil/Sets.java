package bean.myUtil;

import java.util.HashSet;
import java.util.Set;

public class Sets {

	// 取并集
	public static <T> Set<T> union(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<>(a);
		result.addAll(b);
		return result;
	}

	// 取交集
	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		Set<T> result = new HashSet<>(a);
		result.retainAll(b);
		return result;
	}

	// Subtract subset from superset
	// 在superset中移除subset包含的元素
	public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
		Set<T> result = new HashSet<>(superset);
		result.removeAll(subset);
		return result;
	}

	// Reflexive -- everything not in the intersection:
	// 返回a、b交集之外的所有元素
	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
		return difference(union(a, b), intersection(a, b));
	}
}
