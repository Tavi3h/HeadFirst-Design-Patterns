package ch_13_OtherPattern.BridgePattern;

public class BridgePatternTestDrive {

	public static void main(String[] args) {
		TV rca = new RCATV();
		TV sony = new SonyTV();
		
		RCARemoteControl rrc = new RCARemoteControl(rca);
		SonyRemoteControl src = new SonyRemoteControl(sony);
		
		rrc.on();
		src.on();
		
		rrc.setChannel(11);
		rrc.nextChannel();
		rrc.previousChannel();
		
		src.setChannel(5);
		src.previousChannel();
		src.nextChannel();
	}
}
