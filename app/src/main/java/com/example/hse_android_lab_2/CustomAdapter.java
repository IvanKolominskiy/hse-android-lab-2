package com.example.hse_android_lab_2;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<String> dataSet;

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(@NonNull MyViewHolder vh, int position) {
        vh.getTextView().setText(dataSet.get(position));

        vh.getDeleteButton().setOnClickListener(v -> {
            deleteProduct(position);
        });
    }

    public CustomAdapter(ArrayList<String> dataSet) {
        this.dataSet = dataSet;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void editProduct(int position, String newProduct) {
        dataSet.set(position, newProduct);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addProduct(String product) {
        dataSet.add(product);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void deleteProduct(int position) {
        dataSet.remove(position);
        notifyDataSetChanged();
    }
}
