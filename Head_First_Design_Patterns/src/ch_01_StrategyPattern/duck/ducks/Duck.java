package ch_01_StrategyPattern.duck.ducks;

import ch_01_StrategyPattern.duck.flyBehavior.FlyBehavior;
import ch_01_StrategyPattern.duck.quackBehavior.QuackBehavior;

// 抽象基类Duck
public abstract class Duck {
	
	// 含有两个策略
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public Duck() {
		
	}
	
	public void swim() {
		System.out.println("All ducks float, even decoys");
	}
	
	public abstract void display();
	
	// 两个perform方法把具体的行为委托给了行为类
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}
	
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

}
