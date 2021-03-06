package ch_06_CommandPattern.remote;

public class CeilingFanOnCommand implements Command {
	private CeilingFan ceilingFan;

	public CeilingFanOnCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	public void execute() {
		ceilingFan.high();
	}
}
