package com.example.weatherapp;


import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;


import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.weatherapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class MainActivity  extends AppCompatActivity {

    ActivityMainBinding binding;

    List<Item> itemsList = new ArrayList<Item>();
    JSONObject json = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                    Log.i("JSON", json.getJSONObject("results").toString());

                    itemsList.add(new Item(json.getJSONObject("results").getString("city"),
                            json.getJSONObject("results").getString("condition_code"),
                            json.getJSONObject("results").getString("time")));

                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(new MyAdapter(getApplicationContext(), itemsList));

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





    }


}


