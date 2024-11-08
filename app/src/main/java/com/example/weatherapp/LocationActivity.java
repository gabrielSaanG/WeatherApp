package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class LocationActivity extends AppCompatActivity {


    JSONObject json;
    JSONArray jsonArray;
    RecyclerView climateAndTime;
    MyForecastAdapter myAdapter;



    LinearLayoutManager linearLayoutManager;

    ClimateHashMap climateHashMap = new ClimateHashMap();

    List<Forecast> forecastList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        climateHashMap.populateHashMap();
        setContentView(R.layout.activity_location);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);



        String data = getIntent().getStringExtra("data");
        if(data == null){
            data = "null";
        }

        try {
            json = new JSONObject(data);
            Log.i("Array", json.getJSONObject("results").getString("condition_slug"));
            jsonArray = json.getJSONObject("results").getJSONArray("forecast");


            for (int i = 0; i<jsonArray.length(); i++){
                forecastList.add(new Forecast(jsonArray.getJSONObject(i).getString("description"),
                        climateHashMap.getClimate(jsonArray.getJSONObject(i).getString("condition"), climateHashMap.getCondition_climate()),
                        jsonArray.getJSONObject(i).getString("weekday")));
            }


            ImageView location_condition_img = findViewById(R.id.location_condition_img);
            TextView location_wind_text = findViewById(R.id.location_wind_text);
            TextView location_umidity_text = findViewById(R.id.location_umidity_text);
            TextView location_cloudiness_text = findViewById(R.id.location_cloudiness_text);
            TextView location_rain_text = findViewById(R.id.location_rain_text);


            location_condition_img.setImageResource(climateHashMap.getClimate(json.getJSONObject("results").getString("condition_slug"), climateHashMap.getCondition_climate()));
            location_wind_text.setText(json.getJSONObject("results").getString("wind_speedy"));
            location_umidity_text.setText(json.getJSONObject("results").getString("humidity"));
            location_cloudiness_text.setText(json.getJSONObject("results").getString("cloudiness"));
            location_rain_text.setText(json.getJSONObject("results").getString("rain") + " %");

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


        climateAndTime = findViewById(R.id.recyclerView_location);


        linearLayoutManager = new LinearLayoutManager(LocationActivity.this, LinearLayoutManager.HORIZONTAL, false);
        myAdapter = new MyForecastAdapter(getApplicationContext(), forecastList);
        climateAndTime.setLayoutManager(linearLayoutManager);
        climateAndTime.setAdapter(myAdapter);




        bottomNavigationView.setOnItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) item -> {
            switch(item.getItemId()){
                case R.id.navHome:
                    Intent intent1 = new Intent(LocationActivity.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.location:
                    break;
                case R.id.about:
                    Intent intent2 = new Intent(LocationActivity.this, AboutActivity.class);
                    startActivity(intent2);
                    break;

            }
            return false;
        });

//        try{
//
//        }
    }
}