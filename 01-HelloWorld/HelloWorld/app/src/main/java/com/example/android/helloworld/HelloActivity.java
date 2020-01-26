package com.example.android.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        String name = getIntent().getStringExtra("username");
        TextView nameTextView = findViewById(R.id.name_text_view);
        nameTextView.setText("Hello, " + name);

    }
}
