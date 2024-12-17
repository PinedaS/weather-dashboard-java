package com.weatherdashboard.service;

import com.weatherdashboard.api.WeatherApiClient;
import com.weatherdashboard.model.forecast.ForecastResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ForecastService {
    WeatherApiClient weatherApiClient;

    public ForecastService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public List<String> getWarmDays(String city) {
        ForecastResponse forecastResponse = weatherApiClient.get3daysForecast(city);

        List<String> warmDays = forecastResponse.getForecast().getForecastDay().stream()
                .skip(1)
                .filter(day -> day.getDay().getMaxTempC() > 25)
                .map(forecastDay -> "Fecha: " + forecastDay.getDate() + "\n"
                        + "Temperatura máxima: " + forecastDay.getDay().getMaxTempC() + "°C" + "\n"
                        + "Temperatura mínima: " + forecastDay.getDay().getMinTempC() + "°C" + "\n")
                .collect(Collectors.toList());

        return warmDays;
    }

    public List<String> get2daysForecast(String city) {
        ForecastResponse forecastResponse = weatherApiClient.get3daysForecast(city);

        List<String> forecastList = forecastResponse.getForecast().getForecastDay().stream()
                .skip(1)
                .map(forecastDay -> "Fecha: " + forecastDay.getDate() + "\n"
                        + "Temperatura máxima: " + forecastDay.getDay().getMaxTempC() + "°C" + "\n"
                        + "Temperatura mínima: " + forecastDay.getDay().getMinTempC() + "°C" + "\n"
                        + "Condición climática: " + forecastDay.getDay().getCondition().getText())
                .collect(Collectors.toList());

        return forecastList;
    }
}
