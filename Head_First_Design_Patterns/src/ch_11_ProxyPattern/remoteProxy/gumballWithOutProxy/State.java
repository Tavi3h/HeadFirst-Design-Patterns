package ch_11_ProxyPattern.remoteProxy.gumballWithOutProxy;

public interface State {
 
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();
}
