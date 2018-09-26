package ch_11_ProxyPattern.javaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//step1:创建InvocationHandler
//所有处理器都实现InvocationHandler接口
public class NonOwnerInvocationHandler implements InvocationHandler {

	private PersonBean person;

	public NonOwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
		
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
			} else if (method.getName().equals("setHotOrNotRating")) {
				return method.invoke(person, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
