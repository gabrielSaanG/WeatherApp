package com.example.weatherapp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    public static final String BASE_URL = "https://www.api.hgbrasil.com/weather";
    @GET("weather/results/")
    Call<ArrayList<Item>> getPosts();
}
