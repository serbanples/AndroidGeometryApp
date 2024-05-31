package com.example.pmdfinal.activities.root;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pmdfinal.R;

public class ExerciseActivity extends AppCompatActivity {

    private EditText sideEditText, widthEditText, rectHeightEditText, radiusEditText, side1EditText, side2EditText, side3EditText;
    private TextView squareResultTextView, rectangleResultTextView, triangleResultTextView, circleResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        sideEditText = findViewById(R.id.sideEditText);
        widthEditText = findViewById(R.id.widthEditText);
        rectHeightEditText = findViewById(R.id.rectHeightEditText);
        radiusEditText = findViewById(R.id.radiusEditText);
        side1EditText = findViewById(R.id.side1EditText);
        side2EditText = findViewById(R.id.side2EditText);
        side3EditText = findViewById(R.id.side3EditText);

        squareResultTextView = findViewById(R.id.squareResultTextView);
        rectangleResultTextView = findViewById(R.id.rectangleResultTextView);
        triangleResultTextView = findViewById(R.id.triangleResultTextView);
        circleResultTextView = findViewById(R.id.circleResultTextView);

        Button calculateSquareButton = findViewById(R.id.calculateSquareButton);
        Button calculateRectangleButton = findViewById(R.id.calculateRectangleButton);
        Button calculateTriangleButton = findViewById(R.id.calculateTriangleButton);
        Button calculateCircleButton = findViewById(R.id.calculateCircleButton);

        calculateSquareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSquare();
            }
        });

        calculateRectangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRectangle();
            }
        });

        calculateTriangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTriangle();
            }
        });

        calculateCircleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCircle();
            }
        });
    }

    private void calculateSquare() {
        String sideStr = sideEditText.getText().toString();
        if (!sideStr.isEmpty()) {
            double side = Double.parseDouble(sideStr);
            double area = side * side;
            double perimeter = 4 * side;
            squareResultTextView.setText(String.format("Square Area: %.2f\nSquare Perimeter: %.2f", area, perimeter));
        } else {
            squareResultTextView.setText("Please enter the side length.");
        }
    }

    private void calculateRectangle() {
        String widthStr = widthEditText.getText().toString();
        String heightStr = rectHeightEditText.getText().toString();
        if (!widthStr.isEmpty() && !heightStr.isEmpty()) {
            double width = Double.parseDouble(widthStr);
            double height = Double.parseDouble(heightStr);
            double area = width * height;
            double perimeter = 2 * (width + height);
            rectangleResultTextView.setText(String.format("Rectangle Area: %.2f\nRectangle Perimeter: %.2f", area, perimeter));
        } else {
            rectangleResultTextView.setText("Please enter both width and height.");
        }
    }

    private void calculateTriangle() {
        String side1Str = side1EditText.getText().toString();
        String side2Str = side2EditText.getText().toString();
        String side3Str = side3EditText.getText().toString();
        if (!side1Str.isEmpty() && !side2Str.isEmpty() && !side3Str.isEmpty()) {
            double side1 = Double.parseDouble(side1Str);
            double side2 = Double.parseDouble(side2Str);
            double side3 = Double.parseDouble(side3Str);
            double perimeter = side1 + side2 + side3;
            double semiPerimeter = perimeter / 2;
            double area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
            triangleResultTextView.setText(String.format("Triangle Area: %.2f\nTriangle Perimeter: %.2f", area, perimeter));
        } else {
            triangleResultTextView.setText("Please enter all three sides.");
        }
    }

    private void calculateCircle() {
        String radiusStr = radiusEditText.getText().toString();
        if (!radiusStr.isEmpty()) {
            double radius = Double.parseDouble(radiusStr);
            double area = Math.PI * radius * radius;
            double perimeter = 2 * Math.PI * radius;
            circleResultTextView.setText(String.format("Circle Area: %.2f\nCircle Perimeter: %.2f", area, perimeter));
        } else {
            circleResultTextView.setText("Please enter the radius.");
        }
    }
}