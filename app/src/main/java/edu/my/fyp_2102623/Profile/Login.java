package edu.my.fyp_2102623.Profile;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

import edu.my.fyp_2102623.MainActivity;
import edu.my.fyp_2102623.R;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void toRegistration(View v) {
        Intent intent = new Intent(this, AccountRegister.class);
        startActivity(intent);
    }

    public void loginUser(View v) {
        EditText email = findViewById(R.id.firstName);
        EditText password = findViewById(R.id.pass);
        if (email.getText().toString().length() == 0) {
            Toast.makeText(this, "Please enter an email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.getText().toString().length() == 0) {
            Toast.makeText(this, "Please enter a password!", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString().trim()).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "Account not found. Please check Email and Password!", Toast.LENGTH_LONG).show();
            }
        });
    }

}