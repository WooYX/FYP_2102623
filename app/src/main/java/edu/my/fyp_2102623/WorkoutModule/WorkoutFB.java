package edu.my.fyp_2102623.WorkoutModule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import edu.my.fyp_2102623.R;
import edu.my.fyp_2102623.WorkoutProgram.FullBodyProgram;

public class WorkoutFB extends AppCompatActivity {

    TextView welcomePage, subPage, introPage,subintroPage,BtnExerciseFull;
    Animation animimpage, bttone, bttwo, btthree, ltr;
    View divpage,Progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_body_workout);
         //load animation
        animimpage = AnimationUtils.loadAnimation(this, R.anim.animimpage);
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        ltr = AnimationUtils.loadAnimation(this, R.anim.ltr);

        welcomePage = (TextView) findViewById(R.id.welcomePage);
        subPage = (TextView) findViewById(R.id.subPage);
        introPage = (TextView) findViewById(R.id.introPage);
        subintroPage = (TextView) findViewById(R.id.subintroPage);
        divpage=(View)findViewById(R.id.divpage);
        Progress = (View) findViewById(R.id.Progress);
        BtnExerciseFull=(TextView)findViewById(R.id.btnExerciseFull);

        BtnExerciseFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent = new Intent(WorkoutFB.this, FullBodyProgram.class);
                startActivity(intent);
            }
        });

        //export animation
        welcomePage.startAnimation(bttone);
        subPage.startAnimation(bttwo);
        introPage.startAnimation(bttone);
        subintroPage.startAnimation(bttwo);

        divpage.startAnimation(btthree);
        Progress.startAnimation(bttwo);
    }
}