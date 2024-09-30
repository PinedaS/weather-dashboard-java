package com.weatherdashboard.util;

import com.weatherdashboard.config.AppConfig;

public class ApiEndpoints {
    private static final String BASE_URL = AppConfig.getBaseUrl();
    private static final String API_KEY = AppConfig.getApiKey();

    public static String getCurrentWeatherUrl(String cityName) {
        return BASE_URL + "current.json?key=" + API_KEY + "&q=" + cityName;
    }

    public static String get3daysForecastUrl(String cityName) {
        return BASE_URL + "forecast.json?key=" + API_KEY + "&q=" + cityName + "&days=3";
    }
}
