package com.example.weatherapp;

import android.widget.ImageView;
import android.widget.TextView;

public class Forecast {
    String description;
    int condition;
    String weekday;

    int location_condition_img;
    String location_wind_text;
    String location_umidity_text;
    String location_cloudiness_text;

    public int getLocation_condition_img() {
        return location_condition_img;
    }

    public void setLocation_condition_img(int location_condition_img) {
        this.location_condition_img = location_condition_img;
    }

    public String getLocation_wind_text() {
        return location_wind_text;
    }

    public void setLocation_wind_text(String location_wind_text) {
        this.location_wind_text = location_wind_text;
    }

    public String getLocation_umidity_text() {
        return location_umidity_text;
    }

    public void setLocation_umidity_text(String location_umidity_text) {
        this.location_umidity_text = location_umidity_text;
    }

    public String getLocation_cloudiness_text() {
        return location_cloudiness_text;
    }

    public void setLocation_cloudiness_text(String location_cloudiness_text) {
        this.location_cloudiness_text = location_cloudiness_text;
    }

    public String getLocation_rain_text() {
        return location_rain_text;
    }

    public void setLocation_rain_text(String location_rain_text) {
        this.location_rain_text = location_rain_text;
    }

    String location_rain_text;
    public Forecast(String description, int condition, String weekday) {
        this.description = description;
        this.condition = condition;
        this.weekday = weekday;
    }

    public Forecast(int location_condition_img, String location_wind_text,
                    String location_umidity_text, String location_cloudiness_text,
                    String location_rain_text)
    {
        this.location_condition_img = location_condition_img;
        this.location_wind_text = location_wind_text;
        this.location_umidity_text = location_umidity_text;
        this.location_cloudiness_text = location_cloudiness_text;
        this.location_rain_text = location_rain_text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }
}
