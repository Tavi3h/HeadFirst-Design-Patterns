package ch_12_CompoundPattern.firstVer;

import ch_12_CompoundPattern.secVer.Quackable;

// 定义适配器
public class GooseAdapter implements Quackable {
	private Goose goose;
	
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}
	
	public void quack() {
		goose.honk();
	}

}
