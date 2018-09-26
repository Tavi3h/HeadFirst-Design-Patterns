package ch_06_CommandPattern.party;

public class TVOffCommand implements Command {
	private TV tv;

	public TVOffCommand(TV tv) {
		this.tv = tv;
	}

	public void execute() {
		tv.off();
	}

	public void undo() {
		tv.on();
	}
}
