package com.weatherdashboard.model.forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Forecast {
    @SerializedName("forecastday")
    List<ForecastDay> forecastDay;

    public Forecast() {
    }

    public Forecast(List<ForecastDay> forecastDay) {
        this.forecastDay = forecastDay;
    }

    public List<ForecastDay> getForecastDay() {
        return forecastDay;
    }
}
