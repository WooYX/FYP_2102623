package edu.my.fyp_2102623.WorkoutModule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashSet;
import java.util.List;

import edu.my.fyp_2102623.R;

public class CustomAdapter extends ArrayAdapter<Workouts> {
    private HashSet<Workouts> selectedWorkouts = new HashSet<>();

    public CustomAdapter(Context context, List<Workouts> workouts) {
        super(context, 0, workouts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_workout, parent, false);
        }

        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.workout_name);
        ImageView imgView = (ImageView) convertView.findViewById(R.id.workout_image);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);

        // Get the data item for this position
        Workouts workout = getItem(position);

        // Populate the data into the template view using the data object
        tvName.setText(workout.getTitle());
        int imageResId = getContext().getResources().getIdentifier(workout.getImageName(), "drawable", getContext().getPackageName());
        imgView.setImageResource(imageResId);

        // Attach the click event handler for the checkbox
        checkBox.setOnCheckedChangeListener(null); // Clear existing listeners
        checkBox.setChecked(selectedWorkouts.contains(workout)); // Set checked based on whether the workout is in the set

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                selectedWorkouts.add(workout);
            } else {
                selectedWorkouts.remove(workout);
            }
        });

        // Return the completed view to render on screen
        return convertView;
    }

    public HashSet<Workouts> getSelectedWorkouts() {
        return selectedWorkouts;
    }
}