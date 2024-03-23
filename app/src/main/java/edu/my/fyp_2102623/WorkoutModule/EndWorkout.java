package edu.my.fyp_2102623.WorkoutModule;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import edu.my.fyp_2102623.MainActivity;
import edu.my.fyp_2102623.R;

public class EndWorkout extends AppCompatActivity {

    private Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_workout);

        btnHome = findViewById(R.id.btnHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndWorkout.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
