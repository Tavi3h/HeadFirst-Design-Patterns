package ch_11_ProxyPattern.remoteProxy.gumballWithProxy;

import java.rmi.Naming;

public class GumballMonitorTestDrive {

	public static void main(String[] args) {
		// 被监视的位置
		
		String[] locations = {"santafe.mightygumball", "boulder.mightygumball","seattle.mightygumball"};
		
		// 监视器
		GumballMonitor[] monitor = new GumballMonitor[locations.length];

		for (int i = 0; i < locations.length; i++) {
			try {
				GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup("rmi://10.170.66.15/" + locations[i]);
				monitor[i] = new GumballMonitor(machine);		
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (int j = 0; j < monitor.length; j++) {			
			monitor[j].report();
			System.out.println();
		}
	}
}
