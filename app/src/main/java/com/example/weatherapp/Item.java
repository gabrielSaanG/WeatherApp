package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("city")
    String city_name;
    String country_name;

    @SerializedName("condition_code")
    String city_temperature;

    @SerializedName("time")
    String city_time;


    int climate_image;

    public Item(String city_name ,String city_temperature, String city_time) {
        this.city_name = city_name;
        this.city_temperature = city_temperature;
        this.city_time = city_time;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCity_temperature() {
        return city_temperature;
    }

    public void setCity_temperature(String city_temperature) {
        this.city_temperature = city_temperature;
    }

    public String getCity_time() {
        return city_time;
    }

    public void setCity_time(String city_time) {
        this.city_time = city_time;
    }

    public int getClimate_image() {
        return climate_image;
    }

    public void setClimate_image(int climate_image) {
        this.climate_image = climate_image;
    }
}
