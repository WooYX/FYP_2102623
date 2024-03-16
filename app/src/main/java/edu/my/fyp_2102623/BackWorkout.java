package edu.my.fyp_2102623;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BackWorkout extends AppCompatActivity {
    private RecyclerView recyclerViewWorkouts;
    private WorkoutAdapter workoutAdapter;
    TextView BtnExerciseFull;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_workout);

        recyclerViewWorkouts = findViewById(R.id.recyclerViewWorkouts);
        recyclerViewWorkouts.setLayoutManager(new LinearLayoutManager(this));

        // Generate workout lists using WorkoutGenerator
        List<Workout> BackWorkouts = WorkoutGenerator.generateBackWorkouts();

        // Combine all workout lists into a single list
        List<Workout> allWorkouts = new ArrayList<>();
        allWorkouts.addAll(BackWorkouts);

        // Set up the RecyclerView with the adapter
        workoutAdapter = new WorkoutAdapter(allWorkouts);
        recyclerViewWorkouts.setAdapter(workoutAdapter);
        BtnExerciseFull=(TextView)findViewById(R.id.btnExerciseFull);

        BtnExerciseFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent = new Intent(BackWorkout.this, CoreProgram.class);
                startActivity(intent);
            }
        });
    }
}