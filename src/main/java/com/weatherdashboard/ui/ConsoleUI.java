package com.weatherdashboard.ui;

import com.weatherdashboard.model.response.WeatherResponse;
import com.weatherdashboard.service.WeatherService;

import java.util.Optional;
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
                Optional<WeatherResponse> weatherResponse = WeatherService.getCurrentWeather(cityName);

                weatherResponse.ifPresentOrElse(
                        wr -> {
                            String tempC = Optional.ofNullable(Double.toString(wr.getCurrent().getTempC()))
                                    .map(temp -> temp + "°C")
                                    .orElse("No disponible");
                            String feelsLikeC = Optional.ofNullable(Double.toString(wr.getCurrent().getFeelslikeC()))
                                    .map(feelsLike -> feelsLike + "°C")
                                    .orElse("No disponible");
                            String windChill = Optional.ofNullable(wr.getCurrent().getCondition().getText())
                                    .orElse("No disponible");
                            String humidity = Optional.ofNullable(Integer.toString(wr.getCurrent().getHumidity()))
                                    .map(h -> h + "%")
                                    .orElse("No disponible");
                            String windKph = Optional.ofNullable(Double.toString(wr.getCurrent().getWindKph()))
                                    .map(w -> w + "km/h")
                                    .orElse("No disponible");
                            String country = wr.getLocation().getCountry();
                            String dateTime = wr.getLocation().getLocaltime();

                            System.out.println("Ciudad: " + cityName);
                            System.out.println("País: " + country);
                            System.out.println("Fecha: " + dateTime);
                            System.out.println("--------------");
                            System.out.println("Temperatura " + tempC);
                            System.out.println("Sensación térmica: "+ feelsLikeC);
                            System.out.println("Condición metereológica: " + windChill);
                            System.out.println("Humedad: " + humidity);
                            System.out.println("Velocidad del viento: " + windKph);
                        }
                , () -> System.out.println("No hay información disponible sobre esta ciudad."));
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
