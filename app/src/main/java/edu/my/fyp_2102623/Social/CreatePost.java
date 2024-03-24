package edu.my.fyp_2102623.Social;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Objects;

import edu.my.fyp_2102623.MainActivity;
import edu.my.fyp_2102623.R;
import edu.my.fyp_2102623.Social.Post;
import edu.my.fyp_2102623.Social.PostFactory;


public class CreatePost extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String selectedActivity;
    private String email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        EditText title = findViewById(R.id.createTitleSingle);
        EditText description = findViewById(R.id.createDescriptionSingle);
        EditText date = findViewById(R.id.createDateSingle);
        email = Objects.requireNonNull(mAuth.getCurrentUser()).getEmail();

        ArrayList<String> liked = new ArrayList<>();
        // Create Post Button
        Button createPost = findViewById(R.id.createPostSingle);
        createPost.setOnClickListener(view -> {
            // This is where checks will be needed and then creating the post will happen
            if (title.getText().toString().length() == 0) {
                Toast.makeText(this, "Please enter a title!", Toast.LENGTH_SHORT).show();
            } else if (description.getText().toString().length() == 0) {
                Toast.makeText(this, "Please enter a description!", Toast.LENGTH_SHORT).show();
            } else if (date.getText().toString().length() == 0) {
                Toast.makeText(this, "Please enter a date!", Toast.LENGTH_SHORT).show();
            } else {
                // Successfully create a post
                Toast.makeText(this, "Successfully created a post!", Toast.LENGTH_SHORT).show();
                PostFactory newPost = new PostFactory();
                ArrayList<String> activities = new ArrayList<>();
                activities.add(selectedActivity);
                ArrayList<String> followers = new ArrayList<>();
                // Add post to database
                db.collection("users").document(email).get().addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        ArrayList<String> posts = (ArrayList<String>) task.getResult().get("posts");
                        if (posts != null) {
                            Post post = newPost.createPost(mAuth.getCurrentUser().getEmail(), "(" + email + ", " + posts.size() + ")", title.getText().toString(), description.getText().toString(), date.getText().toString(), activities, "", followers, -1, 1, 0, liked);
                            db.collection("posts").document("(" + email + ", " + posts.size() + ")").set(post);
                            posts.add("(" + email + ", " + posts.size() + ")");
                            db.collection("users").document(email).update("posts", posts);
                        } else {
                            Post post = newPost.createPost(mAuth.getCurrentUser().getEmail(), "(" + email + ", " + 0 + ")", title.getText().toString(), description.getText().toString(), date.getText().toString(), activities, "", followers, -1, 1, 0, liked);
                            ArrayList<String> firstPost = new ArrayList<>();
                            firstPost.add("(" + email + ", " + 0 + ")");
                            db.collection("posts").document("(" + email + ", " + 0 + ")").set(post);
                            db.collection("users").document(email).update("posts", firstPost);
                        }
                    } else {
                        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                    }
                });
                // Go back to main page
                startActivity(new Intent(this, MainActivity.class));
            }
        });
    }
}
