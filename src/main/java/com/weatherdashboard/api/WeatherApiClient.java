package com.weatherdashboard.api;

import com.weatherdashboard.config.AppConfig;

public class WeatherApiClient {
    public void getCurrentWeather(String city) {
        final String URI_STRING = AppConfig.getBaseUrl() + "?key=" + AppConfig.getApiKey() + "&q=" + city;
    }
}
