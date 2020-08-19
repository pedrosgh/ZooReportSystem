package service;

import models.Weather;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Path("/weather")
@Produces(MediaType.APPLICATION_XML)
public class WeatherServiceImplementation implements WeatherService {
    private final String API_KEY = "a8b781e23a91ec8e817a5f0be95f4974";

    @Override
    @GET
    @Path("/d={dayCountingFromToday}&lat={lat}&lon={lon}")
    public Weather getWeather(
            @PathParam("dayCountingFromToday") int dayCountingFromToday, @PathParam("lat") double lat, @PathParam("lon") double lon
    ) {
        return callOpenWeatherMapAPI(dayCountingFromToday, lat, lon);
    }//getWeather

    //http://localhost:2020/WeatherService-1.0-SNAPSHOT/weather/get/2&38.71667&-9.13333
    private Weather callOpenWeatherMapAPI(int dayCountingFromToday, double lat, double lon) {
        Weather weather = null;
        try {
            String urlComp = "https://api.openweathermap.org/data/2.5/onecall?" +
                    "lat=" + lat +
                    "&lon=" + lon +
                    "&exclude=current,minutely,hourly" +
                    "&units=metric" +
                    "&appid=" + API_KEY;

            URL url = new URL(urlComp);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + con.getResponseCode());
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            weather = convertJSONtoWeatherInstance(dayCountingFromToday, lat, lon, content.toString());

            con.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
        return weather;
    }//callOpenWeatherMapAPI

    private Weather convertJSONtoWeatherInstance(int dayCountingFromToday, double lat, double lon, String json) {
        JSONObject obj = new JSONObject(json);
        JSONArray array = obj.getJSONArray("daily");
        JSONObject dayObj = array.getJSONObject(dayCountingFromToday);
        JSONArray array2 = dayObj.getJSONArray("weather");
        JSONObject rainObj = array2.getJSONObject(0);

        Weather weather = new Weather();
        weather.setLat(lat); weather.setLon(lon);
        weather.setMinTemp((int) Math.round(dayObj.getJSONObject("temp").getDouble("min")));
        weather.setMaxTemp((int) Math.round(dayObj.getJSONObject("temp").getDouble("max")));
        weather.setAvTemp((int) Math.round((weather.getMaxTemp() + weather.getMinTemp())/2));
        if( rainObj.getString("main").equals("Rain") ) weather.setRain(true);

        return weather;
    }//convertJSONtoWeatherInstance

    //API CALL
    //https://api.openweathermap.org/data/2.5/onecall?lat=38.71667&lon=-9.13333&exclude=current,minutely,hourly&units=metric&appid=a8b781e23a91ec8e817a5f0be95f4974
}
