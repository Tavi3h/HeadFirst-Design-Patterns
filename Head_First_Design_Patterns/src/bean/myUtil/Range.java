
/*
 * Array creation methods that can be used without qualifiers , using java SE5static imports:
 */
package bean.myUtil;
/**
 * 
 * @ClassName: Range
 * @Description: 产生一个整型序列的工具类
 * @author: Tavish
 * @date: 2017年6月1日 下午7:29:20
 */
public class Range {
	
	private Range() {}
	
	/**
	 * @Title: range
	 * @Description: Produce a sequence [0..n)
	 * @param int n
	 * @return
	 * @return: int[]
	 */	
	public static int[] range(int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = i;
		}
		return result;
	}
	
	/**
	 * @Title: range
	 * @Description: Produce a sequence [start..end)
	 * @param int start
	 * @param int end
	 * @return
	 * @return: int[]
	 */
	
	public static int[] range(int start, int end) {
		int sz = end - start;
		int[] result = new int[sz];
		for (int i = 0; i < sz; i++) {
			result[i] = start + i;
		}
		return result;
	}
	
	/**
	 * @Title: range
	 * @Description: Produce a sequence [start..end) incrementing by step
	 * @param int start
	 * @param int end
	 * @param int step
	 * @return
	 * @return: int[]
	 */
	
	public static int[] range(int start, int end, int step) {
		int sz = (end - start) / step;
		int[] result = new int[sz];
		for (int i = 0; i < sz; i++) {
			result[i] = start + (i * step);
		}
		return result;
	}

}
