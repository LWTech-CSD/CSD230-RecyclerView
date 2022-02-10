package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class RecyclerActivity extends AppCompatActivity {
    private CityAdapter adapter;
    private RecyclerView cityList;
    private CityData cityData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cityData = new CityData(getResources().openRawResource(R.raw.cities));

        adapter = new CityAdapter(this, cityData.initCityList);
        cityList = findViewById(R.id.cityRecyclerView);
        cityList.setAdapter(adapter);
        cityList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.addMenuBtn) {
            adapter.data.add(cityData.getNextCity());
            adapter.notifyItemInserted(cityData.getLastPosition());
            return true;
        }
        if (id == R.id.nextMenuBtn) {
            adapter.data.remove(0);
            adapter.notifyItemRemoved(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}