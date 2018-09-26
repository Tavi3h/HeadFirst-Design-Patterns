package ch_12_CompoundPattern.thirdVer.factories;

import ch_12_CompoundPattern.thirdVer.DuckCall;
import ch_12_CompoundPattern.thirdVer.MallardDuck;
import ch_12_CompoundPattern.thirdVer.Quackable;
import ch_12_CompoundPattern.thirdVer.RedheadDuck;
import ch_12_CompoundPattern.thirdVer.RubberDuck;

// 创建一个工厂，此工厂创建没有装饰者的鸭子
public class DuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {
		
		return new MallardDuck();
	}


	@Override
	public Quackable createRedheadDuck() {
		
		return new RedheadDuck();
	}


	@Override
	public Quackable createDuckCall() {
		
		return new DuckCall();
	}


	@Override
	public Quackable createRubberDuck() {
		
		return new RubberDuck();
	}

}
