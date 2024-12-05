package com.weatherdashboard.model.weather;

import java.util.Objects;

public class Condition {
    private String text;

    public Condition() {
    }

    public Condition(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condition condition = (Condition) o;
        return Objects.equals(text, condition.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }
}
