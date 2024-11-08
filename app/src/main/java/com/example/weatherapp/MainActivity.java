package com.example.weatherapp;


import android.content.Intent;
import android.os.Bundle;
import com.example.weatherapp.ClimateHashMap;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.weatherapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class MainActivity  extends AppCompatActivity {

    ActivityMainBinding binding;

    List<Item> itemsList = new ArrayList<Item>();
    JSONObject json = new JSONObject();

    ClimateHashMap climateHashMap = new ClimateHashMap();

    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        climateHashMap.populateHashMap();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        bottomNavigationView.setOnItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) item -> {
            switch (item.getItemId()) {
                case R.id.navHome:

                    break;
                case R.id.location:
                    Intent intent1 = new Intent(MainActivity.this, LocationActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.about:
                    Intent intent2 = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(intent2);
                    break;

            }
            return false;
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                try {
                    json = new JsonConverter().execute("https://api.hgbrasil.com/weather?woeid="+query).get();

                    itemsList.add(new Item(json.getJSONObject("results").getString("city"),
                            json.getJSONObject("results").getString("condition_code") + " °C",
                            json.getJSONObject("results").getString("time"),
                            climateHashMap.getClimate(json.getJSONObject("results").getString("condition_slug"), climateHashMap.getCondition_climate())));


                    onClickReloadView();

                } catch (IOException | ExecutionException | InterruptedException | JSONException e) {
                    throw new RuntimeException(e);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        MyAdapter adapter = new MyAdapter(getApplicationContext(), itemsList);
        adapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                itemsList.remove(position);
                adapter.notifyItemRemoved(position);
                onClickReloadView();
            }
        });

        adapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                intent.putExtra("data", json.toString());
                startActivity(intent);
            }
        });
    }

     public void onClickReloadView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), itemsList));
    }


}




