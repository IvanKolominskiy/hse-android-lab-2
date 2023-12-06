package com.example.hse_android_lab_2;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private final TextView textView;

    private final Button editButton;

    private final Button deleteButton;

    public MyViewHolder(View v) {
        super(v);

        textView = v.findViewById(R.id.text_view);
        editButton = v.findViewById(R.id.edit_button);
        deleteButton = v.findViewById(R.id.delete_button);
    }

    public TextView getTextView() {
        return textView;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}
