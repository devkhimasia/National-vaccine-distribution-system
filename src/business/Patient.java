/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.organization.InsuranceOrganization;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Dev
 */
public class Patient {
    private String name;
    private int mobile;
    private ArrayList<VaccineDelivery> history; 
    private InsuranceOrganization insurance;
    private String insurance_id;
    private int coverageAmt;
    private int coverageLeft;
    private Date validTill;
    public Patient() {
        history = new ArrayList<>();
    }

    public int getCoverageLeft() {
        return coverageLeft;
    }

    public void setCoverageLeft(int coverageLeft) {
        this.coverageLeft = coverageLeft;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }
    
    public String getName() {
        return name;
        
    }

    public ArrayList<VaccineDelivery> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<VaccineDelivery> history) {
        this.history = history;
    }

    public InsuranceOrganization getInsurance() {
        return insurance;
    }

    public void setInsurance(InsuranceOrganization insurance) {
        this.insurance = insurance;
    }

    

    public String getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(String insurance_id) {
        this.insurance_id = insurance_id;
    }

    public int getCoverageAmt() {
        return coverageAmt;
    }

    public void setCoverageAmt(int coverageAmt) {
        this.coverageAmt = coverageAmt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    
    
}
