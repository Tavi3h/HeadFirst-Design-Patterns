package ch_02_ObserverPattern.weatherStation;

// 目前状况布告板，观察者之一，实现Observer接口。
public class CurrentConditionDisplay implements Observer, DisplayElement {
	
	private float temperature;
	private float humidity;	
	@SuppressWarnings("unused")
	private Subject weatherData;
	
	public CurrentConditionDisplay(Subject weatherData) {
		// 构造器需要weatherData对象作为注册之用。
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}	
	
	@Override
	public void update(float temperature, float humidity, float pressure) {
		// 更新数据，并显示出来
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	@Override
	public void display() {
		System.out.println("Current Conditions: " + temperature + "F degrees and " + humidity + " % humidity");
	}

}
