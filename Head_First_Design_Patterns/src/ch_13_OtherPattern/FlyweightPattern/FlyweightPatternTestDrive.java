package ch_13_OtherPattern.FlyweightPattern;

public class FlyweightPatternTestDrive {
	
	FlyweightFactory fwfactory = new FlyweightFactory();
	
	private Flyweight fw1;
	private Flyweight fw2;
	private Flyweight fw3;
	private Flyweight fw4;
	private Flyweight fw5;
	private Flyweight fw6;
	private Flyweight fw7;
	
	public FlyweightPatternTestDrive() {
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
		new FlyweightPatternTestDrive().showFlyweight();
	}
}
