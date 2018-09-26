package ch_06_CommandPattern.undo;

public class LightOnCommand implements Command {
	private Light light;
 
	public LightOnCommand(Light light) {
		this.light = light;
	}
 
	public void execute() {
		light.on();
	}
 
	public void undo() {
		light.off();
	}
}
