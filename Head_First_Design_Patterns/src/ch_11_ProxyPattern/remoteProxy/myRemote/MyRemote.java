package ch_11_ProxyPattern.remoteProxy.myRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;
// 扩展Remote接口（1.1）
public interface MyRemote extends Remote {	
	// 确定返回值类型可用（1.3）
	public String sayHello() throws RemoteException;	// 抛出RemoteException（1.2）
}
