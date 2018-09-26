package ch_03_DecoratorPattern.myIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {

	static String fileName = "E:\\Programming\\myCode\\Eclipse_Prog\\Head_First_Design_Patterns\\src\\ch_03_DecoratorPattern\\myIO\\test.txt";

	public static void main(String[] args) throws IOException {
	
		int c;   
		InputStream in = null;
		try {
			in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream(fileName)));
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

	}

}

// output:
/*
i know the decorator pattern therefore i rule!
*/