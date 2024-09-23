package com.weatherdashboard.api;

import com.google.gson.Gson;
import com.weatherdashboard.config.AppConfig;
import com.weatherdashboard.model.response.WeatherResponse;
import com.weatherdashboard.util.HttpUtils;

public class WeatherApiClient {
    public static WeatherResponse getCurrentWeather(String city) {
        final String URI_STRING = AppConfig.getBaseUrl() + "?key=" + AppConfig.getApiKey() + "&q=" + city;
        String apiResponse = HttpUtils.getCurrentWeather(URI_STRING);
        Gson gson = new Gson();
        WeatherResponse weatherResponse = gson.fromJson(apiResponse, WeatherResponse.class);

        return weatherResponse;
    }
}
