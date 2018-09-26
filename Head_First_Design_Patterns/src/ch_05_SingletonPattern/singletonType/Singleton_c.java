package ch_05_SingletonPattern.singletonType;
// 懒汉式
public class Singleton_c {
	
	private static Singleton_c uniqueInstance;
	
	private Singleton_c() {
		// constructor code ...
	}
	
	// 使用同步函数对方法进行同步，以保证线程安全
	public static synchronized Singleton_c getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Singleton_c();
		return uniqueInstance;
	}

}
