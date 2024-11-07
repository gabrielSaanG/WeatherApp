package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.weatherapp.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONException;
import org.json.JSONObject;


public class LocationActivity extends AppCompatActivity {


    JSONObject json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_location);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        if (getIntent().hasExtra("woeidObject")){
            try {
                json = new JSONObject(getIntent().getStringExtra("woeidObject"));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

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
    }
}