package com.rookiesoft.mevaticlinic.Model;

public class Patient {
    private String patientId, patientName, patientGender, patientAddress, patientMobile, patientAge;
    private int pateintImage;

    public Patient(){

    }

    public Patient(String patientId, String patientName, String patientMobile, String patientAge, String patientGender, String patientAddress) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientAddress = patientAddress;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public int getPateintImage() {
        return pateintImage;
    }

    public void setPateintImage(int pateintImage) {
        this.pateintImage = pateintImage;
    }
}