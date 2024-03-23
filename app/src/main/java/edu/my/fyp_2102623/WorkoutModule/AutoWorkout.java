package edu.my.fyp_2102623.WorkoutModule;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.my.fyp_2102623.R;

public class AutoWorkout extends AppCompatActivity {
    private RecyclerView recyclerViewWorkouts;
    private WorkoutAdapter workoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_workout);

        recyclerViewWorkouts = findViewById(R.id.recyclerViewWorkouts);
        recyclerViewWorkouts.setLayoutManager(new LinearLayoutManager(this));

        // Generate workout lists using WorkoutGenerator
        List<Workout> legWorkouts = WorkoutGenerator.generateLegWorkouts();
        List<Workout> chestWorkouts = WorkoutGenerator.generateChestWorkouts();
        List<Workout> backWorkouts = WorkoutGenerator.generateBackWorkouts();
        List<Workout> armWorkouts = WorkoutGenerator.generateArmWorkouts();

        // Combine all workout lists into a single list
        List<Workout> allWorkouts = new ArrayList<>();
        allWorkouts.addAll(legWorkouts);
        allWorkouts.addAll(chestWorkouts);
        allWorkouts.addAll(backWorkouts);
        allWorkouts.addAll(armWorkouts);

        // Set up the RecyclerView with the adapter
        workoutAdapter = new WorkoutAdapter(allWorkouts);
        recyclerViewWorkouts.setAdapter(workoutAdapter);
    }
}
