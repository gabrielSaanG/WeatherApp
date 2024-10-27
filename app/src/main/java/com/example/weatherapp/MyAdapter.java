package com.example.weatherapp;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    List<Item> items;

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.city_name.setText(items.get(position).getCity_name());
        holder.country_name.setText(items.get(position).getCountry_name());
        holder.city_temperature.setText(items.get(position).getCity_temperature());
        holder.climate_image.setImageResource(items.get(position).getClimate_image());
        holder.city_time.setText(items.get(position).getCity_time());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
