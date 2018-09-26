package ch_13_OtherPattern.BridgePattern;

public abstract class RemoteControl {
	private TV tv;

	public void setTv(TV tv) {
		this.tv = tv;
	}
	
	public TV getTv() {
		return tv;
	}
	
	public void on() {
		tv.on();
	}
	public void off() {
		tv.off();
	}
	public void setChannel(int channel) {
		tv.turnChannel(channel);
	}
}
