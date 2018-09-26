package ch_13_OtherPattern.BridgePattern;

public class SonyRemoteControl extends RemoteControl {

	private int currentStation = 0;
	
	public SonyRemoteControl(TV tv) {
		setTv(tv);
		System.out.println("Sony Remote Control is on");
	}
	
	@Override
	public void setChannel(int channel) {
		super.setChannel(channel);
		currentStation = currentStation == channel ? currentStation : channel;
	}
	
	public void nextChannel() {
		setChannel(++currentStation);
	}
	
	public void previousChannel() {
		setChannel(--currentStation);
	}

}
