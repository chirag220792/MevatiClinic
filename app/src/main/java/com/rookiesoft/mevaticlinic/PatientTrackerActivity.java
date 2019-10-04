package com.rookiesoft.mevaticlinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PatientTrackerActivity extends AppCompatActivity {

    TextView textViewPatientName,textViewPatientDate;
    EditText editTextMedicalDescription, editTextCost;

    Button buttonAddPatientTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_tracker);

        ActionBar actionBar = getSupportActionBar();

        textViewPatientName = findViewById(R.id.textViewPatientTrackerName);
        editTextMedicalDescription = findViewById(R.id.editText_PatientMedicalDescription);
        editTextCost = findViewById(R.id.editText_Cost);
        buttonAddPatientTracker = findViewById(R.id.buttonAddPatientTracker);

        textViewPatientDate = findViewById(R.id.textViewPatientVisitedDate);


        Intent intent = getIntent();

       String patientid = intent.getStringExtra("iPatientId");
       String patientname = intent.getStringExtra("iPatientName");

        actionBar.setTitle("Patient History");

        textViewPatientName.setText(patientname);

        buttonAddPatientTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

}
