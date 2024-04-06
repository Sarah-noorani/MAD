package com.example.gpatracker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText subject1Marks, subject2Marks, subject3Marks, subject4Marks, subject5Marks, subject6Marks;
    EditText subject1Credits, subject2Credits, subject3Credits, subject4Credits, subject5Credits, subject6Credits;
    Button calculateButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        subject1Marks = findViewById(R.id.subject1Marks);
        subject2Marks = findViewById(R.id.subject2Marks);
        subject3Marks = findViewById(R.id.subject3Marks);
        subject4Marks = findViewById(R.id.subject4Marks);
        subject5Marks = findViewById(R.id.subject5Marks);
        subject6Marks = findViewById(R.id.subject6Marks);
        subject1Credits = findViewById(R.id.subject1Credits);
        subject2Credits = findViewById(R.id.subject2Credits);
        subject3Credits = findViewById(R.id.subject3Credits);
        subject4Credits = findViewById(R.id.subject4Credits);
        subject5Credits = findViewById(R.id.subject5Credits);
        subject6Credits = findViewById(R.id.subject6Credits);
        calculateButton = findViewById(R.id.calculateButton);

        // Set OnClickListener for calculateButton
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calculate GPA
                double gpa = calculateGPA();

                // Navigate to GPActivity and pass GPA value as extra
                Intent intent = new Intent(MainActivity.this, GPActivity.class);
                intent.putExtra("gpa", gpa); // Pass GPA value as extra
                startActivity(intent);
            }
        });
        

    }

    // Method to calculate GPA
    private double calculateGPA() {
        // Retrieve marks and credits
        double marks1 = Double.parseDouble(subject1Marks.getText().toString());
        double marks2 = Double.parseDouble(subject2Marks.getText().toString());
        double marks3 = Double.parseDouble(subject3Marks.getText().toString());
        double marks4 = Double.parseDouble(subject4Marks.getText().toString());
        double marks5 = Double.parseDouble(subject5Marks.getText().toString());
        double marks6 = Double.parseDouble(subject6Marks.getText().toString());

        int credits1 = Integer.parseInt(subject1Credits.getText().toString());
        int credits2 = Integer.parseInt(subject2Credits.getText().toString());
        int credits3 = Integer.parseInt(subject3Credits.getText().toString());
        int credits4 = Integer.parseInt(subject4Credits.getText().toString());
        int credits5 = Integer.parseInt(subject5Credits.getText().toString());
        int credits6 = Integer.parseInt(subject6Credits.getText().toString());

        // Calculate total credits and total weighted marks
        int totalCredits = credits1 + credits2 + credits3 + credits4 + credits5 + credits6;
        double totalWeightedMarks = (marks1 * credits1) + (marks2 * credits2) + (marks3 * credits3) +
                (marks4 * credits4) + (marks5 * credits5) + (marks6 * credits6);

        // Calculate GPA
        return totalWeightedMarks / totalCredits;
    }
}
