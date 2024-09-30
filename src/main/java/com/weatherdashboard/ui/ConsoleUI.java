package com.weatherdashboard.ui;

import com.weatherdashboard.model.weather.WeatherResponse;
import com.weatherdashboard.service.WeatherService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleUI {
    static int option;
    static String cityName;
    static String isWarm;

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
                break;

            case 2:
                System.out.println("Ciudad: ");
                cityName = scanner.nextLine();
                System.out.println("----------------------------");
                System.out.println("¿Quieres ver solo los días cálidos? (S/N)");
                isWarm = scanner.nextLine();
                System.out.println("----------------------------");

                if (isWarm.equals("S")) {
                    List<String> warmDays = WeatherService.getWarmDays(cityName);
                    warmDays.forEach(System.out::println);
                }

                if (isWarm.equals("N")) {
                    List<String> forecastList = WeatherService.get3daysForecast(cityName);
                    forecastList.forEach(f -> System.out.println(f  + "\n"));
                }
                break;
        }
    }

    public static void printMenu() {
        Scanner scanner = new Scanner (System.in);

        System.out.println("------Weather Dashboard------");
        System.out.println("1. Consultar el clima actual de una ciudad");
        System.out.println("2. Consultar el pronóstico del clima a 2 días");
        System.out.println("3. Comparar el clima de varias ciudades");
        System.out.println("4. Almacenar y gestionar ciudades favoritas");
        option = scanner.nextInt();
        System.out.println("----------------------------");
    }
}
