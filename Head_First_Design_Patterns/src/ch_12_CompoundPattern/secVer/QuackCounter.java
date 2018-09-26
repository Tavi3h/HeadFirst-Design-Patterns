package ch_12_CompoundPattern.secVer;

import ch_12_CompoundPattern.secVer.Quackable;

// 使用装饰者模式，给鸭子增加一些新行为
// QuackCounter是一个装饰者
public class QuackCounter implements Quackable {
	
	private Quackable duck;                      	
	private static int numberOfQuacks; 				// 使用一个静态变量记录所有quack的此时
	
	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}

	@Override
	public void quack() {
		duck.quack();
		numberOfQuacks++;
	}
	
	public static int getQuacks() {
		return numberOfQuacks;
	}

}
