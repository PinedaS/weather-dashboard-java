package com.weatherdashboard.ui;

import java.util.Scanner;

public class ConsoleUI {
    public static void run() {
        Scanner scanner = new Scanner (System.in);
        int option;

        System.out.println("------Weather Dashboard------");
        System.out.println("1. Consultar el clima actual de una ciudad");
        System.out.println("2. Consultar el pronóstico del clima a 5 días");
        System.out.println("3. Ver el clima por hora para un día específico");
        System.out.println("4. Ver la calidad del aire");
        System.out.println("5. Almacenar ciudades favoritas");
        System.out.println("6. Comparar el clima de varias ciudades");
        option = scanner.nextInt();
    }
}
