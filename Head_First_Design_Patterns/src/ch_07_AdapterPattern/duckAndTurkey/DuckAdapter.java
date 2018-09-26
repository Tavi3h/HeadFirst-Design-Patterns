package ch_07_AdapterPattern.duckAndTurkey;

public class DuckAdapter implements Turkey {

	private Duck duck;
	
	public DuckAdapter(Duck duck) {
		this.duck = duck;
	}
	
	@Override
	public void gobble() {
		duck.quack();
	}

	
	@Override
	public void fly() {
		duck.fly();
	}

}
