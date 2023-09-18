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

    TextView CWP, fullbodytxt, coretxt, shouldertxt, armtxt, chesttxt, backtxt, legtxt, powertxt, cardiotxt, customizetxt;
    Animation animimpage, bttone, bttwo, btthree, ltr;
    ImageView fullbody, core, shoulder, arm, chest, back, leg, power, cardio, customize;

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
        shouldertxt = (TextView) findViewById(R.id.shouldertxt);
        armtxt = (TextView) findViewById(R.id.armtxt);
        chesttxt = (TextView) findViewById(R.id.chesttxt);
        backtxt = (TextView) findViewById(R.id.backtxt);
        legtxt = (TextView) findViewById(R.id.legtxt);
        powertxt = (TextView) findViewById(R.id.powertxt);
        cardiotxt = (TextView) findViewById(R.id.cardiotxt);
        customizetxt = (TextView) findViewById(R.id.customizetxt);

        fullbody = (ImageView) findViewById(R.id.fullbody);
        core = (ImageView) findViewById(R.id.core);
        shoulder = (ImageView) findViewById(R.id.shoulder);
        arm = (ImageView) findViewById(R.id.arm);
        chest = (ImageView) findViewById(R.id.chest);
        back = (ImageView) findViewById(R.id.back);
        leg = (ImageView) findViewById(R.id.leg);
        power = (ImageView) findViewById(R.id.power);
        cardio = (ImageView) findViewById(R.id.cardio);
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
        shouldertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent3 = new Intent(WorkoutPage.this, WorkoutCore.class);
                startActivity(intent3);
            }
        });
        armtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent4 = new Intent(WorkoutPage.this, WorkoutCore.class);
                startActivity(intent4);
            }
        });
        chesttxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent5 = new Intent(WorkoutPage.this, WorkoutCore.class);
                startActivity(intent5);
            }
        });
        backtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent6 = new Intent(WorkoutPage.this, WorkoutCore.class);
                startActivity(intent6);
            }
        });
        legtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent7 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent7);
            }
        });
        powertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent8 = new Intent(WorkoutPage.this, WorkoutCore.class);
                startActivity(intent8);
            }
        });
        cardiotxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent9 = new Intent(WorkoutPage.this, WorkoutCore.class);
                startActivity(intent9);
            }
        });
        customizetxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent10 = new Intent(WorkoutPage.this, WorkoutCore.class);
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
        shoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent13 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent13);
            }
        });
        arm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent14 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent14);
            }
        });
        chest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent15 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent15);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent16 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent16);
            }
        });
        leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent17 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent17);
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent18 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent18);
            }
        });
        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent19 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent19);
            }
        });
        customize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent20 = new Intent(WorkoutPage.this,WorkoutCore.class);
                startActivity(intent20);
            }
        });

        fullbodytxt.startAnimation(bttone);
        coretxt.startAnimation(bttone);
        shouldertxt.startAnimation(bttone);
        armtxt.startAnimation(bttone);
        chesttxt.startAnimation(bttone);
        backtxt.startAnimation(bttone);
        legtxt.startAnimation(bttone);
        powertxt.startAnimation(bttone);
        cardiotxt.startAnimation(bttone);
        customizetxt.startAnimation(bttone);
        fullbody.startAnimation(bttwo);
        core.startAnimation(bttwo);
        shoulder.startAnimation(bttwo);
        arm.startAnimation(bttwo);
        chest.startAnimation(bttwo);
        back.startAnimation(bttwo);
        leg.startAnimation(bttwo);
        power.startAnimation(bttwo);
        cardio.startAnimation(bttwo);
        customize.startAnimation(bttwo);


    }
}