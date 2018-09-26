package ch_09_IteratorPattern;

public class MenuTestDrive {

	public static void main(String[] args) {

		PancakeHouseMenu phm = new PancakeHouseMenu();
		DinerMenu dm = new DinerMenu();
		CafeMenu cm = new CafeMenu();

		Waitress waitress = new Waitress(phm, dm, cm);

		waitress.printMenu();		

	}

}
