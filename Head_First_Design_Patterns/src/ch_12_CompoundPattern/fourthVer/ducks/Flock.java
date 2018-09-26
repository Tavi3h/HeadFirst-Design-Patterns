package ch_12_CompoundPattern.fourthVer.ducks;

import java.util.Iterator;
import java.util.ArrayList;

import ch_12_CompoundPattern.fourthVer.Observer;
import ch_12_CompoundPattern.fourthVer.Quackable;

public class Flock implements Quackable {
	
	private ArrayList<Quackable> ducks = new ArrayList<>();
  
	public void add(Quackable duck) {
		ducks.add(duck);
	}
  
	public void quack() {
		Iterator<Quackable> iterator = ducks.iterator();
		while (iterator.hasNext()) {
			iterator.next().quack();
		}
	}
   
	public void registerObserver(Observer observer) {
		Iterator<Quackable> iterator = ducks.iterator();
		while (iterator.hasNext()) {
			iterator.next().registerObserver(observer);
		}
	}
  
	public void notifyObservers() { }
  
	public String toString() {
		return "Flock of Ducks";
	}
}
