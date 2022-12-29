package com.example.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonToSoftware;
    Button buttonToBAM;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Creates two references for an EditText view and a TextView view
        EditText insertUsername = findViewById(R.id.insertUsername);
        TextView welcomeMessage = findViewById(R.id.welcomeMessage);

        // When user clicks submit button
        Button buttonToSubmit = findViewById(R.id.submitUsername);
        buttonToSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user has clicked the button
                String userName = insertUsername.getText().toString();
                welcomeMessage.setText("Hello " + userName + "!");
            }
        });

        // Code for button which will lead to software page
        buttonToSoftware = findViewById(R.id.toSoftware);

        buttonToSoftware.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);



        });

        // Code for button which will lead to BAM page
        buttonToBAM = findViewById(R.id.toBAM);

        buttonToBAM.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);



        });

    }
}