package com.example.tracker.beans;

import javax.persistence.*;

@Entity
@Table()
public class sampleDetails {
    @Id
    private String sample_id;
    @ManyToOne
    private patientDetails pd;
    private String remarks;
    private String specimen;
    private String test;
    private String fixative;
    private Integer quantity;
    private Integer lastUpdatedStation=1;

    public sampleDetails(String sample_id, patientDetails pd, String remarks, String specimen, String test, String fixative, Integer quantity, Integer lastUpdatedStation) {
        this.sample_id = sample_id;
        this.pd = pd;
        this.remarks = remarks;
        this.specimen = specimen;
        this.test = test;
        this.fixative = fixative;
        this.quantity = quantity;
        this.lastUpdatedStation = lastUpdatedStation;
    }

    public sampleDetails() {

    }

    public Integer getLastUpdatedStation() {
        return lastUpdatedStation;
    }

    public void setLastUpdatedStation(Integer lastUpdatedStation) {
        this.lastUpdatedStation = lastUpdatedStation;
    }

    public String getSample_id() {
        return sample_id;
    }

    public void setSample_id(String sample_id) {
        this.sample_id = sample_id;
    }

    public patientDetails getPd() {
        return pd;
    }

    public void setPd(patientDetails pd) {
        this.pd = pd;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getFixative() {
        return fixative;
    }

    public void setFixative(String fixative) {
        this.fixative = fixative;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "sampleDetails{" +
                "sample_id='" + sample_id + '\'' +
                ", pd=" + pd +
                ", remarks='" + remarks + '\'' +
                ", specimen='" + specimen + '\'' +
                ", test='" + test + '\'' +
                ", fixative='" + fixative + '\'' +
                ", quantity=" + quantity +
                ", lastUpdatedStation=" + lastUpdatedStation +
                '}';
    }
}
