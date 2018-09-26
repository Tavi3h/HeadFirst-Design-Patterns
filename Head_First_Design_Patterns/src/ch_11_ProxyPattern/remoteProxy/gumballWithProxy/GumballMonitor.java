package ch_11_ProxyPattern.remoteProxy.gumballWithProxy;

import java.rmi.RemoteException;

public class GumballMonitor {

	private GumballMachineRemote machine;

	public GumballMonitor(GumballMachineRemote machine) {
		this.machine = machine;
	}

	public void report() {
		try {
			System.out.println("Gumball Machine " + machine.getLocation());
			System.out.println("Current Inventory " + machine.getCount());
			System.out.println("Current State " + machine.getState());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
