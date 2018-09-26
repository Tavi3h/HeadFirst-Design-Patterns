package ch_11_ProxyPattern.javaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
// step1:创建InvocationHandler
// 所有处理器都实现InvocationHandler接口
public class OwnerInvocationHandler implements InvocationHandler {
	
	private PersonBean person;	

	public OwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}

	// 每次proxy的方法被调用，就会导致proxy调用此方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		
		try {
			// 如果方法是一个getter，我们就调用Person内的方法
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
			// 如果调用的方法是setHotOrNotRating()，抛出异常表示不允许调用该方法
			} else if (method.getName().equals("setHotOrNotRating")) {
				throw new IllegalAccessException();
			// 如果是其它的set方法，由于我们是拥有者，所以我们可以在真正的主题上调用它
			} else if (method.getName().startsWith("set")) {
				return method.invoke(person, args);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 如果调用其它方法，则一律无视。
		return null;
	}

}
