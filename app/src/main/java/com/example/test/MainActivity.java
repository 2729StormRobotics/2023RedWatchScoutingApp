package com.example.test;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button buttonToSoftware;
    Button buttonToBAM;
    private FirebaseAuth auth;
    private ProgressDialog progressDialog;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState, Object name, Object password) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ProgressDialog processDialog = new ProgressDialog(this);

        // Create variables
        String userName = "";
        String passWord = "";

        // Creates references for EditText views and TextView views
        EditText insertUsername = findViewById(R.id.insertUsername);
        TextView welcomeMessage = findViewById(R.id.welcomeMessage);
        EditText insertPassword = findViewById(R.id.insertPassword);

        // When user clicks submit button
        Button buttonToSubmit = findViewById(R.id.submitUsername);
        buttonToSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user has clicked the button
                userName = insertUsername.getText().toString();
                passWord = insertPassword.getText().toString();

                validate(userName, passWord);
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


        public void validate(String s, String d) {
            processDialog.setMessage("................Please wait lmao.......");
            processDialog.show();

            auth.signInWithEmailAndPassword(userName, passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        processDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        processDialog.dismiss();

                    }
                }
            })
        }

    }
}