/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workQueue;

import business.Vaccine;

/**
 *
 * @author Dev
 */
public class CallBack extends WorkRequest{
    private Vaccine vaccine;
    private String description;
   
    public Vaccine getVaccine() {
        return vaccine;
    }

   

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
