package edu.my.fyp_2102623;

import androidx.appcompat.app.AppCompatActivity;

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

public class FullBodyProgram extends AppCompatActivity {

    TextView introPage, subintroPage,timerValue,btnExercise;
    View divpage, Progress;
    LinearLayout fitone;
    ImageView imgtimer;

    private static final long START_TIME_IN_MILLIS = 35000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    Animation animimpage, bttone, bttwo, btthree,alphagogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_body_program);

        //load animation
        animimpage = AnimationUtils.loadAnimation(this, R.anim.animimpage);
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        alphagogo= AnimationUtils.loadAnimation(this,R.anim.alphagogo);


        introPage = (TextView) findViewById(R.id.introPage);
        subintroPage = (TextView) findViewById(R.id.subintroPage);
        divpage = (View) findViewById(R.id.divpage);
        Progress = (View) findViewById(R.id.Progress);
        timerValue=(TextView) findViewById(R.id.timerValue);
        fitone=(LinearLayout)findViewById(R.id.fitone);
        btnExercise = (TextView)findViewById(R.id.btnExercise) ;
        imgtimer= (ImageView)findViewById(R.id.imgtimer);

        //assign animation
        btnExercise.startAnimation(btthree);
        Progress.startAnimation(btthree);
        fitone.startAnimation(bttone);
        introPage.startAnimation(bttwo);
        subintroPage.startAnimation(bttwo);
        divpage.startAnimation(bttwo);
        imgtimer.startAnimation(alphagogo);
        timerValue.startAnimation(alphagogo);


        startTimer();
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
                Toast.makeText(getApplicationContext(),"Congrats",Toast.LENGTH_SHORT).show();
            }
        }.start();
        mTimerRunning= true;
    }

    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis/1000)/60;
        int seconds =(int)(mTimeLeftInMillis/1000)%60;

        String timeLeft = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        timerValue.setText(timeLeft);
    }
}