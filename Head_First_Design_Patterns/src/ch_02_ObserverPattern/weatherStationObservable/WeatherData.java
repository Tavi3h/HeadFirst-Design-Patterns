package ch_02_ObserverPattern.weatherStationObservable;
import java.util.Observable;

// 继承Observable后，就不再需要追踪观察者了，也不需要管理注册与删除，因为超类会代劳这部分。

public class WeatherData extends Observable {
	
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		// 构造器不需要为了记住观察者而建立数据结构了
	}
	
	public void measurementsChanged() {
		setChanged(); // 调用notifyObservers前需要先调用setChanged
		notifyObservers(); // 唤醒所有的Observer，调用其update方法
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	public float getTemperature() {
		return temperature;
	}
	
	public float getHumidity() {
		return humidity;
	}
	
	public float getPressure() {
		return pressure;
	}

}
