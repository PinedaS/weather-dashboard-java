package com.weatherdashboard.service;

import com.weatherdashboard.api.WeatherApiClient;
import com.weatherdashboard.model.response.WeatherResponse;

public class WeatherService {
    public static WeatherResponse getCurrentWeather(String city) {
        return WeatherApiClient.getCurrentWeather(city);
    }
}
