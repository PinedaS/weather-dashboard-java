package com.weatherdashboard.service;

import com.weatherdashboard.api.WeatherApiClient;
import com.weatherdashboard.model.weather.WeatherResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeatherService {
    private WeatherApiClient weatherApiClient;

    public WeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public Optional<WeatherResponse> getCurrentWeather(String city) {
        return Optional.ofNullable(weatherApiClient.getCurrentWeather(city));
    }

    public List<String> getWeatherDataToBeCompared(List<String> citiesList) {
        List<WeatherResponse> weatherResponseList = new ArrayList<>();
        List<String> weatherDataToBeComparedList;

        citiesList.forEach(city -> {
            weatherResponseList.add(weatherApiClient.getCurrentWeather(city));
        });

        weatherDataToBeComparedList = weatherResponseList.stream()
                .map(weatherResponse ->
                        weatherResponse.getLocation().getName() + ": "
                                + weatherResponse.getCurrent().getTempC() + "°C. "
                                + weatherResponse.getCurrent().getCondition().getText())
                .collect(Collectors.toList());

        return weatherDataToBeComparedList;
    }

    public void getCityWithHighestTemperature(List<String> citiesList) {
        List<WeatherResponse> weatherResponseList = new ArrayList<>();
        Optional<WeatherResponse> hottestCity = Optional.of(new WeatherResponse());

        citiesList.forEach(city -> {
            weatherResponseList.add(weatherApiClient.getCurrentWeather(city));
        });

       hottestCity = weatherResponseList.stream()
               .reduce((c1, c2) -> c1.getCurrent().getTempC() > c2.getCurrent().getTempC() ? c1 : c2);

       hottestCity.ifPresent(
               city -> System.out.println("La ciudad más cálida es: " + city.getLocation().getName() + " con " + city.getCurrent().getTempC() + " °C")
       );
    }
}
