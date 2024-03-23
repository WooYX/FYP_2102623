package edu.my.fyp_2102623.WorkoutModule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import edu.my.fyp_2102623.R;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {
    private List<Workout> workoutList;
    private LayoutInflater inflater;

    public WorkoutAdapter(List<Workout> workoutList) {
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        View view = inflater.inflate(R.layout.item_workout, parent, false);
        return new WorkoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        Workout workout = workoutList.get(position);
        holder.bind(workout);
    }

    @Override
    public int getItemCount() {
        return workoutList.size();
    }

    static class WorkoutViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private ImageView imageViewWorkout;

        public WorkoutViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            imageViewWorkout = itemView.findViewById(R.id.imageViewWorkout);
        }

        public void bind(Workout workout) {
            titleTextView.setText(workout.getTitle());
            // Assuming the image names match drawable resource names
            int imageResId = itemView.getContext().getResources().getIdentifier(
                    workout.getImageName(), "drawable", itemView.getContext().getPackageName());
            imageViewWorkout.setImageResource(imageResId);
        }
    }
}


