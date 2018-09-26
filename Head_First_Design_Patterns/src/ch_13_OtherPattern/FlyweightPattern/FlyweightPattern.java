package ch_13_OtherPattern.FlyweightPattern;

public class FlyweightPattern {
	
	FlyweightFactory fwfactory = new FlyweightFactory();
	
	Flyweight fw1;
	Flyweight fw2;
	Flyweight fw3;
	Flyweight fw4;
	Flyweight fw5;
	Flyweight fw6;
	Flyweight fw7;
	
	public FlyweightPattern() {
		fw1 = fwfactory.getFlyweight("Google");
		fw2 = fwfactory.getFlyweight("Google");
		fw3 = fwfactory.getFlyweight("Google");
		fw4 = fwfactory.getFlyweight("Baidu");
		fw5 = fwfactory.getFlyweight("Baidu");
		fw6 = fwfactory.getFlyweight("Bing");
		fw7 = fwfactory.getFlyweight("Bing");
	}
	
	public void showFlyweight() {
		fw1.operation();
		fw2.operation();
		fw3.operation();
		fw4.operation();
		fw5.operation();
		fw6.operation();
		fw7.operation();
		
		int objNum = fwfactory.getfwMapSize();
		System.out.println("objNum = " + objNum);
	}

	public static void main(String[] args) {
		System.out.println("The Flyweight Pattern!");
		FlyweightPattern fwp = new FlyweightPattern();
		fwp.showFlyweight();
	}

}
