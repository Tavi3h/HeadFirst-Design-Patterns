package ch_07_AdapterPattern.duckAndTurkey;
// 假设缺少鸭子对象，想用火鸡对象来冒充。
// 显而易见，因为接口不同，所以我们需要使用适配器进行适配。

// 首先需实现想转换成的类型接口，也就是客户所期望看到的接口
public class TurkeyAdapter implements Duck {

	private Turkey turkey;
	
	// 取得要适配对象的引用，这里使用构造器来取得引用。
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	// 覆盖接口中的方法
	
	@Override
	public void quack() {
		turkey.gobble();		
	}


	@Override
	public void fly() {
		// 由于火鸡飞行距离很短，所有循环调用5次来模拟鸭子飞行
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}
	
	

}
