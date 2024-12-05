package com.weatherdashboard.model.forecast;

public class ForecastDay {
    Day day;
    String date;

    public ForecastDay() {
    }

    public ForecastDay(Day day, String date) {
        this.day = day;
        this.date = date;
    }

    public Day getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }
}
