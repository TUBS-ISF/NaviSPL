package net.aksingh.owmjapis;

import java.io.IOException;

import org.json.JSONException;

import net.aksingh.owmjapis.OpenWeatherMap.Units;

public class WeatherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpenWeatherMap openWeatherMap = new OpenWeatherMap(Units.METRIC, "e6d53f6128339f0b361aa69105feecea");
			CurrentWeather currentWeather;
			try {
				currentWeather = openWeatherMap.currentWeatherByCityName("Brasilien");
				
				float weatherData[];
				float temperature = currentWeather.getMainInstance().getTemperature();
				
				System.out.println("Temperatur: "+temperature);
				
				System.out.println(currentWeather.getWeatherInstance(0).getWeatherName());
				
				

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}

}
