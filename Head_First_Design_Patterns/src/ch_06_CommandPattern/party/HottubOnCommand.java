package ch_06_CommandPattern.party;

public class HottubOnCommand implements Command {
	private Hottub hottub;

	public HottubOnCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	public void execute() {
		hottub.on();
		hottub.setTemperature(104);
		hottub.circulate();
	}

	public void undo() {
		hottub.off();
	}
}
