package ch_07_AdapterPattern.duckAndTurkey;

public class DuckTestDrive {
	
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}

	public static void main(String[] args) {
		
		MallardDuck duck = new MallardDuck(); // 创建一只鸭子
		
		WildTurkey turkey = new WildTurkey(); // 创建一只火鸡
		
		Duck turkeyAdapter = new TurkeyAdapter(turkey); // 将火鸡包装进一个火鸡适配器中，使它看起来像一只鸭子
		
		System.out.println("The Turkey says..."); // 测试火鸡
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\nThe Duck says..."); // 测试鸭子
		testDuck(duck);
		
		System.out.println("\nThe TurkeyAdapter says..."); // 测试假装是鸭子的火鸡
		testDuck(turkeyAdapter);

	}

}
// output:
/*
The Turkey says...
Gobble gobble
I'm flying a short distance

The Duck says...
Quack
I'm Flying

The TurkeyAdapter says...
Gobble gobble
I'm flying a short distance
I'm flying a short distance
I'm flying a short distance
I'm flying a short distance
I'm flying a short distance
*/