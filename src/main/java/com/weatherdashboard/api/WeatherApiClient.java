package com.weatherdashboard.api;

import com.google.gson.Gson;
import com.weatherdashboard.model.forecast.ForecastResponse;
import com.weatherdashboard.model.weather.WeatherResponse;
import com.weatherdashboard.util.ApiEndpoints;
import com.weatherdashboard.util.HttpUtils;

public class WeatherApiClient {
    public WeatherResponse getCurrentWeather(String city) {
        final String URI_STRING = ApiEndpoints.getCurrentWeatherUrl(city);
        String apiResponse = HttpUtils.requestToWeatherApi(URI_STRING);
        Gson gson = new Gson();
        WeatherResponse weatherResponse = gson.fromJson(apiResponse, WeatherResponse.class);

        return weatherResponse;
    }

    public ForecastResponse get3daysForecast(String city) {
        final String URI_STRING = ApiEndpoints.get3daysForecastUrl(city);
        String apiResponse = HttpUtils.requestToWeatherApi(URI_STRING);
        Gson gson = new Gson();
        ForecastResponse forecastResponse = gson.fromJson(apiResponse, ForecastResponse.class);

        return forecastResponse;
    }
}
