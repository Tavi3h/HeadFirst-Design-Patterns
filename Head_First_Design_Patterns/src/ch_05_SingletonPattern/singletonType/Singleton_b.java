package ch_05_SingletonPattern.singletonType;
// 饿汉式
public class Singleton_b {

	// 线程安全，无需使用同步
	private static Singleton_b uniqueInstance = new Singleton_b();

	private Singleton_b() {
		// constructor code...
	}

	public static Singleton_b getInstance() {
		return uniqueInstance;
	}

}
