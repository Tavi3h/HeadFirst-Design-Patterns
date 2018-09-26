package ch_12_CompoundPattern.fourthVer;

import ch_12_CompoundPattern.fourthVer.ducks.*;
import ch_12_CompoundPattern.fourthVer.factories.AbstractDuckFactory;
import ch_12_CompoundPattern.fourthVer.factories.CountingDuckFactory;
import ch_12_CompoundPattern.fourthVer.factories.QuackCounter;

public class DuckSimulator {
	
	public static void main(String[] args) {
		DuckSimulator simulator = new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		simulator.simulate(duckFactory);
	}

	void simulate(AbstractDuckFactory duckFactory) {

		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		Quackable gooseDuck = new GooseAdapter(new Goose());

		Flock flockOfDucks = new Flock();

		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);

		Flock flockOfMallards = new Flock();

		Quackable mallardOne = duckFactory.createMallardDuck();
		Quackable mallardTwo = duckFactory.createMallardDuck();
		Quackable mallardThree = duckFactory.createMallardDuck();
		Quackable mallardFour = duckFactory.createMallardDuck();

		flockOfMallards.add(mallardOne);
		flockOfMallards.add(mallardTwo);
		flockOfMallards.add(mallardThree);
		flockOfMallards.add(mallardFour);

		flockOfDucks.add(flockOfMallards);

		System.out.println("\nDuck Simulator: With Observer");

		Quackologist quackologist0 = new Quackologist();
		Quackologist quackologist1 = new Quackologist();
		Quackologist quackologist2 = new Quackologist();
		Quackologist quackologist3 = new Quackologist();
		flockOfDucks.registerObserver(quackologist0);
		flockOfDucks.registerObserver(quackologist1);
		flockOfDucks.registerObserver(quackologist2);
		flockOfDucks.registerObserver(quackologist3);

		simulate(flockOfDucks);

		System.out.println("\nThe ducks quacked " + QuackCounter.getQuacks() + " times");
		
		/*
		 * 流程解释：
		 * 1、使用带计数器的工厂创建：{ 红头鸭、DuckCall、橡皮鸭、伪装成鸭子的鹅 }
		 * 2、创建一个Flock1，添加上述四个元素
		 * 3、创建另一个Flock2，使用工厂创建四个绿头鸭，并添加到Flock2中。
		 * 4、将Flock2添加至Flock1中。
		 * 5、创建4个观察者quackologist + id
		 * 6、Flock1中的所有元素对4个观察者进行注册。
		 * 		--注册：以红头鸭为例
		 * 			1）红头鸭调用registerObserver(quackologist0)对quackologist0进行注册。
		 * 			2）红头鸭内部维护的Observable调用registerObserver(quackologist0)进行注册。
		 * 			3）红头鸭内部维护的Observable调用add(quackologist0)方法将quackologist0添加到自己的观察者队列中以完成注册。
		 * 7、调用simulate(flockOfDucks)方法。
		 * 		--所有的元素依次调用自己的quack()方法：以红头鸭为例
		 * 			1）红头鸭调用自己的quack()方法。
		 * 			2）红头鸭调用自己的notifyObservers()方法。
		 * 			3）红头鸭内部维护的Observable调用notifyObservers()方法。
		 * 			4）红头鸭内部维护的Observable对内部观察者队列中的所有元素调用其自身的update()方法
		 * 			5）quackologist0的update()方法被调用，得知红头鸭叫了。
		 */
	}

	void simulate(Quackable duck) {
		duck.quack();
	}
}

// output:
/*

Duck Simulator: With Observer
Quack
Quackologist: 0 Redhead Duck just quacked.
Quackologist: 1 Redhead Duck just quacked.
Quackologist: 2 Redhead Duck just quacked.
Quackologist: 3 Redhead Duck just quacked.
Kwak
Quackologist: 0 Duck Call just quacked.
Quackologist: 1 Duck Call just quacked.
Quackologist: 2 Duck Call just quacked.
Quackologist: 3 Duck Call just quacked.
Squeak
Quackologist: 0 Rubber Duck just quacked.
Quackologist: 1 Rubber Duck just quacked.
Quackologist: 2 Rubber Duck just quacked.
Quackologist: 3 Rubber Duck just quacked.
Honk
Quackologist: 0 Goose pretending to be a Duck just quacked.
Quackologist: 1 Goose pretending to be a Duck just quacked.
Quackologist: 2 Goose pretending to be a Duck just quacked.
Quackologist: 3 Goose pretending to be a Duck just quacked.
Quack
Quackologist: 0 Mallard Duck just quacked.
Quackologist: 1 Mallard Duck just quacked.
Quackologist: 2 Mallard Duck just quacked.
Quackologist: 3 Mallard Duck just quacked.
Quack
Quackologist: 0 Mallard Duck just quacked.
Quackologist: 1 Mallard Duck just quacked.
Quackologist: 2 Mallard Duck just quacked.
Quackologist: 3 Mallard Duck just quacked.
Quack
Quackologist: 0 Mallard Duck just quacked.
Quackologist: 1 Mallard Duck just quacked.
Quackologist: 2 Mallard Duck just quacked.
Quackologist: 3 Mallard Duck just quacked.
Quack
Quackologist: 0 Mallard Duck just quacked.
Quackologist: 1 Mallard Duck just quacked.
Quackologist: 2 Mallard Duck just quacked.
Quackologist: 3 Mallard Duck just quacked.

The ducks quacked 7 times
*/
