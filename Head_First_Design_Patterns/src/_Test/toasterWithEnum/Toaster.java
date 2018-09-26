package _Test.toasterWithEnum;

import java.util.ArrayList;
import java.util.Iterator;

public class Toaster implements Subject {

	private State state;
	private ToastActor toastActor;
	private ArrayList<Observer> arrayList = new ArrayList<>(); 
	
	public Toaster() {
		state = State.NO_BREAD;
		toastActor = new ToastActor(this);
	}
	
	public void setState(State state) {
		this.state = state;
		notifyObservers();
	}
	
	public State getState() {
		return state;
	}
	
	public void insertBread() {
		toastActor.insertBread();
	}
	
	public void ejectBread() {
		toastActor.ejectBread();
	}
	
	public void toastStart() {
		toastActor.toastStart();
	}
	
	public void toastOver() {
		toastActor.toastOver();
	}


	@Override
	public void registerObserver(Observer o) {
		arrayList.add(o);
	}


	@Override
	public void notifyObservers() {
		for (int i = 0; i < arrayList.size(); i++) {
			arrayList.get(i).update(state);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		Iterator<Observer> it = arrayList.iterator();
		while (it.hasNext()) {
			if (it.next().equals(o))
				it.remove();
		}
	}

}
