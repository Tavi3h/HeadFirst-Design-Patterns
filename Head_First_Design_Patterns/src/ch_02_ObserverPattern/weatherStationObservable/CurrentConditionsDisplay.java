package ch_02_ObserverPattern.weatherStationObservable;

import java.util.Observable;
import java.util.Observer;

import ch_02_ObserverPattern.weatherStation.DisplayElement;
// 实现Observer接口，成为观察者
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	
	private Observable observable;
	private float temperature;
	private float humidity;
	

	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		this.observable.addObserver(this); // 注册成为observable的观察者
	}
	
	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("Current Conditions: " + temperature + "F degrees and " + humidity + " % humidity");
	}

}
