package _Test.toasterWithEnum;

public class ToasterMonitor implements Observer {
	
	private static int count = 0;
	private final int id = count++;

	@Override
	public void update(State state) {
		System.out.println("Monitor " + id + " Toaster current state is " + state.getDescription() + "\n");
	}

}
