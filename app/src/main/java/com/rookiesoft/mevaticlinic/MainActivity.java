package com.rookiesoft.mevaticlinic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rookiesoft.mevaticlinic.Model.Patient;
import com.rookiesoft.mevaticlinic.ViewHolder.PatientViewHolder;

public class MainActivity extends AppCompatActivity {

    public static final String PATIENT_NAME = "patientname";
    public static final String PATIENT_ID = "patientid";

    private FloatingActionButton fABAddPatient;
    private RecyclerView mRecyclerView;

    SwipeRefreshLayout swipeRefreshLayout;

    //PatientAdapter mPateintAdapter;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    FirebaseRecyclerAdapter<Patient, PatientViewHolder> firebaseRecyclerAdapter;
    FirebaseRecyclerOptions<Patient> options;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        mRecyclerView = findViewById(R.id.recyclerViewPatient);
        fABAddPatient = findViewById(R.id.floatingActionButton);
        fABAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentAddPatient = new Intent(MainActivity.this, AddPatientActivity.class);
                startActivity(intentAddPatient);

                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("patient");

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        showPatient();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                firebaseRecyclerAdapter.startListening();
                firebaseRecyclerAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);

            }
        });
    }

    private void showPatient() {

        options = new FirebaseRecyclerOptions.Builder<Patient>()
                .setQuery(mDatabaseReference, Patient.class)
                .build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Patient, PatientViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull PatientViewHolder patientViewHolder, int i, @NonNull Patient patient) {
                patientViewHolder.mPatientName.setText(patient.getPatientName());
                patientViewHolder.mPatientMobile.setText(patient.getPatientMobile());
            }

            @NonNull
            @Override
            public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View itemView = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.layout_patient_list, viewGroup, false);
                return new PatientViewHolder(itemView);
            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(firebaseRecyclerAdapter != null){
            firebaseRecyclerAdapter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseRecyclerAdapter.startListening();
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getTitle().equals("Update")){
            showUpdateDialog(firebaseRecyclerAdapter.getRef(item.getOrder()).getKey(), firebaseRecyclerAdapter.getItem(item.getOrder()));
        }else if(item.getTitle().equals("Delete")){
            deleteTask(firebaseRecyclerAdapter.getRef(item.getOrder()).getKey());
        }
        return super.onContextItemSelected(item);
    }

    private void deleteTask(String key) {
    }

    private void showUpdateDialog(String key, Patient item) {
    }
}