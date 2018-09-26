package _Test.toaster;

public class ToastState implements State {
	
	private Toaster toaster;
	public ToastState(Toaster toaster) {
		this.toaster = toaster;
	}

	@Override
	public void insertBread() {
		System.out.println("you can't insert a bread while toasting ... ");
	}

	@Override
	public void ejectBread() {
		System.out.println("you can't eject bread while toasting ... ");
	}

	@Override
	public void toastStart() {
		System.out.println("still toasting ... ");
	}
	
	@Override 
	public void toastOver() {
		System.out.println("Toast over ...");
		toaster.setState(toaster.getDoneState());
	}

	@Override
	public String getStateDescription() {
		
		return "Toaster in " + this.getClass().getSimpleName();
	}

}
