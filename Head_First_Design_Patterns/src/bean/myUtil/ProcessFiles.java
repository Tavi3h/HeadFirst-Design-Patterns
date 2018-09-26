package bean.myUtil;
import java.io.File;
import java.io.IOException;

// 使用策略模式对File对象进行针对性处理
// 该类

public class ProcessFiles {
	
	// 创建内部接口
	public interface Strategy {
		void process(File file);
	}
	
	// 创建内部接口的引用
	private Strategy strategy;
	// 创建扩展名引用
	private String ext;
	
	// 接收一个Strategy实例和指定的扩展名对ProcessFiles对象初始化
	public ProcessFiles(Strategy strategy, String ext) {
		this.strategy = strategy;
		this.ext = ext;
	}
	
	// 定义功能函数
	public void start(String[] args) {
		try {
			// 如果参数列表长度为0，则目录指定为当前工程目录
			if (args.length == 0)
				processDirectoryTree(new File("."));
			// 如果参数列表长度不为0
			else
				// 对参数列表进行遍历
				for (String arg : args) {
					// 将参数列表中的参数作为File对象的参数进行初始化
					File fileArg = new File(arg);
					// 如果这个File对象是一个目录
					if (fileArg.isDirectory())
						// 调用processDirectoryTree
						processDirectoryTree(fileArg);
					// 如果这个File对象不是目录
					else {
						// 如果这个参数不是以.ext结尾
						if (!arg.endsWith("." + ext))
							// 则对参数增加指定的扩展名
							arg += "." + ext;
						// 调用process对这个File对象的绝对规范路径名字符串进行处理
						strategy.process(new File(arg).getCanonicalFile());
						
					}
				}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	// 定义processDirectoryTree方法对目录File对象进行处理， （root是一个目录File对象）
	private void processDirectoryTree(File root) throws IOException {
		// 遍历出该root目录下所有扩展名为.ext的文件
		for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			// 对这些扩展名为.ext的文件进行处理
			strategy.process(file.getCanonicalFile());
		}
	}

	// Demonstration of how to use it:
	public static void main(String[] args) {
		
		// 创建ProcessFiles对象，并使用匿名内部类来定义Strategy的实现
		new ProcessFiles(new ProcessFiles.Strategy() {
			
			// 定义处理策略
			@Override
			public void process(File file) {
				// 处理策略为打印这些File对象
				System.out.println(file);
			}
		}, "txt").start(args);
	}
}
// output:
/*
G:\Programming\myCode\Eclipse_Work\ThinkingInJava\src\ch18_IOSystem\TestFileFolder\New Folder\TestFile_5.txt
G:\Programming\myCode\Eclipse_Work\ThinkingInJava\src\ch18_IOSystem\TestFileFolder\New Folder2\TestFile_7.txt
G:\Programming\myCode\Eclipse_Work\ThinkingInJava\src\ch18_IOSystem\TestFileFolder\New Folder2\TestFile_8.txt
G:\Programming\myCode\Eclipse_Work\ThinkingInJava\src\ch18_IOSystem\TestFileFolder\New Folder2\新建文件夹\TestFile_8.txt
G:\Programming\myCode\Eclipse_Work\ThinkingInJava\src\ch18_IOSystem\TestFileFolder\TestFile_5.txt
G:\Programming\myCode\Eclipse_Work\ThinkingInJava\src\ch18_IOSystem\TestFileFolder\TestFile_6.txt
G:\Programming\myCode\Eclipse_Work\ThinkingInJava\src\ch18_IOSystem\TestFileFolder\TestFile_7.txt
G:\Programming\myCode\Eclipse_Work\ThinkingInJava\src\ch18_IOSystem\TestFileFolder\TestFile_8.txt
*/
