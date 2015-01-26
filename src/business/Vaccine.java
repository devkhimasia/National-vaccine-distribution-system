/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.organization.ManufactureOrganization;
import java.util.Date;

/**
 *
 * @author Dev
 */
public class Vaccine {
    private String name;
    private int id;
    private String description;
    private String safetyMeasure;
   
    private String type;
    private int price;
    private int hospitalPrice;
    private int patientPrice;
    private static int count=0;
    private int sold;
    private ManufactureOrganization manufacture;
    public Vaccine(){
        count++;
        id=count;
    }

    public ManufactureOrganization getManufacture() {
        return manufacture;
    }

    public void setManufacture(ManufactureOrganization manufacture) {
        this.manufacture = manufacture;
    }

    public int getHospitalPrice() {
        return hospitalPrice;
    }

    public void setHospitalPrice(int hospitalPrice) {
        this.hospitalPrice = hospitalPrice;
    }

    public int getPatientPrice() {
        return patientPrice;
    }

    public void setPatientPrice(int patientPrice) {
        this.patientPrice = patientPrice;
    }
    
    public String getName() {
        return name;
        
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold += sold;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSafetyMeasure() {
        return safetyMeasure;
    }

    public void setSafetyMeasure(String safetyMeasure) {
        this.safetyMeasure = safetyMeasure;
    }

  

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
}
