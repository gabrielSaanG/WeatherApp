package com.example.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    List<Item> items;


    private ImageView deleteImgView;
    private static onItemClickListener listener;
    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener clickListener){
        listener = clickListener;
    }

    public MyAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item currentItem = items.get(position);
        holder.city_name.setText(items.get(position).getCity_name());
        holder.city_temperature.setText(items.get(position).getCity_temperature());
        holder.climate_image.setImageResource(items.get(position).getClimate_image());
        holder.city_time.setText(items.get(position).getCity_time());

    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView city_name;
        TextView city_temperature;
        ImageView climate_image;
        TextView city_time;
        ImageView deleteImgView;

        CardView city_card;




        public MyViewHolder (@NonNull View itemView, onItemClickListener listener){
            super(itemView);
            city_name = itemView.findViewById(R.id.city_name);
            city_temperature = itemView.findViewById(R.id.city_temperature);
            climate_image = itemView.findViewById(R.id.climate_image);
            city_time = itemView.findViewById(R.id.city_time);
            deleteImgView = itemView.findViewById(R.id.remove_item_icon);
            city_card = itemView.findViewById(R.id.city_card);


                deleteImgView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v){
                        listener.onItemClick(getAdapterPosition());
                    }
                });

                city_card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClick(getAdapterPosition());
                    }
                });
        }

    }

}

