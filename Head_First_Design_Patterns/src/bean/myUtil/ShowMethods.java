package bean.myUtil;

import static bean.myUtil.Print.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

// Using reflection to show all the methods of a class.
// even if the methods are defined in the base class
// Args: ch14_TypeInfo.CheckBeforeCast.IndividualInheritance.PetUtil.PetCreator
// 可以使用一个或者两个参数，第一个参数为类，第二个参数为用于提取特定信息的特征签名。
// 当使用一个参数时，会输出该类的所有方法及构造器
// 当使用两个参数时，会输出全名中含有该特征签名的方法及构造器 

public class ShowMethods {
	private static String usage = "usage:\n" + "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or:\n" + "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";
	
	// 该正则表达式用于去掉方法及构造器的复杂的包名
	private static Pattern p = Pattern.compile("\\w+\\.");

	public static void main(String[] args) {
		if (args.length < 1) {
			print(usage);
			System.exit(0);
		}
		@SuppressWarnings("unused")
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor<?>[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods) {
					print(p.matcher(method.toString()).replaceAll(""));
//					print(method.toString());
				}
				for (Constructor<?> ctor : ctors) {
					print(p.matcher(ctor.toString()).replaceAll(""));
				}
				lines = methods.length + ctors.length;
			} else {
				for (Method method : methods) {
					if (method.toString().indexOf(args[1]) != -1) {
						print(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				}
				for (Constructor<?> ctor : ctors) {
					if (ctor.toString().indexOf(args[1]) != -1) {
						print(p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
				}
			}

		} catch (ClassNotFoundException e) {
			print("No such class: " + e);
		}

	}
}
// output:
/*
public Pet randomPet()
public Pet[] createArray(int)
public ArrayList arrayList(int)
public abstract List types()
public final void wait() throws InterruptedException
public final void wait(long,int) throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public native int hashCode()
public final native Class getClass()
public final native void notify()
public final native void notifyAll()
public PetCreator()
*/
