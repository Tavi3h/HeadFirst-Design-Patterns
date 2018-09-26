package ch_11_ProxyPattern.javaProxy;

import java.lang.reflect.*;
import java.util.*;

public class MatchMakingTestDrive {
	
	Hashtable<String, PersonBean> datingDB = new Hashtable<>();            // 模拟数据库

	public static void main(String[] args) {
		MatchMakingTestDrive test = new MatchMakingTestDrive();            // 创建MatchMakingTestDrive对象，调用drive开始测试
		test.drive();
	}

	public MatchMakingTestDrive() {
		initializeDatabase();                                              // 初始化MatchMakingTestDrive对象时对数据库进行初始化，并填入数据
	}
	
	void initializeDatabase() {                                            // 初始化数据库时填入的数据
		PersonBean joe = new PersonBeanImpl();
		joe.setName("Joe Javabean");
		joe.setInterests("cars, computers, music");
		joe.setHotOrNotRating(7);
		datingDB.put(joe.getName(), joe);

		PersonBean kelly = new PersonBeanImpl();
		kelly.setName("Kelly Klosure");
		kelly.setInterests("ebay, movies, music");
		kelly.setHotOrNotRating(6);
		datingDB.put(kelly.getName(), kelly);
	}
	
	PersonBean getPersonFromDatabase(String name) {							// 通过对象的键值对查找对象的方法
		return datingDB.get(name);
	}

	public void drive() {													
		PersonBean joe = getPersonFromDatabase("Joe Javabean");					// 从数据库中取出一个人
		PersonBean ownerProxy = getOwnerProxy(joe); 							// 创建一个Onwer代理
		System.out.println("Name is " + ownerProxy.getName());					// 调用getter显示名字
		ownerProxy.setInterests("bowling, Go");									// 调用setter设置兴趣	
		System.out.println("Interests set from owner proxy");				
		try {
			ownerProxy.setHotOrNotRating(10);									// 试着改变评分
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");			// 抛出异常
		}
		System.out.println("Rating is " + ownerProxy.getHotOrNotRating());		// 调用getter显示评分

		PersonBean nonOwnerProxy = getNonOwnerProxy(joe);						// 创建一个NonOwner代理
		System.out.println("Name is " + nonOwnerProxy.getName());				// 调用getter显示名字
		try {
			nonOwnerProxy.setInterests("bowling, Go");							// 调用setter设置兴趣	
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy"); 	// 抛出异常
		}
		nonOwnerProxy.setHotOrNotRating(3);										// 设置评分
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());	// 调用getter方法获得评分
	}

	/*
	 * step2:创建Proxy类并实例化Proxy对象。
	 */
	/*
	 * 此方法需要一个person对象作为参数，然后返回它的代理。
	 * 因为代理和主题有相同的接口，所以我们返回一个PersonBean。
	 * 
	 * newProxyInstance方法创建代理，需要参数：
	 * PersonBean类的类加载器，需要代理的接口，一个InvocationHandler。
	 */
	private PersonBean getOwnerProxy(PersonBean person) {

		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
	}

	private PersonBean getNonOwnerProxy(PersonBean person) {

		return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(),
				person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
	}
}

// output :
/*
Name is Joe Javabean
Interests set from owner proxy
Rating is 7
Name is Joe Javabean
Rating set from non owner proxy
Rating is 5
*/
