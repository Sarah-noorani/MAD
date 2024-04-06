package com.example.gpatracker;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem; // Import MenuItem
import android.widget.TextView;

public class GPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        double gpa = getIntent().getDoubleExtra("gpa", 0.0);

        TextView gpaTextView = findViewById(R.id.gpaTextView);

        double gpa100 = getIntent().getDoubleExtra("gpa", 0.0);

        double gpa40 = gpa100 / 25.0;

        String formattedGPA = String.format("%.2f", gpa40);

        gpaTextView.setText("Your GPA is:\n" + formattedGPA);

        // Enable the back button in the ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) { // If back button is clicked
            onBackPressed(); // Call onBackPressed() to navigate back
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

