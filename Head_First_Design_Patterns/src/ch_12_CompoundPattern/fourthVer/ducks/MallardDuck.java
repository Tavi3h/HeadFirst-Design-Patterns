package ch_12_CompoundPattern.fourthVer.ducks;

import ch_12_CompoundPattern.fourthVer.Observable;
import ch_12_CompoundPattern.fourthVer.Observer;
import ch_12_CompoundPattern.fourthVer.Quackable;

public class MallardDuck implements Quackable {
	private Observable observable;
 
	public MallardDuck() {
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
		return "Mallard Duck";
	}
}
