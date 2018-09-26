package ch_12_CompoundPattern.firstVer;

import ch_12_CompoundPattern.secVer.Quackable;

public class MallardDuck implements Quackable {

	@Override
	public void quack() {
		System.out.println("Quack");
	}

}
