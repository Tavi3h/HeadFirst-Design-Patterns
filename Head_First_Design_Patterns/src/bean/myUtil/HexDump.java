package bean.myUtil;

// 以十六进制的格式查看二进制文件。以可读的十六进制格式将字节数组打印出来

public class HexDump {
	public static String format(byte[] data) {
		StringBuilder result = new StringBuilder();
		int n = 0;
		for (byte b : data) {
			if (n % 16 == 0)
				result.append(String.format("%05x: ", n));
			result.append(String.format("%02x ", b));
			n++;
			if (n % 16 == 0)
				result.append("\n");
		}
		result.append("\n");
		return result.toString();
	}

}
