package com.weatherdashboard.model.weather;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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

    public Current() {
    }

    public Current(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Current{" +
                "tempC=" + tempC +
                ", condition=" + condition +
                ", windKph=" + windKph +
                ", humidity=" + humidity +
                ", feelslikeC=" + feelslikeC +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Current current = (Current) o;
        return Double.compare(tempC, current.tempC) == 0 && Double.compare(windKph, current.windKph) == 0 && Double.compare(feelslikeC, current.feelslikeC) == 0 && Objects.equals(condition, current.condition) && Objects.equals(humidity, current.humidity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tempC, condition, windKph, humidity, feelslikeC);
    }
}
