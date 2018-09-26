package ch_11_ProxyPattern.remoteProxy.gumballWithOutProxy;

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		
		int count = 0;
		
		if (args.length < 2) {
			System.out.println("GumballMachine <Name> <Inventory>");
			System.exit(1);
		}
		
		count = Integer.parseInt(args[1]);
		GumballMachine gumballMachine = new GumballMachine(args[0], count);
		
		GumballMonitor gumballMonitor = new GumballMonitor(gumballMachine);
		
		// other test code ...
		
		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
		
		// other test code end ...
		
		gumballMonitor.report();
	}

}
// output:
/*

Mighty Gumball, Inc.
Java-enabled Standing Gumball Model #2004
Inventory: 10 gumballs
Machine is waiting for quarter

You inserted a quarter
You turned...
A gumball comes rolling out the slot...

Mighty Gumball, Inc.
Java-enabled Standing Gumball Model #2004
Inventory: 9 gumballs
Machine is waiting for quarter

You inserted a quarter
You turned...
A gumball comes rolling out the slot...
You inserted a quarter
You turned...
A gumball comes rolling out the slot...

Mighty Gumball, Inc.
Java-enabled Standing Gumball Model #2004
Inventory: 7 gumballs
Machine is waiting for quarter

Gumball Machine Beijing
Current Inventory 7
Current State waiting for quarter

*/
