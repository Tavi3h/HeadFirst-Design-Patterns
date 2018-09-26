package ch_10_StatePattern.gumball.secVer;

public interface State {
	
	public void insertQuarter();
	public void ejectQuarter();
	public void turnCrank();
	public void dispense();

}
