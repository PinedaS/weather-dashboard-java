package com.weatherdashboard.model.forecast;

import com.google.gson.annotations.SerializedName;
import com.weatherdashboard.model.weather.Condition;

public class Day {
    @SerializedName("mintemp_c")
    private double minTempC;

    @SerializedName("maxtemp_c")
    private double maxTempC;

    private Condition condition;

    public Day() {
    }

    public Day(double minTempC, double maxTempC, Condition condition) {
        this.minTempC = minTempC;
        this.maxTempC = maxTempC;
        this.condition = condition;
    }

    public double getMinTempC() {
        return minTempC;
    }

    public double getMaxTempC() {
        return maxTempC;
    }

    public Condition getCondition() {
        return condition;
    }
}
