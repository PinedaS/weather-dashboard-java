package com.weatherdashboard.service;

import com.weatherdashboard.api.WeatherApiClient;
import com.weatherdashboard.model.forecast.Day;
import com.weatherdashboard.model.forecast.Forecast;
import com.weatherdashboard.model.forecast.ForecastDay;
import com.weatherdashboard.model.forecast.ForecastResponse;
import com.weatherdashboard.model.weather.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ForecastServiceTest {
    @InjectMocks
    ForecastService forecastService;

    @Mock
    WeatherApiClient weatherApiClient;

    Condition condition1;
    Day day1;
    ForecastDay forecastDay1;

    Condition condition2;
    Day day2;
    ForecastDay forecastDay2;

    @BeforeEach
    void setUp() {
        // Given
        MockitoAnnotations.openMocks(this);

        condition1 = new Condition("Moderate rain");
        day1 = new Day(13.8, 25.0, condition1);
        forecastDay1 = new ForecastDay(day1, "2024-11-27");

        condition2 = new Condition("Moderate rain");
        day2 = new Day(13.2, 25.1, condition2);
        forecastDay2 = new ForecastDay(day2, "2024-11-28");
    }

    @Test
    void getWarmDays_should_return_the_warm_days() {
        // Given
        List<String> mockResponse = List.of(
                "Fecha: 2024-11-28\n" +
                        "Temperatura máxima: 25.1°C\n" +
                        "Temperatura mínima: 13.2°C\n"
        );

        List<ForecastDay> forecastDays = List.of(forecastDay1, forecastDay2);
        Forecast forecast = new Forecast(forecastDays);
        ForecastResponse forecastResponse = new ForecastResponse(forecast);
        when(weatherApiClient.get3daysForecast(anyString())).thenReturn(forecastResponse);

        // When
        List<String> warmDays = forecastService.getWarmDays("Pereira");

        // Then
        assertEquals(mockResponse, warmDays);
    }

    @Test
    void get2daysForecast_should_return_the_2_days_forecast() {
        // Given
        Condition condition3 = new Condition("Moderate rain");
        Day day3 = new Day(13.3, 25.2, condition3);
        ForecastDay forecastDay3 = new ForecastDay(day3, "2024-11-29");

        List<String> mockResponse = List.of(
                "Fecha: 2024-11-28\n" +
                        "Temperatura máxima: 25.1°C\n" +
                        "Temperatura mínima: 13.2°C\n" +
                        "Condición climática: Moderate rain",
                "Fecha: 2024-11-29\n" +
                        "Temperatura máxima: 25.2°C\n" +
                        "Temperatura mínima: 13.3°C\n" +
                        "Condición climática: Moderate rain"
        );

        List<ForecastDay> forecastDays = List.of(forecastDay1, forecastDay2, forecastDay3);
        Forecast forecast = new Forecast(forecastDays);
        ForecastResponse forecastResponse = new ForecastResponse(forecast);
        when(weatherApiClient.get3daysForecast(anyString())).thenReturn(forecastResponse);

        // When
        List<String> forecastList = forecastService.get2daysForecast("Pereira");

        // Then
        assertEquals(mockResponse, forecastList);
    }
}
