package com.rookiesoft.mevaticlinic;

import com.google.firebase.database.IgnoreExtraProperties;
//import com.google.firebase.database.Server

import java.time.LocalDateTime;
import java.util.Date;
@IgnoreExtraProperties
public class PatientTracker{
        private String patienttrackerId;
        private String patienttrackerName;
        private int patienttrackerCost;
        private String patientDateTime;

    public PatientTracker() {
    }

    public PatientTracker(String patienttrackerId, String patienttrackerName, int patienttrackerCost, String patientDateTime) {
        this.patienttrackerId = patienttrackerId;
        this.patienttrackerName = patienttrackerName;
        this.patienttrackerCost = patienttrackerCost;
        this.patientDateTime = patientDateTime;
    }

    public String getPatienttrackerId() {
        return patienttrackerId;
    }

    public String getPatienttrackerName() {
        return patienttrackerName;
    }

    public int getPatienttrackerCost() {
        return patienttrackerCost;
    }

    public String getPatientDateTime(){return patientDateTime;}
}
