package edu.my.fyp_2102623.WorkoutProgram;

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Locale;

import edu.my.fyp_2102623.WorkoutModule.EndWorkout;
import edu.my.fyp_2102623.MainActivity;
import edu.my.fyp_2102623.R;
import edu.my.fyp_2102623.WorkoutModule.Workouts;
import pl.droidsonroids.gif.GifImageView;

public class CustomProgram extends AppCompatActivity {

    TextView introPage, subintroPage, timerValue, btnExercise, btnPlay, btnPause,btnSetTime,btnHome,btnEnd;;
    TextView tv30Secs, tv1Min, tv2Min,tv3Min, tv5Min,tv7Min, tv10Min, tv15Min;
    View divpage, Progress;
    LinearLayout fitone;
    GifImageView fbgif;
    private boolean btnPlayClicked;
    private static final long START_TIME_IN_MILLIS = 35000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    private int[] gifImageList;
    private String[] NameList;
    Animation animimpage, bttone, bttwo, btthree, alphagogo;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_program);

        currentIndex = 0;



        //load animation
        animimpage = AnimationUtils.loadAnimation(this, R.anim.animimpage);
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        alphagogo = AnimationUtils.loadAnimation(this, R.anim.alphagogo);


        introPage = (TextView) findViewById(R.id.introPage);
        subintroPage = (TextView) findViewById(R.id.subintroPage);
        divpage = (View) findViewById(R.id.divpage);
        Progress = (View) findViewById(R.id.Progress);
        timerValue = (TextView) findViewById(R.id.timerValue);
        fitone = (LinearLayout) findViewById(R.id.fitone);
        btnExercise = (TextView) findViewById(R.id.btnExercise);
        btnPause = (TextView) findViewById(R.id.btnPause);
        btnPlay = (TextView) findViewById(R.id.btnPlay);
        fbgif = (GifImageView) findViewById(R.id.fbgif);
        btnHome=(TextView)findViewById(R.id.btnHome) ;
        btnEnd=(TextView)findViewById(R.id.btnEnd) ;
        btnSetTime=(TextView) findViewById(R.id.btnSetTime);
        tv30Secs = findViewById(R.id.tv30Secs);
        tv1Min = findViewById(R.id.tv1Min);
        tv2Min = findViewById(R.id.tv2Min);
        tv3Min = findViewById(R.id.tv3Min);
        tv5Min = findViewById(R.id.tv5Min);
        tv7Min = findViewById(R.id.tv7Min);
        tv10Min = findViewById(R.id.tv10Min);
        tv15Min = findViewById(R.id.tv15Min);

        //assign animation
        btnExercise.startAnimation(btthree);
        Progress.startAnimation(btthree);
        fitone.startAnimation(bttone);
        introPage.startAnimation(bttwo);
        subintroPage.startAnimation(bttwo);
        divpage.startAnimation(bttwo);
        timerValue.startAnimation(alphagogo);
        btnPause.startAnimation(btthree);
        btnPlay.startAnimation(btthree);

        loadWorkoutsFromSharedPreferences();
        startTimer();

        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
                startTimer();
                changeExerciseImage();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
        btnSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the "Home" button
                Intent intent = new Intent(CustomProgram.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the "Home" button
                Intent intent = new Intent(CustomProgram.this, EndWorkout.class);
                startActivity(intent);
            }
        });
        // Set click listeners for each TextView
        tv30Secs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimer(30000); // 30 seconds
            }
        });

        tv1Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimer(60000); // 1 minute
            }
        });

        tv2Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimer(120000); // 2 minutes
            }
        });

        tv3Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimer(180000); // 3 minutes
            }
        });

        tv7Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimer(420000); // 7 minutes
            }
        });

        tv5Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimer(300000); // 5 minutes
            }
        });

        tv10Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimer(600000); // 10 minutes
            }
        });

        tv15Min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTimer(900000); // 15 minutes
            }
        });
    }

    private void changeExerciseImage() {
        // Check if the shared preferences were initially empty, indicated by gifImageList and NameList not being initialized or being empty
        if (gifImageList == null || gifImageList.length == 0 || NameList == null || NameList.length == 0) {
            // If there are no workouts to display, go directly to the EndWorkout activity
            navigateToEndWorkout();
            return;
        }

        if (currentIndex >= gifImageList.length) {
            // If all workouts have been displayed, also navigate to the EndWorkout activity
            navigateToEndWorkout();
            return;
        }

        // Otherwise, proceed to show the next workout
        fbgif.setImageResource(gifImageList[currentIndex]);
        subintroPage.setText(NameList[currentIndex]);
        currentIndex++;
    }
    private void navigateToEndWorkout() {
        pauseTimer(); // Optional: Consider pausing or resetting the timer here if appropriate
        Intent intent = new Intent(CustomProgram.this, EndWorkout.class);
        startActivity(intent);
        finish(); // Optional: Use this if you want to prevent users from navigating back to this activity
    }
    private void resetTimer() {
        // Cancel the existing timer
        countDownTimer.cancel();

        // Reset the timer values
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        mTimerRunning = false;

        // Update the countdown text
        updateCountDownText();

        // Restart the timer if the "Play" button was clicked
        if (btnPlayClicked) {
            startTimer();
        }
    }


    private void pauseTimer() {
        if (mTimerRunning) {
            countDownTimer.cancel();
            mTimerRunning = false;
        }
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                btnExercise.performClick(); // Simulate a click on btnExercise
            }
        }.start();
        mTimerRunning = true;
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerValue.setText(timeLeft);
    }

    private void showTimePickerDialog() {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create a time picker dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(CustomProgram.this,
                (view, hourOfDay, minute1) -> {
                    // Calculate the total time in milliseconds
                    long totalTimeInMillis = (hourOfDay * 3600 + minute1 * 60) * 1000;

                    // Update the countdown timer with the new time
                    updateTimer(totalTimeInMillis);
                }, hour, minute, true);

        // Show the time picker dialog
        timePickerDialog.show();
    }

    private void updateTimer(long totalTimeInMillis) {
        // Cancel the existing timer
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        // Reset the timer values
        mTimeLeftInMillis = totalTimeInMillis;
        mTimerRunning = false;

        // Update the countdown text
        updateCountDownText();
    }
    private void loadWorkoutsFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("WorkoutPrefs", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("workoutList", null); // Ensure this key matches the one used in Custom_Workout
        Type type = new TypeToken<ArrayList<Workouts>>() {}.getType();
        ArrayList<Workouts> loadedWorkouts = gson.fromJson(json, type);

        if (loadedWorkouts == null || loadedWorkouts.isEmpty()) {
            // If there are no workouts, display "No custom workout" and show the Saitama image
            introPage.setText("No custom workout");
            subintroPage.setText("No custom workout");
            fbgif.setImageResource(R.drawable.saitama);
            // Early return to skip trying to load non-existent workouts
            return;
        }

        // Assuming gifImageList and NameList are to be filled here
        gifImageList = new int[loadedWorkouts.size()];
        NameList = new String[loadedWorkouts.size()];

        for (int i = 0; i < loadedWorkouts.size(); i++) {
            Workouts workout = loadedWorkouts.get(i);
            NameList[i] = workout.getTitle();
            gifImageList[i] = getResources().getIdentifier(workout.getImageName(), "drawable", getPackageName());
        }

        currentIndex = 0; // Reset to start showing from the first workout

        // Optionally, preload the first workout if workouts are present
        changeExerciseImage(); // Adjust this method if necessary
    }


}