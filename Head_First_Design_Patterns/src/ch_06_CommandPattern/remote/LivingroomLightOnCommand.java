package ch_06_CommandPattern.remote;

public class LivingroomLightOnCommand implements Command {
	private Light light;

	public LivingroomLightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}
}
