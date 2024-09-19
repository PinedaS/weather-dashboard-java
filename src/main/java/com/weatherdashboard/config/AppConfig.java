package com.weatherdashboard.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static Properties properties = new Properties();

    static {
        try (InputStream fis = AppConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
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
