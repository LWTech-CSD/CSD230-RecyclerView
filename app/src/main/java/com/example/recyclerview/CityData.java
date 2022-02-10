package com.example.recyclerview;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CityData {
    private String[] initialCities = {"Kirkland,King"};
    public ArrayList<String> initCityList;
    private int cityPtr = 0;
    ArrayList<String> allCities = new ArrayList<>();


    public CityData(InputStream stream) {
        initCityList = new ArrayList<>(Arrays.asList(initialCities));
        // Read file into an array list
        Scanner fin = new Scanner(stream);
        while (fin.hasNextLine()) {
            allCities.add(fin.nextLine());
        }
    }

    public String getNextCity() {
        if (cityPtr >= allCities.size()) {
            return "No more data";
        }
        return allCities.get(cityPtr++);
    }

    public int getLastPosition() {
        return cityPtr;
    }

    public boolean reachedEnd() {
        return cityPtr >= allCities.size();
    }
}
