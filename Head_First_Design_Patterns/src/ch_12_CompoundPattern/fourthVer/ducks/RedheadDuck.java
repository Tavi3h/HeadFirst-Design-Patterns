package ch_12_CompoundPattern.fourthVer.ducks;

import ch_12_CompoundPattern.fourthVer.Observable;
import ch_12_CompoundPattern.fourthVer.Observer;
import ch_12_CompoundPattern.fourthVer.Quackable;

public class RedheadDuck implements Quackable {
	private Observable observable;

	public RedheadDuck() {
		observable = new Observable(this);
	}

	public void quack() {
		System.out.println("Quack");
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}

	public String toString() {
		return "Redhead Duck";
	}
}
