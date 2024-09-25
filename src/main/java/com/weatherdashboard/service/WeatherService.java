package com.weatherdashboard.service;

import com.weatherdashboard.api.WeatherApiClient;
import com.weatherdashboard.model.response.WeatherResponse;

import java.util.Optional;

public class WeatherService {
    public static Optional<WeatherResponse> getCurrentWeather(String city) {
        return Optional.ofNullable(WeatherApiClient.getCurrentWeather(city));
    }
}
