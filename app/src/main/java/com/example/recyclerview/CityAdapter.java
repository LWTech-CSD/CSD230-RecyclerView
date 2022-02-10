package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    class CityViewHolder extends RecyclerView.ViewHolder {
        public TextView cityTextView;
        public ImageView cityImg;
        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            cityTextView = itemView.findViewById(R.id.cityRecyclerItem);
            cityImg = itemView.findViewById(R.id.cityImg);
        }
    }

    private LayoutInflater inflator;
    public ArrayList<String> data;
    public CityAdapter(Context context, ArrayList<String> data) {
        inflator = LayoutInflater.from(context);
        this.data = data;
    }
    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cityItemView =
                inflator.inflate(R.layout.recycler_item, parent, false);
        return new CityViewHolder(cityItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.cityTextView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}


