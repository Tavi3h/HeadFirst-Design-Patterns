package bean.myUtil;
import java.io.File;
import java.util.Scanner;
// 将文件夹1中的文件/文件夹移动到文件夹2中
public class FileMover {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Input src path: ");
		Scanner srcScan = new Scanner(System.in);
		String srcPath = srcScan.nextLine();

		System.out.println("Input dest path: ");
		Scanner destScan = new Scanner(System.in);
		String destPath = destScan.nextLine();

		work(srcPath, destPath);
	}

	public static void work(String srcPath, String destPath) {
		folderCreater(destPath);
		fileMover(srcPath, destPath);
	}

	public static void folderCreater(String destPath) {
		File dest = new File(destPath);
		if (dest.isFile()) {
			throw new RuntimeException("Illegal Input !");
		}
		if (!dest.exists())
			dest.mkdirs();
	}

	public static void fileMover(String srcPath, String destPath) {
		File srcFiles = new File(srcPath);
		String[] filenames = srcFiles.list();
		for (int i = 0; i < filenames.length; i++) {
			try {
				File files = new File(srcPath + "\\\\" + filenames[i]);
				if (files.renameTo(new File(destPath + "\\\\" + filenames[i]))) {
					System.out.println(filenames[i] + " is moved successful!");
				} else {
					System.out.println("Failed to move " + filenames[i]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
