package ch_11_ProxyPattern.remoteProxy.gumballWithProxy;

import java.rmi.Naming;

/*
 * args:
 * 
 * santafe 100
 * boulder 120
 * seattle 90
 */
public class GumballMachineTestDrive {

	public static void main(String[] args) {
		
		GumballMachineRemote gumballMachine = null;
		int count = Integer.parseInt(args[1]);		
		try {
			gumballMachine = new GumballMachine(args[0], count);
			Naming.bind(args[0] + ".mightygumball", gumballMachine);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
