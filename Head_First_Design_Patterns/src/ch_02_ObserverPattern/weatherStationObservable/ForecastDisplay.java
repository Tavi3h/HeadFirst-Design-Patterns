package ch_02_ObserverPattern.weatherStationObservable;

import java.util.Observable;
import java.util.Observer;

import ch_02_ObserverPattern.weatherStation.DisplayElement;

public class ForecastDisplay implements Observer, DisplayElement {
	
	private Observable observable;
	private float currentPressure = 29.92f;
	private float lastPressure;
	
	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		this.observable.addObserver(this);
	}

	@Override
	public void update(Observable obs, Object arg) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) obs;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
		}
	}

	@Override
	public void display() {
		System.out.println("Forecast: pressure goes " + ( currentPressure - lastPressure > 0 ? "high" : "low" ));
	}
	
}
