package com.example.android.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameEditText= findViewById(R.id.name_edit_text);
                String name = nameEditText.getText().toString();

                Intent intent = new Intent(MainActivity.this, HelloActivity.class);
                intent.putExtra("username", name);
                startActivity(intent);
            }
        });

    }


}
