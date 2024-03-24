package edu.my.fyp_2102623.Profile;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.my.fyp_2102623.MainActivity;
import edu.my.fyp_2102623.Social.Post;
import edu.my.fyp_2102623.Social.PostFactory;
import edu.my.fyp_2102623.Social.RecycleFeedAdapter;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.fitness.FitnessOptions;
import com.google.android.gms.fitness.data.DataType;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import edu.my.fyp_2102623.R;

public class UserProfile extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    private String email;
    private FitnessOptions fitnessOptions;
    private final int REQUEST_OAUTH_REQUEST_CODE = 1;
    private StorageReference mStorage;
    ArrayList<Post> followingPosts = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mStorage = FirebaseStorage.getInstance().getReference();
        email = Objects.requireNonNull(mAuth.getCurrentUser()).getEmail();


        // Initialize Google Fit API FitnessOptions
        fitnessOptions = FitnessOptions.builder()
                .addDataType(DataType.TYPE_STEP_COUNT_DELTA, FitnessOptions.ACCESS_READ)
                .build();

        TextView nameText = findViewById(R.id.nameText);
        ImageView profilePic = findViewById(R.id.profilePicture);
        ImageView logout = findViewById(R.id.logoutIcon);
        RecyclerView followingFeed = findViewById(R.id.followingFeed);

        fetchUserData(nameText, profilePic);
        handleLogout(logout);
        populateFollowingFeed(followingFeed);
        connectGoogleFit();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_user_profile, container, false);
    }

    private void fetchUserData(TextView nameText, ImageView profilePic) {
        // Existing code to fetch user's name and profile picture from Firebase
    }

    private void handleLogout(ImageView logout) {
        logout.setOnClickListener(v -> {
            mAuth.signOut();
            startActivity(new Intent(this, MainActivity.class));
        });
    }

    private void populateFollowingFeed(RecyclerView followingFeed) {
        // Existing code to populate the following feed
    }

    private void connectGoogleFit() {
        if (!GoogleSignIn.hasPermissions(GoogleSignIn.getLastSignedInAccount(this), fitnessOptions)) {
            GoogleSignIn.requestPermissions(this, REQUEST_OAUTH_REQUEST_CODE, GoogleSignIn.getLastSignedInAccount(this), fitnessOptions);
        } else {
            accessGoogleFit();
        }
    }

    private void accessGoogleFit() {
        // Method to access Google Fit data
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_OAUTH_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                accessGoogleFit();
            }
        }
    }
}