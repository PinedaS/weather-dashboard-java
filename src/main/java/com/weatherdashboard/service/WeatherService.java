package com.weatherdashboard.service;

import com.weatherdashboard.api.WeatherApiClient;
import com.weatherdashboard.model.forecast.ForecastResponse;
import com.weatherdashboard.model.weather.WeatherResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeatherService {
    public static Optional<WeatherResponse> getCurrentWeather(String city) {
        return Optional.ofNullable(WeatherApiClient.getCurrentWeather(city));
    }

    public static List<String> getWarmDays(String city) {
        ForecastResponse forecastResponse = WeatherApiClient.get3daysForecast(city);

        List<String> warmDays = forecastResponse.getForecast().getForecastDay().stream()
                .skip(1)
                .filter(day -> day.getDay().getMaxTempC() > 25)
                .map(forecastDay -> "Fecha: " + forecastDay.getDate() + "\n"
                        + "Temperatura máxima: " + forecastDay.getDay().getMaxTempC() + "°C" + "\n"
                + "Temperatura mínima: " + forecastDay.getDay().getMinTempC() + "°C" + "\n")
                .collect(Collectors.toList());

        return warmDays;
    }

    public static List<String> get3daysForecast(String city) {
        ForecastResponse forecastResponse = WeatherApiClient.get3daysForecast(city);

        List<String> forecastList = forecastResponse.getForecast().getForecastDay().stream()
                .skip(1)
                .map(forecastDay -> "Fecha: " + forecastDay.getDate() + "\n"
                        + "Temperatura máxima: " + forecastDay.getDay().getMaxTempC() + "°C" + "\n"
                        + "Temperatura mínima: " + forecastDay.getDay().getMinTempC() + "°C" + "\n"
                + "Condición climática: " + forecastDay.getDay().getCondition().getText())
                .collect(Collectors.toList());

        return forecastList;
    }

    public static List<String> getWeatherDataToBeCompared(List<String> citiesList) {
        List<WeatherResponse> weatherResponseList = new ArrayList<>();
        List<String> weatherDataToBeComparedList;

        citiesList.forEach(city -> {
            weatherResponseList.add(WeatherApiClient.getCurrentWeather(city));
        });

        weatherDataToBeComparedList = weatherResponseList.stream()
                .map(weatherResponse ->
                        weatherResponse.getLocation().getName() + ": "
                                + weatherResponse.getCurrent().getTempC() + "°C. "
                                + weatherResponse.getCurrent().getCondition().getText())
                .collect(Collectors.toList());

        return weatherDataToBeComparedList;
    }

    public static void getCityWithHighestTemperature(List<String> citiesList) {
        List<WeatherResponse> weatherResponseList = new ArrayList<>();
        Optional<WeatherResponse> hottestCity = Optional.of(new WeatherResponse());

        citiesList.forEach(city -> {
            weatherResponseList.add(WeatherApiClient.getCurrentWeather(city));
        });

       hottestCity = weatherResponseList.stream()
               .reduce((c1, c2) -> c1.getCurrent().getTempC() > c2.getCurrent().getTempC() ? c1 : c2);

       hottestCity.ifPresent(
               city -> System.out.println("La ciudad más cálida es: " + city.getLocation().getName() + " con " + city.getCurrent().getTempC() + " °C")
       );
    }
}
