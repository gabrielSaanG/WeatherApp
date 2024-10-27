package com.example.weatherapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{

    ImageView climate_image;
    TextView city_name, country_name, city_temperature, city_time;
    public MyViewHolder(View itemView) {
        super(itemView);
        climate_image = itemView.findViewById(R.id.climate_image);
        city_name = itemView.findViewById(R.id.city_name);
        country_name = itemView.findViewById(R.id.country_name);
        city_temperature = itemView.findViewById(R.id.city_temperature);
        city_time = itemView.findViewById(R.id.city_time);
    }
}
