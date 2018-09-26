package bean.myUtil;

// 用于所有基本类型的包装器类型以及String类型的最基本的计数生成器集合

public class CountingGenerator {

	// boolean
	public static class Boolean implements Generator<java.lang.Boolean> {
		private boolean value = false;

		@Override
		public java.lang.Boolean next() {
			value = !value;
			return value;
		}

	}

	// byte
	public static class Byte implements Generator<java.lang.Byte> {
		private byte value = 0;

		@Override
		public java.lang.Byte next() {
			return value++;
		}
	}

	// char
	static char[] chars = (("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray());

	public static class Character implements Generator<java.lang.Character> {
		int index = -1;

		@Override
		public java.lang.Character next() {
			index = (index + 1) % chars.length;
			
			return chars[index];
		}
	}

	// String
	public static class String implements Generator<java.lang.String> {

		private int length = 7;
		Generator<java.lang.Character> cg = new Character();

		public String() {

		}

		public String(int length) {
			this.length = length;
		}

		@Override
		public java.lang.String next() {
			char[] buf = new char[length];
			for (int i = 0; i < length; i++) {
				buf[i] = cg.next();
			}
			return new java.lang.String(buf);
		}

	}

	// short
	public static class Short implements Generator<java.lang.Short> {
		private short value = 0;

		@Override
		public java.lang.Short next() {
			return value++;
		}
	}

	// int
	public static class Integer implements Generator<java.lang.Integer> {
		private int value = 0;

		@Override
		public java.lang.Integer next() {
			return value++;
		}
	}

	// long
	public static class Long implements Generator<java.lang.Long> {
		private long value = 0;

		@Override
		public java.lang.Long next() {
			return value++;
		}
	}

	// long
	public static class Float implements Generator<java.lang.Float> {
		private float value = 0f;

		@Override
		public java.lang.Float next() {
			float result = value;
			value += 1.0;
			return result;
		}
	}

	// double
	public static class Double implements Generator<java.lang.Double> {
		private double value = 0.0;

		@Override
		public java.lang.Double next() {
			double result = value;
			value += 1.0;
			return result;
		}
	}

}