package edu.my.fyp_2102623.Profile;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import edu.my.fyp_2102623.MainActivity;
import edu.my.fyp_2102623.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ProfileCreation extends AppCompatActivity {
    FirebaseFirestore db;
    FirebaseAuth mAuth;
    Uri mImageUri;
    StorageReference storRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_creation);
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mAuth.getCurrentUser();
        storRef = FirebaseStorage.getInstance().getReference("pfpImages/" + user.toString());
        SeekBar seek = findViewById(R.id.ageBar);
        TextView age = findViewById(R.id.ageView);
        // Making it so Age Bar Changes displayed numerical value as User decides age
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                age.setText("Age " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        Toast.makeText(ProfileCreation.this, "Add a Profile Picture", Toast.LENGTH_SHORT).show();
        Intent intent = getIntent();
    }

    /**
     * Stores all MetaData for the user in the Firestore Database
     */
    public void createAccount(View v) {
        EditText fname = findViewById(R.id.firstName);
        EditText lname = findViewById(R.id.lastName);
        EditText bio = findViewById(R.id.bio);
        RadioGroup genders = findViewById(R.id.radioGroup);
        int selected = genders.getCheckedRadioButtonId();
        // Ensuring Each Field is Actually Filled in
        if (selected == -1) {
            Toast.makeText(ProfileCreation.this, "Please enter your Gender!", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton temp = findViewById(selected);
        String gender = temp.getText().toString();

        if (fname.getText().toString().length() == 0) {
            Toast.makeText(ProfileCreation.this, "Please enter your First Name!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (lname.getText().toString().length() == 0) {
            Toast.makeText(ProfileCreation.this, "Please enter your Last Name!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (bio.getText().toString().length() == 0) {
            Toast.makeText(ProfileCreation.this, "Please enter a Bio!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (gender.length() == 0) {
            Toast.makeText(ProfileCreation.this, "Please enter your Gender!", Toast.LENGTH_SHORT).show();
        } else {
            // Storing each individual attribute since PK was imported from previous Intent
            Map<String, Object> userMap = new HashMap<>();
            final FirebaseUser user = mAuth.getCurrentUser();
            // Add a new document with the user's UID as the document reference
            SeekBar seekBar = (SeekBar) findViewById(R.id.ageBar);
            userMap.put("firstname", fname.getText().toString());
            userMap.put("lastname", lname.getText().toString());
            userMap.put("bio", bio.getText().toString());
            userMap.put("gender", gender);
            userMap.put("age", seekBar.getProgress());
            userMap.put("messages", new HashMap<>());
            db.collection("users").document(user.getUid())
                    .set(userMap, SetOptions.merge());

            if (mImageUri != null) {
                storRef.putFile(mImageUri).addOnCompleteListener(task ->
                        Toast.makeText(ProfileCreation.this, "Image Successfully Uploaded!", Toast.LENGTH_SHORT).show());
            }

            Toast.makeText(ProfileCreation.this, "Your Profile has been Created!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ProfileCreation.this, MainActivity.class));
        }
    }

    public void uploadProfilePic(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView pfp = findViewById(R.id.pfp);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            mImageUri = data.getData();
            pfp.setImageURI(mImageUri);
        }
    }
}
