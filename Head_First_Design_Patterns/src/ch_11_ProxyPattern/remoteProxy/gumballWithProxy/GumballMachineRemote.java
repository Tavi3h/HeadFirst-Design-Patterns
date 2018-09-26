package ch_11_ProxyPattern.remoteProxy.gumballWithProxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

import ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states.State;

// GumballMachine套用RMI框架
/*
 * 	客户堆：
 * 		|--GumballMonitor：监视器代码，它使用代理来和远程糖果机交流
 * 		|--GumballStub：此stub为GumballMachine的代理
 * 	服务器堆：
 * 		|--GumballSkeleton：skeleton接受远程调用，并且将这些调用转移到服务对象上
 * 		|--GumballMachine：GumballMachine是我们的远程服务，它为客户暴露一个远程接口以供使用。
 */

// 远程接口
public interface GumballMachineRemote extends Remote {
	
	public int getCount() throws RemoteException;
	public String getLocation() throws RemoteException;
	public State getState() throws RemoteException; // State需要实现Serializable接口

}
