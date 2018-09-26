package ch_06_CommandPattern.simpleremote;

//
// This is the invoker
//
public class SimpleRemoteControl {

	private Command slot;

	public SimpleRemoteControl() {
	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}
}
