package edu.my.fyp_2102623;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class Timer extends AppCompatActivity {

    TextView introPage, subintroPage, timerValue, btnReset, btnPlay, btnPause,btnSetTime,btnHome,btnEnd;
    TextView tv30Secs, tv1Min, tv2Min,tv3Min, tv5Min,tv7Min, tv10Min, tv15Min;

    View divpage, Progress;
    ImageView imgtimer;


    private boolean btnPlayClicked;
    private static final long START_TIME_IN_MILLIS = 60000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    Animation animimpage, bttone, bttwo, btthree, alphagogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

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
        btnReset = (TextView) findViewById(R.id.btnReset);
        imgtimer = (ImageView) findViewById(R.id.imgtimer);
        btnPause = (TextView) findViewById(R.id.btnPause);
        btnPlay = (TextView) findViewById(R.id.btnPlay);
        btnSetTime=(TextView) findViewById(R.id.btnSetTime);
        btnHome=(TextView)findViewById(R.id.btnHome) ;
        btnEnd=(TextView)findViewById(R.id.btnEnd) ;
        tv30Secs = findViewById(R.id.tv30Secs);
        tv1Min = findViewById(R.id.tv1Min);
        tv2Min = findViewById(R.id.tv2Min);
        tv3Min = findViewById(R.id.tv3Min);
        tv5Min = findViewById(R.id.tv5Min);
        tv7Min = findViewById(R.id.tv7Min);
        tv10Min = findViewById(R.id.tv10Min);
        tv15Min = findViewById(R.id.tv15Min);

        //assign animation
        btnReset.startAnimation(btthree);
        Progress.startAnimation(btthree);
        introPage.startAnimation(bttwo);
        subintroPage.startAnimation(bttwo);
        divpage.startAnimation(bttwo);
        imgtimer.startAnimation(alphagogo);
        timerValue.startAnimation(alphagogo);
        btnPause.startAnimation(btthree);
        btnPlay.startAnimation(btthree);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
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
                Intent intent = new Intent(Timer.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the "Home" button
                Intent intent = new Intent(Timer.this, EndWorkout.class);
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

    private void resetTimer() {
        // Cancel the existing timer
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        // Reset the timer values
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        mTimerRunning = false;

        // Update the countdown text
        updateCountDownText();
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
                btnReset.performClick(); // Simulate a click on btnExercise
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
        TimePickerDialog timePickerDialog = new TimePickerDialog(Timer.this,
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

}