package com.weatherdashboard.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private static Properties properties = new Properties();

    public AppConfig() throws FileNotFoundException, IOException {
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getApiKey() {
        return properties.getProperty("weatherapi.key");
    }

    public static String getBaseUrl() {
        return properties.getProperty("weatherapi.baseurl");
    }
}
