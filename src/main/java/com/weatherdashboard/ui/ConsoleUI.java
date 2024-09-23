package com.weatherdashboard.ui;

import com.weatherdashboard.model.response.WeatherResponse;
import com.weatherdashboard.service.WeatherService;

import java.util.Scanner;

public class ConsoleUI {
    static int option;
    static String cityName;

    public static void run() {
        Scanner scanner = new Scanner (System.in);

        printMenu();

        switch (option) {
            case 1:
                System.out.println("Ciudad: ");
                cityName = scanner.nextLine();
                System.out.println("----------------------------");
                WeatherResponse weatherResponse = WeatherService.getCurrentWeather(cityName);
                double tempC = weatherResponse.getCurrent().getTempC();
                double feelsLikeC = weatherResponse.getCurrent().getFeelslikeC();
                String windChill = weatherResponse.getCurrent().getCondition().getText();
                int humidity = weatherResponse.getCurrent().getHumidity();
                double windKph = weatherResponse.getCurrent().getWindKph();
                String country = weatherResponse.getLocation().getCountry();
                String dateTime = weatherResponse.getLocation().getLocaltime();

                System.out.println("Ciudad: " + cityName);
                System.out.println("País: " + country);
                System.out.println("Fecha: " + dateTime);
                System.out.println("--------------");
                System.out.println("Temperatura en C: " + tempC);
                System.out.println("Sensación térmica en C: "+ feelsLikeC);
                System.out.println("Condición metereológica: " + windChill);
                System.out.println("Humedad: " + humidity + "%");
                System.out.println("Velocidad del viento: " + windKph + " kph");
        }
    }

    public static void printMenu() {
        Scanner scanner = new Scanner (System.in);

        System.out.println("------Weather Dashboard------");
        System.out.println("1. Consultar el clima actual de una ciudad");
        System.out.println("2. Consultar el pronóstico del clima a 5 días");
        System.out.println("3. Ver el clima por hora para un día específico");
        System.out.println("4. Ver la calidad del aire");
        System.out.println("5. Almacenar ciudades favoritas");
        System.out.println("6. Comparar el clima de varias ciudades");
        option = scanner.nextInt();
        System.out.println("----------------------------");
    }
}
