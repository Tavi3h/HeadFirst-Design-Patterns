package ch_12_CompoundPattern._MVC;
  
public class HeartTestDrive {

    public static void main (String[] args) {
		HeartModel heartModel = new HeartModel();
        new HeartController(heartModel);
    }
}
