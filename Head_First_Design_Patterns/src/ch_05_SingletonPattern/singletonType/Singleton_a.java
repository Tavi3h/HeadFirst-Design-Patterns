package ch_05_SingletonPattern.singletonType;

// 懒汉式
public class Singleton_a {

	// volatile确保当uniqueInstance被初始化为Singleton_a的实例时，多个线程能正确地处理uniqueInstance变量
	private volatile static Singleton_a uniqueInstance;

	private Singleton_a() {
		// Constructor code ...
	}

	// 使用同步代码块进行同步
	// 双重检查加锁法
	public static Singleton_a getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton_a.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton_a();
				}
			}
		}
		return uniqueInstance;

	}
	// other code ...

}
