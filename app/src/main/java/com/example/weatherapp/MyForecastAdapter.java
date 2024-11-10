package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyForecastAdapter extends RecyclerView.Adapter<MyForecastAdapter.MyViewHolder> {

    Context context;

    List<Forecast> forecast;


    public MyForecastAdapter (Context context, List<Forecast> forecastItems){
        this.context = context;
        this.forecast = forecastItems;
    }

    @NonNull
    @Override
    public MyForecastAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.forecast_item, parent, false);
        return new MyForecastAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyForecastAdapter.MyViewHolder holder, int position){
        Forecast currentForecast = forecast.get(position);
        holder.condition.setImageResource(forecast.get(position).getCondition());
        holder.description.setText(forecast.get(position).getDescription());
        holder.weekDay.setText(forecast.get(position).getWeekday());
//
//        holder.location_rain_text.setText(forecast.get(position).getLocation_rain_text());
//        holder.location_cloudiness_text.setText(forecast.get(position).getLocation_cloudiness_text());
//        holder.location_wind_text.setText(forecast.get(position).getLocation_wind_text());
//        holder.location_umidity_text.setText(forecast.get(position).getLocation_umidity_text());
//        holder.location_condition_img.setImageResource(forecast.get(position).getLocation_condition_img());
    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView description;
        TextView weekDay;
        ImageView condition;




        public MyViewHolder (@NonNull View itemView){
            super(itemView);
            description = itemView.findViewById(R.id.description);
            weekDay = itemView.findViewById(R.id.weekday);
            condition = itemView.findViewById(R.id.forecast_condition);
//
//            location_condition_img = itemView.findViewById(R.id.location_condition_img);
//            location_wind_text = itemView.findViewById(R.id.location_wind_text);
//            location_umidity_text = itemView.findViewById(R.id.location_umidity_text);
//            location_cloudiness_text = itemView.findViewById(R.id.location_cloudiness_text);
//            location_rain_text = itemView.findViewById(R.id.location_rain_text);
        }
    }
}
