package ch_11_ProxyPattern.remoteProxy.myRemote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
// 服务类实现远程接口MyRemote （2.1）
// 继承UnicastRemoteObject类（2.2）
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	private static final long serialVersionUID = 6622532274853687487L;

	// 构造一个不带变量的空构造器，声明抛出RemoteException（2.3）
	protected MyRemoteImpl() throws RemoteException {
		
	}

	@Override
	public String sayHello() throws RemoteException {
		return "Server says, 'Hey'";
	}
	
	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImpl();
			// 绑定的服务名
			Naming.rebind("RemoteHello", service);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
