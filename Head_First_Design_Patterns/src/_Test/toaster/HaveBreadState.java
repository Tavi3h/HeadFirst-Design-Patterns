package _Test.toaster;

public class HaveBreadState implements State {

	private Toaster toaster;
	public HaveBreadState(Toaster toaster) {
		this.toaster = toaster;
	}

	@Override
	public void insertBread() {
		System.out.println("you can't insert two bread ... ");
	}

	@Override
	public void ejectBread() {
		System.out.println("bread ejecting ... ");
		toaster.setState(toaster.getNoBreadState());
	}

	@Override
	public void toastStart() {
		System.out.println("start toast ... ");
		toaster.setState(toaster.getToastState());
	}
	
	@Override 
	public void toastOver() {
		System.out.println("bread havn't been toasted ... ");
	}
	

	@Override
	public String getStateDescription() {
		
		return "Toaster in " + this.getClass().getSimpleName();
	}

}
