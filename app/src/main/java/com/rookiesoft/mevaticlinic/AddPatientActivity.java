package com.rookiesoft.mevaticlinic;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rookiesoft.mevaticlinic.Model.Patient;

public class AddPatientActivity extends AppCompatActivity {

    EditText editTextAddPatientName, editTextAddPatientMobile, editTextAddPatientAge, editTextAddPatientAddress;
    RadioButton radioButtonMale, radioButtonFemale, radioButtonOther;
    Button buttonAddPatient;

    DatabaseReference databasePatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        ActionBar actionBar = getSupportActionBar();

        databasePatients = FirebaseDatabase.getInstance().getReference("patient");

        editTextAddPatientName = findViewById(R.id.edit_text_patientname);
        editTextAddPatientMobile = findViewById(R.id.edit_text_mobile);
        editTextAddPatientAge = findViewById(R.id.edit_text_age);
        radioButtonMale = findViewById(R.id.radioButton_Male);
        radioButtonFemale = findViewById(R.id.radioButton_Female);
        radioButtonOther = findViewById(R.id.radioButton_other);
        buttonAddPatient = findViewById(R.id.button_addPatient);
        editTextAddPatientAddress = findViewById(R.id.edit_text_address);

        buttonAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPatient();

            }
        });
    }

    private void addPatient() {
        String patientName = editTextAddPatientName.getText().toString().toUpperCase();
        String patientMobile = editTextAddPatientMobile.getText().toString().trim();
        String patientAge = editTextAddPatientAge.getText().toString().trim();

        //int patientMobile =  Integer.parseInt(editTextAddPatientMobile.getText().toString());
        //int patientAge =  Integer.parseInt(editTextAddPatientAge.getText().toString());
        String patientGender = "";
        String patientAddress = editTextAddPatientAddress.getText().toString().trim();//"Malad";//

        if (radioButtonMale.isChecked()) {
            patientGender = "Male";
        }
        if (radioButtonFemale.isChecked()) {
            patientGender = "Female";
        }
        if (radioButtonOther.isChecked()) {
            patientGender = "Other";
        }

        if(!TextUtils.isEmpty(patientName)){

            String id = databasePatients.push().getKey();

            Patient patient = new Patient(id, patientName, patientMobile, patientAge, patientGender, patientAddress);

            databasePatients.child(id).setValue(patient);

            Toast.makeText(this, "Patient Added", Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this, "You Should enter a Patient Details", Toast.LENGTH_LONG).show();
        }
    }
}
