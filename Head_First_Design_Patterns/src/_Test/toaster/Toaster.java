package _Test.toaster;

import java.util.ArrayList;
import java.util.Iterator;

public class Toaster implements Subject {

	private State noBreadState;
	private State haveBreadState;
	private State toastState;
	private State doneState;

	private State state;

	private ArrayList<Observer> arraylist = new ArrayList<>();

	public Toaster() {
		noBreadState = new NoBreadState(this);
		haveBreadState = new HaveBreadState(this);
		toastState = new ToastState(this);
		doneState = new DoneState(this);

		state = noBreadState;
	}

	public void insertBread() {
		state.insertBread();
	}

	public void ejectBread() {
		state.ejectBread();
	}

	public void toastStart() {
		state.toastStart();
	}

	public void toastOver() {
		state.toastOver();
	}

	public void setState(State state) {
		this.state = state;
		notifyObservers();
	}

	public State getState() {
		return state;
	}

	public String getStateDescription() {

		return "Toaster in " + state.getClass().getSimpleName();
	}

	public State getNoBreadState() {
		return noBreadState;
	}

	public State getHaveBreadState() {
		return haveBreadState;
	}

	public State getToastState() {
		return toastState;
	}

	public State getDoneState() {
		return doneState;
	}

	@Override
	public void registerObserver(Observer o) {
		arraylist.add(o);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < arraylist.size(); i++) {
			arraylist.get(i).update(state);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		Iterator<Observer> it = arraylist.iterator();
		while (it.hasNext()) {
			if (it.next().equals(o))
				it.remove();
		}
	}

}
