package com.weatherdashboard.model.weather;

import java.util.Objects;

public class WeatherResponse {
    private Location location;
    private Current current;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public WeatherResponse() {
    }

    public WeatherResponse(Location location, Current current) {
        this.location = location;
        this.current = current;
    }

    @Override
    public String toString() {
        return "WeatherResponse{" +
                "location=" + location +
                ", current=" + current +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherResponse that = (WeatherResponse) o;
        return Objects.equals(location, that.location) && Objects.equals(current, that.current);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, current);
    }
}
