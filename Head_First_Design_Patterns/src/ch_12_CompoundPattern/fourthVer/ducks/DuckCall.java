package ch_12_CompoundPattern.fourthVer.ducks;

import ch_12_CompoundPattern.fourthVer.Observable;
import ch_12_CompoundPattern.fourthVer.Observer;
import ch_12_CompoundPattern.fourthVer.Quackable;

public class DuckCall implements Quackable {
	private Observable observable;

	public DuckCall() {
		observable = new Observable(this);
	}
 
	public void quack() {
		System.out.println("Kwak");
		notifyObservers();
	}
 
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
 
	public String toString() {
		return "Duck Call";
	}
}
