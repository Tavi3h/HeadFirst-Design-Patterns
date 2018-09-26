package _Test.toaster;

public interface State {
	
	public void insertBread();
	public void ejectBread();
	public void toastStart();
	public void toastOver();
	
	public String getStateDescription();

}
