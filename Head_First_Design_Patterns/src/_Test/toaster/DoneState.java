package _Test.toaster;

public class DoneState implements State {

	private Toaster toaster;
	public DoneState(Toaster toaster) {
		this.toaster = toaster;
	}

	@Override
	public void insertBread() {
		System.out.println("you can't insert a bread while there is already one ... ");
	}

	@Override
	public void ejectBread() {
		System.out.println("Toasted bread out ... ");
		toaster.setState(toaster.getNoBreadState());
	}

	@Override
	public void toastStart() {
		System.out.println("Toast already done, can't do it twice with a bread ... ");
	}
	
	@Override 
	public void toastOver() {
		System.out.println("Toast didn't start at all ...");
	}

	@Override
	public String getStateDescription() {
		
		return "Toaster in " + this.getClass().getSimpleName();
	}
}
