package edu.my.fyp_2102623;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class FullBodyProgram extends AppCompatActivity {

    TextView introPage, subintroPage, timerValue, btnExercise, btnPlay, btnPause;
    View divpage, Progress;
    LinearLayout fitone;
    ImageView imgtimer;
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
        setContentView(R.layout.activity_full_body_program);

        gifImageList = new int[]{R.drawable.squatjumps, R.drawable.mountainclimbers, R.drawable.plankjacks, R.drawable.pushups, R.drawable.lunges, R.drawable.russiantwists, R.drawable.mountainclimbers, R.drawable.wallsit, R.drawable.deadlifts};
        NameList = new String[]{"Squat Jumps", "mountainclimbers","plankjacks", "pushups", "lunges", "russiantwists", "mountainclimbers", "wallsit","deadlifts"};
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
        imgtimer = (ImageView) findViewById(R.id.imgtimer);
        btnPause = (TextView) findViewById(R.id.btnPause);
        btnPlay = (TextView) findViewById(R.id.btnPlay);
        fbgif = (GifImageView) findViewById(R.id.fbgif);

        //assign animation
        btnExercise.startAnimation(btthree);
        Progress.startAnimation(btthree);
        fitone.startAnimation(bttone);
        introPage.startAnimation(bttwo);
        subintroPage.startAnimation(bttwo);
        divpage.startAnimation(bttwo);
        imgtimer.startAnimation(alphagogo);
        timerValue.startAnimation(alphagogo);
        btnPause.startAnimation(btthree);
        btnPlay.startAnimation(btthree);


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
    }


    private void changeExerciseImage() {
        if (currentIndex >= gifImageList.length) {
            // All GIFs have been displayed, navigate to EndWorkout activity
            pauseTimer();
            Intent intent = new Intent(FullBodyProgram.this, EndWorkout.class);
            startActivity(intent);
            finish(); // Optional, if you want to close the current activity after navigation
            return;
        }

        fbgif.setImageResource(gifImageList[currentIndex]);
        subintroPage.setText(NameList[currentIndex]);
        currentIndex++;
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
}