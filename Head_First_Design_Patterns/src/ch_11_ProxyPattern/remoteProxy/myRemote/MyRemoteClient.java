package ch_11_ProxyPattern.remoteProxy.myRemote;

import java.rmi.Naming;
/*
 * 运行顺序：
 * RMI Control Center: Start local Registry
 * 服务端MyRemoteImpl: Run as RMI Application
 * 客户端MyRemoteClient: Run as Java Application
 */
// 客户端代码
public class MyRemoteClient {
	
	public static void main(String[] args) {
		new MyRemoteClient().go();
	}

	public void go() {
		try {
			// 客户到RMI registry中寻找，RMI registry返回Stub对象
			/*
			 * P449
			 * 客户使用远程接口调用stub的方法。
			 * 虽然客户JVM需要stub类，但从不在代码中引用stub类。
			 * 客户总是使用远程接口（MyRemote）。
			 * 就如同远程接口就是真正的远程对象一样。
			 */
			MyRemote service = (MyRemote) Naming.lookup("rmi://10.170.66.15/RemoteHello"); // "rmi://ip address or hostname/绑定时用的名称"
			// 客户调用stub的方法，就像stub就是真正的服务对象一样
			String s = service.sayHello();
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
