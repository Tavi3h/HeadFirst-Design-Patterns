package ch_13_OtherPattern.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

	// 用 HashMap 存储这些对象。
	private Map<String, Flyweight> fwMap = new HashMap<>();

	public Flyweight getFlyweight(String str) {
		// 用唯一标识码判断，如果在内存中有，则返回这个唯一标识码所标识的对象。
		Flyweight fw = fwMap.get(str);
		if (fw == null) {
			fw = new ConcreteFlyweight(str);
			fwMap.put(str, fw);
		}
		return fw;
	}

	public int getfwMapSize() {
		return fwMap.size();
	}
}
