package ch_06_CommandPattern.remote;

public class GarageDoorDownCommand implements Command {
	private GarageDoor garageDoor;

	public GarageDoorDownCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	public void execute() {
		garageDoor.down();
	}
}
