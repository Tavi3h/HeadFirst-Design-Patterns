package ch_12_CompoundPattern.fourthVer.ducks;

import ch_12_CompoundPattern.fourthVer.Observable;
import ch_12_CompoundPattern.fourthVer.Observer;
import ch_12_CompoundPattern.fourthVer.Quackable;

public class DecoyDuck implements Quackable {
	private Observable observable;

	public DecoyDuck() {
		observable = new Observable(this);
	}
 
	public void quack() {
		System.out.println("<< Silence >>");
		notifyObservers();
	}
 
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}
 
	public String toString() {
		return "Decoy Duck";
	}
}
