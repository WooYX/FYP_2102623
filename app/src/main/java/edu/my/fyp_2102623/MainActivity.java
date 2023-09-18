package edu.my.fyp_2102623;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Animation animimpage, bttone, bttwo, btthree, ltr;
    ImageView workout, motivations, group,hearticon,stepicon,burnedicon,Stairsicon;
    TextView startworkout, startmotivate, startgroup, PersonalInfo, welcomeMssg;

    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_Open, R.string.menu_close);
        //load animation
        animimpage = AnimationUtils.loadAnimation(this, R.anim.animimpage);
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        ltr = AnimationUtils.loadAnimation(this, R.anim.ltr);


        hearticon= (ImageView) findViewById(R.id.hearticon);
        stepicon= (ImageView) findViewById(R.id.stepicon);
        burnedicon= (ImageView) findViewById(R.id.burnedicon);
        Stairsicon= (ImageView) findViewById(R.id.Stairsicon);
        workout = (ImageView) findViewById(R.id.workout);
        motivations = (ImageView) findViewById(R.id.motivations);
        group = (ImageView) findViewById(R.id.group);
        PersonalInfo = (TextView) findViewById(R.id.PersonalInfo);
        startworkout = (TextView) findViewById(R.id.startworkout);
        startmotivate = (TextView) findViewById(R.id.startmotivate);
        startgroup = (TextView) findViewById(R.id.startgroup);
        welcomeMssg = (TextView) findViewById(R.id.welcomeMssg);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent1);
                        Log.i("MENU_DRAWER_TAG", "Home item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_workout:
                        Intent intent2 = new Intent(MainActivity.this, WorkoutPage.class);
                        startActivity(intent2);
                        Log.i("MENU_DRAWER_TAG", "Workout item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_Info:
                        Intent intent3 = new Intent(MainActivity.this, PersonalInfo.class);
                        startActivity(intent3);
                        Log.i("MENU_DRAWER_TAG", "Info item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_Motive:
                        Intent intent4 = new Intent(MainActivity.this, Motivational.class);
                        startActivity(intent4);
                        Log.i("MENU_DRAWER_TAG", "Motive item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_GnS:
                        Intent intent5 = new Intent(MainActivity.this, SNG.class);
                        startActivity(intent5);
                        Log.i("MENU_DRAWER_TAG", "Group item is clicked");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent6 = new Intent(MainActivity.this, WorkoutPage.class);
                startActivity(intent6);
            }
        });
        startworkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent7 = new Intent(MainActivity.this, WorkoutPage.class);
                startActivity(intent7);
            }
        });
        motivations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent8 = new Intent(MainActivity.this, Motivational.class);
                startActivity(intent8);
            }
        });
        startmotivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent9 = new Intent(MainActivity.this, Motivational.class);
                startActivity(intent9);
            }
        });
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent10 = new Intent(MainActivity.this, SNG.class);
                startActivity(intent10);
            }
        });
        startgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent11 = new Intent(MainActivity.this, SNG.class);
                startActivity(intent11);
            }
        });
        PersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and start the intent to navigate to WorkoutFullBody activity
                Intent intent12 = new Intent(MainActivity.this, PersonalInfo.class);
                startActivity(intent12);
            }
        });

        //export animation
        welcomeMssg.startAnimation(bttone);
        group.startAnimation(bttwo);
        motivations.startAnimation(bttwo);
        workout.startAnimation(bttwo);
        hearticon.startAnimation(bttwo);
        stepicon.startAnimation(bttwo);
        burnedicon.startAnimation(bttwo);
        Stairsicon.startAnimation(bttwo);
        PersonalInfo.startAnimation(btthree);
        startgroup.startAnimation(btthree);
        startmotivate.startAnimation(btthree);
        startworkout.startAnimation(btthree);




    }

}