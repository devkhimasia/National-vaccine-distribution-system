/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.organization.ClinicOrganization;
import business.organization.Organization;

/**
 *
 * @author Dev
 */
public class VaccineDelivery {
    private Vaccine vaccine;
    private Organization clinicName;
    private String appliedBy;
    private String position;
    private int rate;
    private String extra;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public Organization getClinicName() {
        return clinicName;
    }

    public void setClinicName(Organization clinicName) {
        this.clinicName = clinicName;
    }

  
    public String getAppliedBy() {
        return appliedBy;
    }

    public void setAppliedBy(String appliedBy) {
        this.appliedBy = appliedBy;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
}
