package edu.my.fyp_2102623.WorkoutModule;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

import edu.my.fyp_2102623.R;
import edu.my.fyp_2102623.WorkoutProgram.CustomProgram;

public class Custom_Workout extends AppCompatActivity {

    private EditText editTextWorkoutName;
    private Button buttonCurrent, buttonAddWorkout, buttonClearWorkouts,buttonStart;
    private ListView listViewWorkouts;
    private ArrayList<Workouts> workouts;
    private CustomAdapter adapter;
    private SharedPreferences sharedPreferences;
    private static final String WORKOUT_LIST_KEY = "workoutList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_workout);

        // Initialize UI components
        buttonCurrent = findViewById(R.id.CurrentWorkout);
        buttonAddWorkout = findViewById(R.id.buttonAddWorkout);
        buttonClearWorkouts = findViewById(R.id.buttonClearWorkouts);
        listViewWorkouts = findViewById(R.id.listViewWorkouts);
        buttonStart= findViewById(R.id.StartWorkout);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("WorkoutPrefs", MODE_PRIVATE);
        initializeDefaultWorkouts();

        adapter = new CustomAdapter(this, workouts);
        listViewWorkouts.setAdapter(adapter);

        // Add selected workouts to SharedPreferences
        buttonAddWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSelectedWorkouts();
            }
        });

        // Clear saved workouts
        buttonClearWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearSavedWorkouts();
            }
        });
        // Show existing workouts when buttonCurrent is clicked
        buttonCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showExistingWorkouts();
            }
        });
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the "Home" button
                Intent intent = new Intent(Custom_Workout.this, CustomProgram.class);
                startActivity(intent);
            }
        });
    }

    private void initializeDefaultWorkouts() {
        // Add default workouts here
        workouts = new ArrayList<>();
        workouts.add(new Workouts("Above Head Stretches", "aboveheadstretches"));
        workouts.add(new Workouts("Arm Circles", "armcircles"));
        workouts.add(new Workouts("Bench Press", "benchpress"));
        workouts.add(new Workouts("Bent Over Rows", "bentoverrows"));
        workouts.add(new Workouts("Bicep Curls", "bicepcurls"));
        workouts.add(new Workouts("Bicep Curls Copy", "bicepcurlscopy"));
        workouts.add(new Workouts("Bicycle Crunches", "bicyclecrunches"));
        workouts.add(new Workouts("Bodyweight Rows", "bodyweightrows"));
        workouts.add(new Workouts("Box Jumps", "boxjumps"));
        workouts.add(new Workouts("Bulgarian Split Squat", "bulgariansplitsquat"));
        workouts.add(new Workouts("Bulgarian Split Squat With Weight", "bulgariansplitsquatwithweight"));
        workouts.add(new Workouts("Burpee", "burpee"));
        workouts.add(new Workouts("Burpee Advance", "burpeeadvance"));
        workouts.add(new Workouts("Calf Raises", "calfraises"));
        workouts.add(new Workouts("Chest Press", "chestpress"));
        workouts.add(new Workouts("Chin-ups", "chinups"));
        workouts.add(new Workouts("Clean and Press", "cleanandpress"));
        workouts.add(new Workouts("Cobra Push-up", "cobrapushup"));
        workouts.add(new Workouts("Commando Pull-ups", "commandopullups"));
        workouts.add(new Workouts("Crunches", "crunches"));
        workouts.add(new Workouts("Deadlifts", "deadlifts"));
        workouts.add(new Workouts("Decline Push-ups", "declinepushups"));
        workouts.add(new Workouts("Diamond Push-ups", "diamondpushups"));
        workouts.add(new Workouts("Dips", "dips"));
        workouts.add(new Workouts("Dips Chair", "dipschair"));
        workouts.add(new Workouts("Flutter Kicks", "flutterkicks"));
        workouts.add(new Workouts("Glute Bridges", "glutebridges"));
        workouts.add(new Workouts("Hammer Curls", "hammercurls"));
        workouts.add(new Workouts("Handstand Push-ups", "handstandpushups"));
        workouts.add(new Workouts("Hanging Leg Raises", "hanginglegraises"));
        workouts.add(new Workouts("High Knees", "highknees"));
        workouts.add(new Workouts("Incline Push-ups", "inclinepushups"));
        workouts.add(new Workouts("Inverted Rows", "invertedrows"));
        workouts.add(new Workouts("Jumping Jacks", "jumpingjacks"));
        workouts.add(new Workouts("Jumping Lunges", "jumpinglunges"));
        workouts.add(new Workouts("Lat Pulldowns", "latpulldowns"));
        workouts.add(new Workouts("Leg Press", "legpress"));
        workouts.add(new Workouts("Leg Raises", "legraises"));
        workouts.add(new Workouts("Lunges", "lunges"));
        workouts.add(new Workouts("Medicine Ball Crunches", "medicineballcrunches"));
        workouts.add(new Workouts("Medicine Ball Slams", "medicineballslams"));
        workouts.add(new Workouts("Mountain Climbers", "mountainclimbers"));
        workouts.add(new Workouts("Negative Pull-up", "negativepullup"));
        workouts.add(new Workouts("One-arm Row", "onearmrow"));
        workouts.add(new Workouts("Pike Push-ups", "pikepushups"));
        workouts.add(new Workouts("Pistol Squats", "pistolsquats"));
        workouts.add(new Workouts("Plank Jacks", "plankjacks"));
        workouts.add(new Workouts("Planks", "planks"));
        workouts.add(new Workouts("Plank to Push-up", "planktopushup"));
        workouts.add(new Workouts("Plank Variations", "plankvariations"));
        workouts.add(new Workouts("Pull-ups", "pullups"));
        workouts.add(new Workouts("Push-ups", "pushups"));
        workouts.add(new Workouts("Push-up Variations", "pushupvariations"));
        workouts.add(new Workouts("Russian Twists", "russiantwists"));
        workouts.add(new Workouts("Scapular Pull-ups", "scapularpullups"));
        workouts.add(new Workouts("Shadowboxing", "shadowboxing"));
        workouts.add(new Workouts("Shoulder Press", "shoulderpress"));
        workouts.add(new Workouts("Shoulder Taps", "shouldertaps"));
        workouts.add(new Workouts("Sit-ups", "situps"));
        workouts.add(new Workouts("Skipping Rope", "skippingrope"));
        workouts.add(new Workouts("Slide to Slide Push-up", "slidetoslidepushup"));
        workouts.add(new Workouts("Squat Jumps", "squatjumps"));
        workouts.add(new Workouts("Squats", "squats"));
        workouts.add(new Workouts("Squat Thrust", "squatthrust"));
        workouts.add(new Workouts("Stair Running", "stairrunning"));
        workouts.add(new Workouts("Step-ups", "stepups"));
        workouts.add(new Workouts("Traises", "traises"));
        workouts.add(new Workouts("Tricep Dips", "tricepdips"));
        workouts.add(new Workouts("Tricep Extensions", "tricepextensions"));
        workouts.add(new Workouts("V-ups", "vups"));
        workouts.add(new Workouts("Wall Sit", "wallsit"));
        workouts.add(new Workouts("Wide Push-ups", "widepushups"));
        workouts.add(new Workouts("Y Raise", "yraise"));
    }

    private void addSelectedWorkouts() {
        HashSet<Workouts> selectedWorkouts = adapter.getSelectedWorkouts();
        workouts.addAll(selectedWorkouts);
        adapter.notifyDataSetChanged();
        saveWorkouts();
        Toast.makeText(Custom_Workout.this, "Workouts added", Toast.LENGTH_LONG).show();
    }

    private void saveWorkouts() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(workouts);
        editor.putString(WORKOUT_LIST_KEY, json);
        editor.apply();
    }

    private void loadWorkouts() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(WORKOUT_LIST_KEY, "");
        Type type = new TypeToken<ArrayList<Workouts>>() {
        }.getType();
        workouts = gson.fromJson(json, type);

        if (workouts == null) {
            workouts = new ArrayList<>();
        }
    }

    private void clearSavedWorkouts() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(WORKOUT_LIST_KEY);
        editor.apply();
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Workouts cleared", Toast.LENGTH_LONG).show();
    }

    private void showExistingWorkouts() {
        loadWorkouts(); // Ensure the latest list is loaded
        StringBuilder workoutsListBuilder = new StringBuilder();
        for (Workouts workout : workouts) {
            workoutsListBuilder.append(workout.getTitle()).append("\n");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Existing Workouts");
        builder.setMessage(workoutsListBuilder.toString());
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}



