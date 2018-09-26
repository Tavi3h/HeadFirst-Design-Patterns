package ch_12_CompoundPattern.secVer.factories;

import ch_12_CompoundPattern.secVer.Quackable;

// 抽象工厂模式
// 创建一个工厂，创建装饰过的鸭子。
public abstract class AbstractDuckFactory {
	
	public abstract Quackable createMallardDuck();
	public abstract Quackable createRedheadDuck();
	public abstract Quackable createDuckCall();
	public abstract Quackable createRubberDuck();
	
}
