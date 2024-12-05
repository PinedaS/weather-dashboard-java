package com.weatherdashboard.service;

import com.weatherdashboard.api.WeatherApiClient;
import com.weatherdashboard.model.weather.Condition;
import com.weatherdashboard.model.weather.Current;
import com.weatherdashboard.model.weather.Location;
import com.weatherdashboard.model.weather.WeatherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class WeatherServiceTest {
    @Mock
    WeatherApiClient weatherApiClient;

    @InjectMocks
    WeatherService weatherService;

    Location location1;
    Condition condition1;
    Current current1;
    WeatherResponse weatherResponse1;

    @BeforeEach
    void setUp() {
        // Given
        MockitoAnnotations.openMocks(this);

        location1 = new Location(
                "Dosquebradas",
                "Risaralda",
                "Colombia",
                "2024-11-27 23:21"
        );
        condition1 = new Condition("Patchy rain nearby");
        current1 = new Current(
                24.3,
                condition1,
                3.6,
                92,
                26.9
        );
        weatherResponse1 = new WeatherResponse(location1, current1);
    }

    @Test
    void getCurrentWeather_should_return_the_current_weather() {
        // Given
        when(weatherApiClient.getCurrentWeather(anyString())).thenReturn(weatherResponse1);

        // When
        Optional<WeatherResponse> result = weatherService.getCurrentWeather("Dosquebradas");

        // Then
        assertEquals(weatherResponse1, result.get());
    }

    @Test
    void getWeatherDataToBeCompared_should_return_weather_data_of_the_cities_to_be_compared() {
        // Given
        List<String> citiesList = List.of("Dosquebradas", "Pereira");

        Location location2 = new Location(
                "Pereira",
                "Risaralda",
                "Colombia",
                "2024-11-27 23:41"
        );
        Condition condition2 = new Condition("Light rain shower");
        Current current2 = new Current(
                13.3,
                condition2,
                4.3,
                97,
                13.7
        );
        WeatherResponse weatherResponse2 = new WeatherResponse(location2, current2);

        when(weatherApiClient.getCurrentWeather(citiesList.get(0))).thenReturn(weatherResponse1);
        when(weatherApiClient.getCurrentWeather(citiesList.get(1))).thenReturn(weatherResponse2);

        // When
        List<String> weatherDataToBeComparedList = weatherService.getWeatherDataToBeCompared(citiesList);

        // Then
        assertEquals(
                List.of(
                        "Dosquebradas: 24.3°C. Patchy rain nearby",
                        "Pereira: 13.3°C. Light rain shower"
                ),
                weatherDataToBeComparedList
        );
    }

    @Test
    void getCityWithHighestTemperature_should_return_the_city_with_highest_temperature() {
        // Given
        List<String> citiesList = List.of("Dosquebradas", "Pereira");

        Location location2 = new Location(
                "Pereira",
                "Risaralda",
                "Colombia",
                "2024-11-27 23:41"
        );
        Condition condition2 = new Condition("Light rain shower");
        Current current2 = new Current(
                13.3,
                condition2,
                4.3,
                97,
                13.7
        );
        WeatherResponse weatherResponse2 = new WeatherResponse(location2, current2);

        when(weatherApiClient.getCurrentWeather(citiesList.get(0))).thenReturn(weatherResponse1);
        when(weatherApiClient.getCurrentWeather(citiesList.get(1))).thenReturn(weatherResponse2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // When
        weatherService.getCityWithHighestTemperature(citiesList);

        // Then
        String expectedOutput = "La ciudad más cálida es: Dosquebradas con 24.3 °C";
        assertTrue(outContent.toString().contains(expectedOutput));
        verify(weatherApiClient, times(2)).getCurrentWeather(anyString());
    }
}