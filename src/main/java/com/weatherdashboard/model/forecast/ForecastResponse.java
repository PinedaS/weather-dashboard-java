package com.weatherdashboard.model.forecast;

public class ForecastResponse {
    Forecast forecast;

    public ForecastResponse() {
    }

    public ForecastResponse(Forecast forecast) {
        this.forecast = forecast;
    }

    public Forecast getForecast() {
        return forecast;
    }
}
