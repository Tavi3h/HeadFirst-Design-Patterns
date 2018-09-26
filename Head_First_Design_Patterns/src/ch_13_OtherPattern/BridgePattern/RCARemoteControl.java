package ch_13_OtherPattern.BridgePattern;

public class RCARemoteControl extends RemoteControl {

	private int currentStation = 0;
	
	public RCARemoteControl(TV tv) {
		setTv(tv);
		System.out.println("RCA Remote Control is on");
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
