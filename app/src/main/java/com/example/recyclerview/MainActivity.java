package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private CityData cityData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cityData = new CityData(getResources().openRawResource(R.raw.cities));
        adapter = new ArrayAdapter<>(this,
                R.layout.listview_layout, R.id.cityListItem, cityData.initCityList);
        ListView citiesList = findViewById(R.id.citiesList);
        citiesList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.addMenuBtn && !cityData.reachedEnd()) {
            //Utils.showAlertDialog(this);
            adapter.add(cityData.getNextCity());
            return true;
        }
        if (id == R.id.nextMenuBtn) {
            Intent intent = new Intent(this, RecyclerActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}