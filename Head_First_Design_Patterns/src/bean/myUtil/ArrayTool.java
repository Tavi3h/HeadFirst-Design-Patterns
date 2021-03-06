package bean.myUtil;
/**
 * 
 * @ClassName: ArrayTool
 * @Description: 对整型数组进行操作的工具类
 * @author: Tavish
 * @date: 2017年6月2日 下午6:11:32
 */

public class ArrayTool {
	private ArrayTool() {}

	public static int getMax(int[] arr) {
		int maxIndex = 0;
		for (int x = 1; x < arr.length; x++) {
			if (arr[x] > arr[maxIndex]) {
				maxIndex = x;
			}
		}
		return arr[maxIndex];
	}

	public static void selectSort(int[] arr) {
		for (int x = 0; x < arr.length - 1; x++) {
			for (int y = x + 1; y < arr.length; y++) {
				if (arr[x] > arr[y]) {
					swap(arr, x, y);
				}
			}
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int getIndex(int[] arr, int key) {
		for (int x = 0; x < arr.length; x++) {
			if (arr[x] == key) {
				return x;
			}
		}
		return -1;
	}

	public static String intArrToStr(int[] arr) {
		String str = "[";
		for (int x = 0; x < arr.length; x++) {
			if (x != arr.length - 1) {
				str = str + arr[x] + ", ";
			} else
				str = str + arr[x] + "]";
		}
		return str;
	}

	public static String objArrToStr(Object[] obj) {
		String str = "[";
		for (int x = 0; x < obj.length; x++) {
			if (x != obj.length - 1) {
				str = str + obj[x] + ", ";
			} else
				str = str + obj[x] + "]";
		}
		return str;
	}

}
