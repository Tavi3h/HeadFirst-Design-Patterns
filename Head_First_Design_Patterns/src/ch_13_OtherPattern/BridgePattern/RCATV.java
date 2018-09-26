package ch_13_OtherPattern.BridgePattern;

public class RCATV implements TV {

	@Override
	public void on() {
		System.out.println("RCA TV is on");
	}

	@Override
	public void off() {
		System.out.println("RCA TV is off");
	}

	@Override
	public void turnChannel(int channel) {
		System.out.println("current channel is " + channel);
	}
}
