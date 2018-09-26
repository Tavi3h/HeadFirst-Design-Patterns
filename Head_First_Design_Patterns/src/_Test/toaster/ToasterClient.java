package _Test.toaster;

public class ToasterClient {

	public static void main(String[] args) {

		Toaster toaster = new Toaster();
		ToasterMonitor tm = new ToasterMonitor();
		toaster.registerObserver(tm);

		toaster.insertBread();
		toaster.ejectBread();

		toaster.toastStart();
		
		toaster.insertBread();
		toaster.toastStart();
		toaster.toastOver();
		toaster.ejectBread();

	}

}
