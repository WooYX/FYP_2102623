package edu.my.fyp_2102623.Profile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import edu.my.fyp_2102623.MainActivity;
import edu.my.fyp_2102623.R;

public class AccountRegister extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    private static final String TAG = "EmailPassword";
    DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_account_register);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            reload();
        }
    }

    private void reload() {
    }

    public void backButton(View v) {
        finish();
    }

    /**
     * Checks fields and ensures only valid user objects are made and stored in the db
     */
    public void RegisterUser(View v) {
        EditText email = findViewById(R.id.emailreg);
        EditText pass = findViewById(R.id.passreg);
        EditText passConfirm = findViewById(R.id.passregc);
        if (email.getText().toString().length() == 0) {
            Toast.makeText(this, "Please enter an email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.getText().toString().length() == 0) {
            Toast.makeText(this, "Please enter a password!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (passConfirm.getText().toString().length() == 0) {
            Toast.makeText(this, "Please confirm your password!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pass.getText().toString().equals(passConfirm.getText().toString())) {
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
            return;
        }
        createAccount(email.getText().toString().toLowerCase(Locale.ROOT), pass.getText().toString());
    }
    private void createAccount(final String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            final FirebaseUser user = mAuth.getCurrentUser();

                            // Create a new user with email
                            Map<String, Object> userMap = new HashMap<>();
                            userMap.put("email", email);

                            // You can add more user details here
                            // userMap.put("name", "User's Name");
                            // userMap.put("createdAt", new Date());

                            // Add a new document with the user's UID as the document reference
                            db.collection("users").document(user.getUid())
                                    .set(userMap)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(TAG, "DocumentSnapshot added with ID: " + user.getUid());
                                            Toast.makeText(AccountRegister.this, "Account Creation Success, Proceed to profile creation",
                                                    Toast.LENGTH_SHORT).show();
                                            // Optionally, sign in the user automatically here or navigate to another activity
                                            startActivity(new Intent(AccountRegister.this, ProfileCreation.class));
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(TAG, "Error adding document", e);
                                            Toast.makeText(AccountRegister.this, "Error adding user to Firestore",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(AccountRegister.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                });
    }
}
