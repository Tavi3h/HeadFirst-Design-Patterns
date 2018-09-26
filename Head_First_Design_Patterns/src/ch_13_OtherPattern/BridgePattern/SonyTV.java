package ch_13_OtherPattern.BridgePattern;

public class SonyTV implements TV {

	@Override
	public void on() {
		System.out.println("Sony TV is on");
	}

	@Override
	public void off() {
		System.out.println("Sony TV is off");
	}

	@Override
	public void turnChannel(int channel) {
		System.out.println("current channel is " + channel);
	}
}
