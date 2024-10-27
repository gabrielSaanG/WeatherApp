package com.example.weatherapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.weatherapp.MyAdapter.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.weatherapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity  extends AppCompatActivity {

    ActivityMainBinding binding;
    String txtJson;

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

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        List<Item> items = new ArrayList<Item>();

        items.add(new Item("Roma", "Itália", "13 C", "09:33", R.drawable.icon_cloud));

        items.add(new Item("Atenas", "Grécia", "19 C", "10:22", R.drawable.icon_cloud));

        items.add(new Item("São Paulo", "São Paulo", "22 C", "12:45", R.drawable.icon_cloud));

        String url = "https://api.hgbrasil.com/weather?woeid=461662";






        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(), items));
    }

}


