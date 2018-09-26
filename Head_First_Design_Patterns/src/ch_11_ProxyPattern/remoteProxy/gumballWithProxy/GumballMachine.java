package ch_11_ProxyPattern.remoteProxy.gumballWithProxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states.HasQuarterState;
import ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states.NoQuarterState;
import ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states.SoldOutState;
import ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states.SoldState;
import ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states.State;
import ch_11_ProxyPattern.remoteProxy.gumballWithProxy.states.WinnerState;

// GumballMachine需要继承UnicastRemoteObject以成为一个远程服务，并实现GumballMachineRemote接口
public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

	private static final long serialVersionUID = -786526390517333904L;
	private State soldOutState;
	private State noQuarterState;
	private State hasQuarterState;
	private State soldState;
	private State winnerState;

	private State state = soldOutState;
	private int count = 0;
	private String location;

	// 抛出RemoteException异常
	public GumballMachine(String location, int numberGumballs) throws RemoteException {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		this.count = numberGumballs;

		// 位置信息在构造器中被初始化
		this.location = location;
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}

	public void insertQuarter() {
		state.insertQuarter();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	public int getCount() {
		return count;
	}
	
	public String getLocation() {
		return location;
	}

	public State getState() {
		return state;
	}
	
	void refill(int count) {
		this.count = count;
		state = noQuarterState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}
