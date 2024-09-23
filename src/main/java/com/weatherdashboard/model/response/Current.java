package com.weatherdashboard.model.response;

import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("temp_c")
    private double tempC;

    @SerializedName("temp_f")
    private double tempF;

    private Condition condition;

    @SerializedName("wind_kph")
    private double windKph;

    private int humidity;

    @SerializedName("feelslike_c")
    private double feelslikeC;

    public double getTempC() {
        return tempC;
    }

    public double getTempF() {
        return tempF;
    }

    public Condition getCondition() {
        return condition;
    }

    public double getWindKph() {
        return windKph;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }
}
