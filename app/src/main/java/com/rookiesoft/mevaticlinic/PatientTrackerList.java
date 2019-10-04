package com.rookiesoft.mevaticlinic;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PatientTrackerList extends ArrayAdapter<PatientTracker> {
    private Activity context;
    List<PatientTracker> patientTrackers;

    public PatientTrackerList(Activity context, List<PatientTracker> patientTrackers){
        super(context, R.layout.layout_patientrecord_list, patientTrackers);
        this.context = context;
        this.patientTrackers = patientTrackers;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.layout_patientrecord_list, null, true);

        TextView textViewListMedicalDescription = (TextView) listViewItem.findViewById(R.id.textViewListMedicalDescription);
        TextView textViewListCost = (TextView) listViewItem.findViewById(R.id.textViewListCost);
        TextView textViewListDateTime = (TextView) listViewItem.findViewById(R.id.textViewPatientVisitedDate);

        PatientTracker patientTracker = patientTrackers.get(position);

        textViewListMedicalDescription.setText(patientTracker.getPatienttrackerName());
        textViewListCost.setText(String.valueOf(patientTracker.getPatienttrackerCost()));
        textViewListDateTime.setText(String.valueOf(patientTracker.getPatientDateTime()));

        return listViewItem;
    }
}
