package ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states;

import java.io.Serializable;
// 每个State对象都维护一个对糖果机的引用，我们不希望它也被序列化并随着
// State对象一起传送，所以用transient修饰所有State的具体实现类内的糖果机引用
public interface State extends Serializable {
 
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
