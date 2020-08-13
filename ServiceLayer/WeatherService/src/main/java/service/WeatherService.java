package service;

import models.Weather;

public interface WeatherService {
    public Weather getWeather(int dayCountingFromToday, double lat, double lon);

    /*
    TODO: Write notes about the input variables
     */
}
