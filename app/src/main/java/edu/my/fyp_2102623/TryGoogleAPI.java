package edu.my.fyp_2102623;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.request.DataReadRequest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TryGoogleAPI extends AppCompatActivity {

    private static final int GOOGLE_FIT_PERMISSIONS_REQUEST_CODE = 1;
    private GoogleSignInClient googleSignInClient;
    private TextView tvFitnessData;
    private Button btnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_google_api);

        // Find views by their respective IDs
        Button btnSignIn = findViewById(R.id.btnSignIn);
        btnGetData = findViewById(R.id.btnGetData);
        tvFitnessData = findViewById(R.id.tvFitnessData);

        // Configure the sign-in options
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        // Build a GoogleSignInClient with the options specified above
        googleSignInClient = GoogleSignIn.getClient(this, gso);

        // Set click listener for the Sign In button
        btnSignIn.setOnClickListener(v -> {
            Intent signInIntent = googleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, GOOGLE_FIT_PERMISSIONS_REQUEST_CODE);
        });

        // Set click listener for the Get Data button
        btnGetData.setOnClickListener(v -> getFitnessData());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GOOGLE_FIT_PERMISSIONS_REQUEST_CODE && resultCode == RESULT_OK) {
            try {
                // The task completed successfully, and the user granted permission
                GoogleSignInAccount account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException.class);
                // Enable the Get Data button once the user is signed in
                btnGetData.setEnabled(true);
            } catch (ApiException e) {
                // Handle the exception
                e.printStackTrace();
            }
        }
    }

    private void getFitnessData() {
        // Define the start and end times for the data request
        Calendar calendar = Calendar.getInstance();
        Date endTime = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date startTime = calendar.getTime();

        // Use the History API to read the daily step count
        DataReadRequest readRequest = new DataReadRequest.Builder()
                .read(DataType.TYPE_STEP_COUNT_DELTA)
                .setTimeRange(startTime.getTime(), endTime.getTime(), TimeUnit.MILLISECONDS)
                .build();

        // Call the API and process the response
        Fitness.getHistoryClient(this, GoogleSignIn.getLastSignedInAccount(this))
                .readData(readRequest)
                .addOnSuccessListener(dataReadResponse -> {
                    // Process the data here, e.g., iterate through the datasets and data points
                    StringBuilder fitnessData = new StringBuilder();
                    for (DataSet dataSet : dataReadResponse.getDataSets()) {
                        for (DataPoint dataPoint : dataSet.getDataPoints()) {
                            // Extract the step count data
                            int steps = dataPoint.getValue(Field.FIELD_STEPS).asInt();
                            fitnessData.append("Steps: ").append(steps).append("\n");
                        }
                    }
                    // Display the fitness data in the TextView
                    tvFitnessData.setText(fitnessData.toString());
                })
                .addOnFailureListener(e -> {
                    // Handle any errors that occurred during the API call
                    e.printStackTrace();
                });
    }
}
