package com.weatherdashboard.model.response;

import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("temp_c")
    private double tempC;

    private Condition condition;

    @SerializedName("wind_kph")
    private double windKph;

    private Integer humidity;

    @SerializedName("feelslike_c")
    private double feelslikeC;

    public double getTempC() {
        return tempC;
    }

    public Condition getCondition() {
        return condition;
    }

    public double getWindKph() {
        return windKph;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public double getFeelslikeC() {
        return feelslikeC;
    }
}
