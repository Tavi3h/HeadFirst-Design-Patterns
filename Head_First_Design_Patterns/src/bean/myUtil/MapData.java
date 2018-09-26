package bean.myUtil;

import java.util.LinkedHashMap;

// A Map filled with data using a generator objects

@SuppressWarnings("serial")
public class MapData<K, V> extends LinkedHashMap<K, V> {
	

	// A single Pair Generator
	public MapData(Generator<Pair<K, V>> gen, int quantity) {
		for (int i = 0; i < quantity; i++) {
			Pair<K, V> p = gen.next();
			put(p.key, p.value);
		}
	}

	// Two Separate Generators
	public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(genK.next(), genV.next());
		}
	}

	// A key Generator with single value
	public MapData(Generator<K> genK, V value, int quantity) {
		for (int i = 0; i < quantity; i++) {
			put(genK.next(), value);
		}
	}

	// An Iterable and a value Generator
	public MapData(Iterable<K> iterK, Generator<V> genV) {
		for (K key : iterK) {
			put(key, genV.next());
		}
	}

	// An Iterable and a single value
	public MapData(Iterable<K> iterK, V value) {
		for (K key : iterK) {
			put(key, value);
		}
	}

	// Generic convenience methods:
	public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
		return new MapData<K, V>(gen, quantity);
	}

	public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
		return new MapData<K, V>(genK, genV, quantity);
	}

	public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity) {
		return new MapData<K, V>(genK, value, quantity);
	}

	public static <K, V> MapData<K, V> map(Iterable<K> iterK, Generator<V> genV) {
		return new MapData<K, V>(iterK, genV);
	}

	public static <K, V> MapData<K, V> map(Iterable<K> iterK, V value) {
		return new MapData<K, V>(iterK, value);
	}
}
