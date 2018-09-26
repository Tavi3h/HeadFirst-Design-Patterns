
package _Test.toasterWithEnum;

public enum State {
	
	NO_BREAD("No bread state"), 
	HAVE_BREAD("Have bread state"), 
	TOAST_START("Toast running state"), 
	TOAST_OVER("Toast done state");

	private String description;

	private State(String str) {
		description = str;
	}

	public String getDescription() {
		return description;
	}
}
