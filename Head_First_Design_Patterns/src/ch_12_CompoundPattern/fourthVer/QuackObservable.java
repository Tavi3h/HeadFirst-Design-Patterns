package ch_12_CompoundPattern.fourthVer;

public interface QuackObservable {
	
	public void registerObserver(Observer obserber);
	public void notifyObservers();

}
