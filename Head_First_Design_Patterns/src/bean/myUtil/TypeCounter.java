package bean.myUtil;

import java.util.HashMap;
import java.util.Map;

// 递归计数

@SuppressWarnings("serial")
public class TypeCounter extends HashMap<Class<?>, Integer> {
	private Class<?> baseType;

	public TypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}

	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if(!baseType.isAssignableFrom(type)) {
			throw new RuntimeException(obj + " incorrect type: " + type + ", should be type or subtype of " + baseType);
		}
		countClass(type);
	}

	private void countClass(Class<?> type) {
		Integer quantity = this.get(type);
		this.put(type, quantity == null ? 1 : quantity + 1);
		Class<?> superClass = type.getSuperclass();
		// 向上递归
		if(superClass != null && baseType.isAssignableFrom(superClass)) {
			countClass(superClass);
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder("{");
		for (Map.Entry<Class<?>, Integer> pair : entrySet()) {
			result.append(pair.getKey().getSimpleName());
			result.append("=");
			result.append(pair.getValue());
			result.append(", ");
		}
		result.delete(result.length() - 2, result.length());
		result.append("}");
		return result.toString();
	}

}
