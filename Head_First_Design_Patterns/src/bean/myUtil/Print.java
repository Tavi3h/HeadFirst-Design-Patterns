
/*
 * Print methods that can be used without qualifiers , using java SE5static imports:
 */
package bean.myUtil;
import java.io.PrintStream;

/**
 * @ClassName: Print
 * @Description:  打印方法工具类
 * @author: Tavish
 * @date: 2017年6月1日 下午7:28:51
 */

public class Print {
	
	private Print() {}

	// Print with a newLine
	public static void print(Object obj) {
		System.out.println(obj);
	}

	// Print a newLine by itself
	public static void print() {
		System.out.println();
	}

	// Print with no line break
	public static void printnb(Object obj) {
		System.out.print(obj);
	}

	// Java SE5 printf()
	public static PrintStream printf(String format, Object... args) {
		return System.out.printf(format, args);
	}
	public static PrintStream format(String format, Object... args) {
		return System.out.format(format, args);	
	}
}
