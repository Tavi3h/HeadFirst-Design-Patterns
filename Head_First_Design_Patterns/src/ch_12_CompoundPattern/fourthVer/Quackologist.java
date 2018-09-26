package ch_12_CompoundPattern.fourthVer;

public class Quackologist implements Observer {
	
	private static int count = 0;
	private final int id = count++;

	@Override
	public void update(QuackObservable duck) {
		System.out.println("Quackologist: " + id + " " + duck + " just quacked.");
	}

}
