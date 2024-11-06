
package com.example.weatherapp;

import java.util.HashMap;

public class ClimateHashMap {

    HashMap<String, Integer> condition_climate = new HashMap<>();
    public void populateHashMap(){
        condition_climate.put("clear_day", R.drawable.clear_day);
        condition_climate.put("clear_night", R.drawable.clear_night);
        condition_climate.put("cloud", R.drawable.cloud);
        condition_climate.put("fog", R.drawable.fog);
        condition_climate.put("cloudly_day", R.drawable.cloudly_day);
        condition_climate.put("cloudly_night", R.drawable.cloudly_night);
        condition_climate.put("hail", R.drawable.hail);
        condition_climate.put("rain", R.drawable.rain);
        condition_climate.put("snow", R.drawable.snow);
        condition_climate.put("storm", R.drawable.storm);
    }


    public HashMap<String, Integer> getCondition_climate() {
        return condition_climate;
    }
}
