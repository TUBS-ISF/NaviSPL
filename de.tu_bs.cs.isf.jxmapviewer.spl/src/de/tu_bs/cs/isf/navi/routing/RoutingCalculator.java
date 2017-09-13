package de.tu_bs.cs.isf.navi.routing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RoutingCalculator {

	private String coordinates = new String();
	private String apiUrl = "https://api.openrouteservice.org/directions?";
	private String api_keyUrl = "api_key=58d904a497c67e00015b45fc36a9e9b71dbc4ca655f5f2375eebfb67";
	private String profileUrl = "profile=driving-car";
	private RoutingInformation route;
	
	/**
	 * Constructor
	 * @param latitudeStart
	 * @param longitudeStart
	 * @param latitudeEnd
	 * @param longitudeEnd
	 */
	public RoutingCalculator(long latitudeStart, long longitudeStart, long latitudeEnd, long longitudeEnd) {
		addCoordinates(latitudeStart, longitudeStart);
		addCoordinates(latitudeEnd, latitudeEnd);
	}
	
	public RoutingCalculator(String latitudeStart, String longitudeStart, String latitudeEnd, String longitudeEnd) {
		try {
			addCoordinates(Double.parseDouble(latitudeStart), Double.parseDouble(longitudeStart));
			addCoordinates(Double.parseDouble(latitudeEnd), Double.parseDouble(latitudeEnd));
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	private void addCoordinates(double longitude, double latitude) {
		if (coordinates.length() == 0)
			coordinates += "coordinates=" + String.valueOf(longitude) + "," + String.valueOf(latitude);
		else
			coordinates += "|" + String.valueOf(longitude) + "," + String.valueOf(latitude);
	}

	public RoutingInformation calculateRoute() {
		try {
			route = new RoutingInformation();

			URL url = new URL(apiUrl + api_keyUrl + "&" + profileUrl + "&" + coordinates);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
//				return null;
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				
				
				
				
				JSONParser p = new JSONParser();

				try {
					JSONObject parsed = (JSONObject) p.parse(output);

					JSONArray routesArray = (JSONArray) parsed.get("routes");
					JSONObject routes = (JSONObject) routesArray.get(0);

					JSONArray segementsArray = (JSONArray) routes.get("segments");
					JSONObject segments = (JSONObject) segementsArray.get(0);

					JSONArray stepsArray = (JSONArray) segments.get("steps");

					for (Object step : stepsArray) {
						JSONObject JSONstep = (JSONObject) step;

						Number duration = (Number) JSONstep.get("duration");
						Number distance = (Number) JSONstep.get("distance");
						String instruction = (String) JSONstep.get("instruction");
						String name = (String) JSONstep.get("name");
						Number type = (Number) JSONstep.get("type");

						JSONArray wayPointArray = (JSONArray) JSONstep.get("way_points");
						Number wayPointX = (Number) wayPointArray.get(0);
						Number wayPointY = (Number) wayPointArray.get(1);

						RoutingStepInformation newInformation = new RoutingStepInformation(duration, distance,
								instruction, name, type, wayPointX, wayPointY);
						route.addStep(newInformation);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (ClassCastException e) {
					e.printStackTrace();
				} catch (NullPointerException e) {
					e.printStackTrace();
				}
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return route;
	}
}
