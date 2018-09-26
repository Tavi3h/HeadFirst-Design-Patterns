package ch_06_CommandPattern.undo;

public interface Command {
	public void execute();
	public void undo();
}
