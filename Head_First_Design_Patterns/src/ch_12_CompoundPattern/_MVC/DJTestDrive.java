package ch_12_CompoundPattern._MVC;
  
public class DJTestDrive {

    public static void main (String[] args) {
        BeatModelInterface model = new BeatModel();
		new BeatController(model);
    }
}
