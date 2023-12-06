package com.example.hse_android_lab_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        CustomAdapter adapter = new CustomAdapter(new ArrayList<>());

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        EditText editText = findViewById(R.id.edit_text);

        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(v -> {
            String product = editText.getText().toString();
            adapter.addProduct(product);

            editText.setText("");
        });
    }
}
