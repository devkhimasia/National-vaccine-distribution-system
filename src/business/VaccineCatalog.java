/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Dev
 */
public class VaccineCatalog {
 ArrayList<Vaccine> vaccineList;
 VaccineCatalog(){
     vaccineList = new ArrayList<>();
 }

    public ArrayList<Vaccine> getVaccineList() {
        return vaccineList;
    }

    public void setVaccineList(ArrayList<Vaccine> vaccineList) {
        this.vaccineList = vaccineList;
    }
 public Vaccine add(){
     Vaccine v= new Vaccine();
     vaccineList.add(v);
     return v;
 }
}
