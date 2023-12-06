package com.example.hse_android_lab_2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final ArrayList<String> dataSet;
    private final Activity context;

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,
                parent, false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(@NonNull MyViewHolder vh, int position) {
        vh.getTextView().setText(dataSet.get(position));

        vh.getDeleteButton().setOnClickListener(v -> deleteProduct(position));

        vh.getEditButton().setOnClickListener(v -> {
            Dialog dialog = new Dialog(context);

            dialog.setContentView(R.layout.dialog);
            Objects.requireNonNull(dialog.getWindow()).setLayout(
                    WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.show();

            EditText editText = dialog.findViewById(R.id.update_text);
            Button updateButton = dialog.findViewById(R.id.update_button);

            updateButton.setOnClickListener(v1 -> {
                dialog.dismiss();

                String newProduct = editText.getText().toString();
                editProduct(position, newProduct);
            });
        });
    }

    public CustomAdapter(ArrayList<String> dataSet, Activity context) {
        this.dataSet = dataSet;
        this.context = context;
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
