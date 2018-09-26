package ch_02_ObserverPattern.weatherStationObservable;

public class WeatherStation {

	public static void main(String[] args) {
		
		WeatherData wd = new WeatherData();
		
		new CurrentConditionsDisplay(wd);
		new ForecastDisplay(wd);
		
		wd.setMeasurements(50, 34.3f, 30.1f);

	}

}
