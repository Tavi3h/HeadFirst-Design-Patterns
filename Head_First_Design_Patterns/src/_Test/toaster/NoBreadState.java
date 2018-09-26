package _Test.toaster;

public class NoBreadState implements State {

	private Toaster toaster;

	public NoBreadState(Toaster toaster) {
		this.toaster = toaster;
	}

	@Override
	public void insertBread() {
		System.out.println("Insert a bread ...");
		toaster.setState(toaster.getHaveBreadState());
	}

	@Override
	public void ejectBread() {
		System.out.println("You got nothing, coz there is no bread in toaster ... ");
	}

	@Override
	public void toastStart() {
		System.out.println("warning no bread to toast ... ");
	}

	@Override
	public void toastOver() {
		System.out.println("Toast Over? you got be kidding me ... ");
	}

	@Override
	public String getStateDescription() {

		return "Toaster in " + this.getClass().getSimpleName();
	}

}
