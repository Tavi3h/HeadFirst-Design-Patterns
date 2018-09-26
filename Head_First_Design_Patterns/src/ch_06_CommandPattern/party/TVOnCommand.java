package ch_06_CommandPattern.party;

public class TVOnCommand implements Command {
	private TV tv;

	public TVOnCommand(TV tv) {
		this.tv = tv;
	}

	public void execute() {
		tv.on();
		tv.setInputChannel(3); // 默认把电视设置在#3 Channel
	}

	public void undo() {
		tv.off();
	}
}
