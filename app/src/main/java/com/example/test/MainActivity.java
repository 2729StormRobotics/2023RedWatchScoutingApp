package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonToSoftware;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Code for button which will lead to software page
        buttonToSoftware = (Button) findViewById(R.id.toSoftware);

        buttonToSoftware.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);



        });

        // Code for button which will lead to BAM page
        buttonToSoftware = (Button) findViewById(R.id.toBAM);

        buttonToSoftware.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);



        });

    }
}