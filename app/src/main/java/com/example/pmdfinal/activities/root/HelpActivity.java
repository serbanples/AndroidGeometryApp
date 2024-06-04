package com.example.pmdfinal.activities.root;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pmdfinal.R;

public class HelpActivity extends AppCompatActivity {

    private Button squareInfoButton;
    private Button rectangleInfoButton;
    private Button triangleInfoButton;
    private Button circleInfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        squareInfoButton = findViewById(R.id.squareInfoButton);
        rectangleInfoButton = findViewById(R.id.rectangleInfoButton);
        triangleInfoButton = findViewById(R.id.triangleInfoButton);
        circleInfoButton = findViewById(R.id.circleInfoButton);

        squareInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWikipediaPage("Square");
            }
        });

        rectangleInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWikipediaPage("Rectangle");
            }
        });

        triangleInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWikipediaPage("Triangle");
            }
        });

        circleInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWikipediaPage("Circle");
            }
        });
    }

    private void openWikipediaPage(String shape) {
        String url = "https://en.wikipedia.org/wiki/" + shape;
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}