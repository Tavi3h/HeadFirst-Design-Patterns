package ch_03_DecoratorPattern.starbuzz.decorator;

import ch_03_DecoratorPattern.starbuzz.component.Beverage;

// 调料抽象类。必须让CondimentDecorator能取代Beverage，所以令其继承Beverage

public abstract class CondimentDecorator extends Beverage {
	
	public abstract String getDescription(); // 所有的调料装饰者必须重新实现该方法

}
