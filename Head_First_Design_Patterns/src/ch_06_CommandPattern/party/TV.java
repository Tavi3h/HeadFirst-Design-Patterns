package ch_06_CommandPattern.party;

public class TV {
	private String location;
	private int channel;

	public TV(String location) {
		this.location = location;
	}

	public void on() {
		System.out.println(location + " TV is on");
	}

	public void off() {
		System.out.println(location + " TV is off");
	}

	public void setInputChannel(int channel) {
		this.channel = channel;
		System.out.println(location + " TV channel is " + this.channel);
	}
}
