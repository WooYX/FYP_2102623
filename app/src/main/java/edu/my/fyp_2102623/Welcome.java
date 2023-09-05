package edu.my.fyp_2102623;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    TextView welcomePage, subPage, btnExercise;
    ImageView wlcPage;
    Animation animimpage, bttone, bttwo, btthree, ltr;
    View Progress, ProgressStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //load animation
        animimpage = AnimationUtils.loadAnimation(this, R.anim.animimpage);
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        ltr = AnimationUtils.loadAnimation(this, R.anim.ltr);

        welcomePage = (TextView) findViewById(R.id.welcomePage);
        subPage = (TextView) findViewById(R.id.subPage);
        btnExercise = (TextView) findViewById(R.id.btnExercise);
        wlcPage = (ImageView) findViewById(R.id.wlcPage);
        Progress = (View) findViewById(R.id.Progress);
        ProgressStop = (View) findViewById(R.id.ProgressStop);

        //export animation
        wlcPage.startAnimation(animimpage);
        welcomePage.startAnimation(bttone);
        subPage.startAnimation(bttwo);

        btnExercise.startAnimation(btthree);
        Progress.startAnimation(bttwo);
        ProgressStop.startAnimation(ltr);

        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent
                Intent intent = new Intent(Welcome.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}