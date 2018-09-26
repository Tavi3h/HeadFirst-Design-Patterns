package _Test.toasterWithEnum;
import static _Test.toasterWithEnum.State.*;

public class ToastActor {	
	
	private Toaster toaster ;
	
	public ToastActor(Toaster toaster) {
		this.toaster = toaster;
	}
		
	public void insertBread() {
		
		switch(toaster.getState()) {
		case NO_BREAD :
			System.out.println("Insert a bread ... ");
			toaster.setState(HAVE_BREAD);
			break;
		case HAVE_BREAD :
			System.out.println("You can't insert twice ... ");
			break;
		case TOAST_START :
			System.out.println("can't insert bread while toasting ... ");
			break;
		case TOAST_OVER :
			System.out.println("toasted bread haven't ejected ...");
			break;
		}
	}
	
	public void ejectBread() {
		switch(toaster.getState()) {
		case NO_BREAD :
			System.out.println("No bread to eject ... ");
			break;
		case HAVE_BREAD :
			System.out.println("eject bread ... ");
			toaster.setState(NO_BREAD);
			break;
		case TOAST_START :
			System.out.println("can't eject now ... ");
			break;
		case TOAST_OVER :
			System.out.println("eject toasted bread ...");
			toaster.setState(NO_BREAD);
			break;
		}
	}
	public void toastStart() {
		switch(toaster.getState()) {
		case NO_BREAD :
			System.out.println("No bread to toast ... ");
			break;
		case HAVE_BREAD :
			System.out.println("starting toast ... ");
			toaster.setState(TOAST_START);
			break;
		case TOAST_START :
			System.out.println("still toasting ... ");
			break;
		case TOAST_OVER :
			System.out.println("can't toast twice ...");
			break;
		}
	}
	public void toastOver() {
		switch(toaster.getState()) {
		case NO_BREAD :
			System.out.println("there is no bread and toast didn't run ... ");
			break;
		case HAVE_BREAD :
			System.out.println("toast didn't run ... ");
			break;
		case TOAST_START :
			System.out.println("toast done ... ");
			toaster.setState(TOAST_OVER);
			break;
		case TOAST_OVER :
			System.out.println("toast didn't run ...");
			break;
		}
	}
}
