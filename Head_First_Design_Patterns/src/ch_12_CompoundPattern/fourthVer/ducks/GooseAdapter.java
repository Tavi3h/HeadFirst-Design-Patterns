package ch_12_CompoundPattern.fourthVer.ducks;

import ch_12_CompoundPattern.fourthVer.Observable;
import ch_12_CompoundPattern.fourthVer.Observer;
import ch_12_CompoundPattern.fourthVer.Quackable;

public class GooseAdapter implements Quackable {
	private Goose goose;
	private Observable observable;

	public GooseAdapter(Goose goose) {
		this.goose = goose;
		observable = new Observable(this);
	}
 
	public void quack() {
		goose.honk();
		notifyObservers();
	}

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}

	public void notifyObservers() {
		observable.notifyObservers();
	}

	public String toString() {
		return "Goose pretending to be a Duck";
	}
}
