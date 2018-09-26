package bean.myUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

// Static functions for reading and writing text files as 
// a single string, and treating a file as an ArrayList

@SuppressWarnings("serial")
public class TextFile extends ArrayList<String> {

	// Read a file as a single string
	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}

	// Write a single file in one method call:
	public static void write(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// Read a file, split by any regular expression
	public TextFile(String fileName, String splitter) {
		// 静态的read方法先读取fileName指向的文件，读完后返回一个包含整个文件的字符串。
		// 用splitter对字符串进行切割，得到一个字符串数组
		// 使用asList方法将字符串数组转为List，并作为参数传给父类构造器。
		super(Arrays.asList(read(fileName).split(splitter)));
		// Regular expression split() often leaves an empty
		// String at the first position:
		if (get(0).equals(""))
			remove(0);
	}
	
	// Normally read by lines
	public TextFile(String fileName) {
		// 调用构造器：TextFile(String fileName, String splitter)，换行符作为分割字符串的正则表达式
		this(fileName, "\n");
	}
	
	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for (String item : this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// Simple Test
	public static void main(String[] args) {
		// 使用静态的read方法将一个文本文件写入流中，再使用静态的write方法将流中的内容写到一个文件中。
		// 这两个静态方法不涉及TextFile作为容器的属性
		String file = read("G:\\Programming\\myCode\\Eclipse_Work\\TIJ_And_ItcastVideo\\src\\bean\\myUtil\\TextFile.java");
		write("G:\\Programming\\myCode\\Eclipse_Work\\TIJ_And_ItcastVideo\\src\\ch18_IOSystem\\TestFileFolder\\TestFileData.txt", file);
		
		// 创建TextFile对象，构造器参数为单一文件路径。
		// 将该文本文件中的内容以换行符分割作为元素存入
		// 涉及TextFile作为容器(ArrayList)的属性
		// 调用非静态方法write。
		TextFile text = new TextFile("G:\\Programming\\myCode\\Eclipse_Work\\TIJ_And_ItcastVideo\\src\\ch18_IOSystem\\TestFileFolder\\TestFileData.txt");
		text.write("G:\\Programming\\myCode\\Eclipse_Work\\TIJ_And_ItcastVideo\\src\\ch18_IOSystem\\TestFileFolder\\TestFileData2.txt");
		
		// Break into unique sorted list of words:
		TreeSet<String> words = new TreeSet<>(new TextFile(
				"G:\\Programming\\myCode\\Eclipse_Work\\TIJ_And_ItcastVideo\\src\\bean\\myUtil\\TextFile.java",
				"\\W+"));
		// Display the capitalized words:
		System.out.println(words.headSet("a"));

	}
}

// output:
/*
[0, ArrayList, Arrays, Break, BufferedReader, Display, Eclipse_Work, File, FileReader, G, IOException, 
Normally, PrintWriter, Programming, Read, Regular, RuntimeException, Simple, Static, String, StringBuilder, 
SuppressWarnings, System, TIJ_And_ItcastVideo, Test, TestFileData, TestFileData2, TestFileFolder, TextFile, TreeSet, W, Write]
*/
