package com.example.pmdfinal.activities.root;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pmdfinal.R;

public class HomeActivity extends AppCompatActivity {
    private TextView welcomeTextView;
    private Button exerciseButton;
    private Button helpButton;
    private Button theoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcomeTextView = findViewById(R.id.welcomeText);
        String username = getIntent().getStringExtra("USERNAME");
        if(username != null) {
            String welcomeMessage = "Welcome " + username + "!";
            welcomeTextView.setText(welcomeMessage);
        }

        exerciseButton = findViewById(R.id.exerciseButton);
        helpButton = findViewById(R.id.helpButton);
        theoryButton = findViewById(R.id.theoryButton);

        exerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ExerciseActivity.class);
                startActivity(intent);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });

        theoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, TheoryActivity.class);
                startActivity(intent);
            }
        });
    }
}