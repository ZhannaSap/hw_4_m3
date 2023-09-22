package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.databinding.ItemContinentBinding;

import java.util.ArrayList;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentHolder> {

    private ArrayList<Continent> listContinent;
    private OnClick onItemClick;

    public ContinentAdapter(ArrayList<Continent> listContinent, OnClick onItemClick) {
        this.listContinent = listContinent;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public ContinentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentHolder(ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentHolder holder, int position) {
        holder.bind(listContinent.get(position));
        holder.itemView.setOnClickListener(view ->
                onItemClick.onClick(position)
        );
    }

    @Override
    public int getItemCount() {
        return listContinent.size();
    }
}
