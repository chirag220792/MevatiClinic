package com.rookiesoft.mevaticlinic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rookiesoft.mevaticlinic.ItemClickListener;
import com.rookiesoft.mevaticlinic.Model.Patient;
import com.rookiesoft.mevaticlinic.PatientTrackerActivity;
import com.rookiesoft.mevaticlinic.R;
import com.rookiesoft.mevaticlinic.ViewHolder.PatientViewHolder;

import java.util.ArrayList;

public class PatientAdapter extends RecyclerView.Adapter<PatientViewHolder> {


    Context c;
    ArrayList<Patient> models; //this array list create a list of array which parameters define in our model class

    //now create a parameterized constructor

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_patient_list, null);  //this line inflate our row
        return new PatientViewHolder(view);  //this will return our view to holder class
    }

    @Override
    public void onBindViewHolder(@NonNull final PatientViewHolder patientViewHolder, int i) {

        patientViewHolder.mPatientName.setText(models.get(i).getPatientName());
        //patientViewHolder.mPatientMobile.setText(models.get(i).getPatientMobile());
        //resource folder which is drawable

        patientViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                try{
                    String gPatientName = models.get(position).getPatientName();

                //String gPatientMobile = models.get(position).getPatientMobile();    // these object get our data from previous activity
                String gPatientID = models.get(position).getPatientId();


                //get our data with intent
                Intent intent = new Intent(v.getContext(), PatientTrackerActivity.class);
                intent.putExtra("iPatientId", gPatientID);
                intent.putExtra("iPatientName", gPatientName);
                //intent.putExtra("iPatientMobile", gPatientMobile);
                c.startActivity(intent);}
                catch (Exception e){
                    e.printStackTrace();
                }
             }
        });
    }

    @Override
    public int getItemCount() {

        return models.size();
    }
}
