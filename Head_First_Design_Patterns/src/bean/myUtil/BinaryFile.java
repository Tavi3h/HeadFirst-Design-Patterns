package bean.myUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// Utility for reading files in binary form.

public class BinaryFile {
	public static byte[] read(File bfile) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(bfile));
		try {
			byte[] data = new byte[bis.available()];
			bis.read(data);
			return data;
		} finally {
			bis.close();
		}

	}

	public static byte[] read(String bFile) throws IOException {
		return read(new File(bFile).getAbsoluteFile());
	}

}
