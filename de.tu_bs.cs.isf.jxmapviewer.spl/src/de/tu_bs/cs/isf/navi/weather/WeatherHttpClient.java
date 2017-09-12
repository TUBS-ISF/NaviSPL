package de.tu_bs.cs.isf.navi.weather;



import org.json.JSONException;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import net.aksingh.owmjapis.OpenWeatherMap.Units;

public class WeatherHttpClient {
	
		 
		/*
		 * 
		 */
		public void getWeather(float latitude, float longitude) {
			OpenWeatherMap openWeatherMap = new OpenWeatherMap(Units.METRIC, "e6d53f6128339f0b361aa69105feecea");
			try {
				
				CurrentWeather currentWeather = openWeatherMap.currentWeatherByCoordinates(latitude, longitude);
						
				System.out.println(currentWeather.getRainInstance().getRain1h());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	
	    

	

}
