package ch_12_CompoundPattern.secVer.factories;

import ch_12_CompoundPattern.secVer.RubberDuck;
import ch_12_CompoundPattern.secVer.DuckCall;
import ch_12_CompoundPattern.secVer.MallardDuck;
import ch_12_CompoundPattern.secVer.QuackCounter;
import ch_12_CompoundPattern.secVer.Quackable;
import ch_12_CompoundPattern.secVer.RedheadDuck;

// 创建带有装饰者的工厂
public class CountingDuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {

		return new QuackCounter(new MallardDuck());
	}

	@Override
	public Quackable createRedheadDuck() {

		return new QuackCounter(new RedheadDuck());
	}

	@Override
	public Quackable createDuckCall() {

		return new QuackCounter(new DuckCall());
	}

	@Override
	public Quackable createRubberDuck() {

		return new QuackCounter(new RubberDuck());
	}

}
