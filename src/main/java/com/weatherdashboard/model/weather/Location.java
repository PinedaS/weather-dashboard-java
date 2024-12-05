package com.weatherdashboard.model.weather;

import java.util.Objects;

public class Location {
    private String name;
    private String region;
    private String country;
    private String localtime;

    public Location() {
    }

    public Location(String name, String region, String country, String localtime) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.localtime = localtime;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getLocaltime() {
        return localtime;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", localtime='" + localtime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && Objects.equals(region, location.region) && Objects.equals(country, location.country) && Objects.equals(localtime, location.localtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, country, localtime);
    }
}
