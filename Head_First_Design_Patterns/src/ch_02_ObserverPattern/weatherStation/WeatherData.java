package ch_02_ObserverPattern.weatherStation;

import java.util.ArrayList;
import java.util.Iterator;

// ConcreteSubject实现Subject
public class WeatherData implements Subject {
	
	private ArrayList<Observer> observers; // 定义一个ArrayList来记录观察者
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o); // 当注册观察者时，我们只要把它加到ArrayList后面即可。
	}


	@Override
	public void removeObserver(Observer o) { 
		// 当观察者想取消注册时，我们把它从ArrayList中删除
		Iterator<Observer> it = observers.iterator();
		while (it.hasNext()) {
			if (it.next().equals(o))
				it.remove();
		}
	}


	@Override
	public void notifyObservers() {
		// 把状态通知每一个观察者，由于观察者均实现了Observer接口，
		// 故调用其update方法即可
		for (Observer obs : observers) {
			obs.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementChanged() {
		// 当从气象站得到更新观测值时，通知观察者
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementChanged();
	}
	
	// other method ...

}
