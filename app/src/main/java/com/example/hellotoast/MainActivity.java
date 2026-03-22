package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// Implementing View.OnClickListener changes the structure of how clicks are handled
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Changed variable name and comment style
    /* Tracks the current number displayed on screen */
    private int currentTally = 0;

    // Renamed the TextView object
    private TextView numberDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        // Renamed local variables and mapped them to the XML IDs
        numberDisplay = findViewById(R.id.text_count);
        Button btnGreeting = findViewById(R.id.button_toast);
        Button btnIncrease = findViewById(R.id.button_count);

        // Setting the click listeners to 'this' (the activity itself) instead of lambdas
        btnGreeting.setOnClickListener(this);
        btnIncrease.setOnClickListener(this);
    }

    // All click events are now handled in this single overridden method
    @Override
    public void onClick(View clickedView) {
        int viewId = clickedView.getId();

        if (viewId == R.id.button_toast) {
            // Created a Toast object first, using getApplicationContext(), then showing it
            Toast greetingMessage = Toast.makeText(getApplicationContext(), "Bonjour !", Toast.LENGTH_SHORT);
            greetingMessage.show();
            
        } else if (viewId == R.id.button_count) {
            // Using += 1 instead of ++
            currentTally += 1; 
            // Using Integer.toString() instead of String.valueOf()
            numberDisplay.setText(Integer.toString(currentTally)); 
        }
    }
}
