package edu.my.fyp_2102623;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkoutPage extends AppCompatActivity {

    TextView CWP, fullbodytxt, coretxt, timertxt, armtxt, chesttxt, backtxt, legtxt, customizetxt;
    Animation animimpage, bttone, bttwo, btthree, ltr;
    ImageView fullbody, core, arm, chest, back, leg, customize,timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_page);
        //load animation
        animimpage = AnimationUtils.loadAnimation(this, R.anim.animimpage);
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        ltr = AnimationUtils.loadAnimation(this, R.anim.ltr);

        CWP = (TextView) findViewById(R.id.CWP);
        fullbodytxt = (TextView) findViewById(R.id.fullbodytxt);
        coretxt = (TextView) findViewById(R.id.coretxt);
        timertxt = (TextView) findViewById(R.id.timertxt);
        armtxt = (TextView) findViewById(R.id.armtxt);
        chesttxt = (TextView) findViewById(R.id.chesttxt);
        backtxt = (TextView) findViewById(R.id.backtxt);
        legtxt = (TextView) findViewById(R.id.legtxt);
        customizetxt = (TextView) findViewById(R.id.customizetxt);

        fullbody = (ImageView) findViewById(R.id.fullbody);
        core = (ImageView) findViewById(R.id.core);
        timer = (ImageView) findViewById(R.id.timer);
        arm = (ImageView) findViewById(R.id.arm);
        chest = (ImageView) findViewById(R.id.chest);
        back = (ImageView) findViewById(R.id.back);
        leg = (ImageView) findViewById(R.id.leg);
        customize = (ImageView) findViewById(R.id.customize);


        fullbodytxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent1 = new Intent(WorkoutPage.this, WorkoutFB.class);
                startActivity(intent1);
            }
        });
        coretxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent2 = new Intent(WorkoutPage.this, WorkoutCore.class);
                startActivity(intent2);
            }
        });
        timertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent3 = new Intent(WorkoutPage.this, Timer.class);
                startActivity(intent3);
            }
        });
        armtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent4 = new Intent(WorkoutPage.this, ArmWorkout.class);
                startActivity(intent4);
            }
        });
        chesttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent5 = new Intent(WorkoutPage.this, ChestWorkout.class);
                startActivity(intent5);
            }
        });
        backtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent6 = new Intent(WorkoutPage.this, BackWorkout.class);
                startActivity(intent6);
            }
        });
        legtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent7 = new Intent(WorkoutPage.this, LegWorkout.class);
                startActivity(intent7);
            }
        });
        timertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent8 = new Intent(WorkoutPage.this, Timer.class);
                startActivity(intent8);
            }
        });
        customizetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent10 = new Intent(WorkoutPage.this, Custom_Workout.class);
                startActivity(intent10);
            }
        });
        fullbody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent11 = new Intent(WorkoutPage.this,WorkoutFB.class);
                startActivity(intent11);
            }
        });
        core.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent12 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent12);
            }
        });
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent13 = new Intent(WorkoutPage.this,Timer.class);
                startActivity(intent13);
            }
        });
        arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent14 = new Intent(WorkoutPage.this,ArmWorkout.class);
                startActivity(intent14);
            }
        });
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent15 = new Intent(WorkoutPage.this,ChestWorkout.class);
                startActivity(intent15);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent16 = new Intent(WorkoutPage.this,BackWorkout.class);
                startActivity(intent16);
            }
        });
        leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent17 = new Intent(WorkoutPage.this,LegWorkout.class);
                startActivity(intent17);
            }
        });
        customize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent20 = new Intent(WorkoutPage.this,Custom_Workout.class);
                startActivity(intent20);
            }
        });

        fullbodytxt.startAnimation(bttone);
        coretxt.startAnimation(bttone);
        timertxt.startAnimation(bttone);
        armtxt.startAnimation(bttone);
        chesttxt.startAnimation(bttone);
        backtxt.startAnimation(bttone);
        legtxt.startAnimation(bttone);
        timertxt.startAnimation(bttone);
        customizetxt.startAnimation(bttone);
        fullbody.startAnimation(bttwo);
        core.startAnimation(bttwo);
        timer.startAnimation(bttwo);
        arm.startAnimation(bttwo);
        chest.startAnimation(bttwo);
        back.startAnimation(bttwo);
        leg.startAnimation(bttwo);
        customize.startAnimation(bttwo);


    }
}