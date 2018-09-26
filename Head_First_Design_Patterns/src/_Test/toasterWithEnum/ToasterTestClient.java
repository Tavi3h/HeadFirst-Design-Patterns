package _Test.toasterWithEnum;

public class ToasterTestClient {
	public static void main(String[] args) {
		Toaster t = new Toaster();
		ToasterMonitor tm = new ToasterMonitor();
		t.registerObserver(tm);
		t.insertBread();
		t.toastStart();
		t.toastOver();
		t.ejectBread();
	}
}
