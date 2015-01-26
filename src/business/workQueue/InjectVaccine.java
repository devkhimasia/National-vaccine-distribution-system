/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workQueue;

import business.Patient;
import business.VaccineDelivery;

/**
 *
 * @author Dev
 */
public class InjectVaccine extends WorkRequest{
    private VaccineDelivery vd;
    private Patient p;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public VaccineDelivery getVd() {
        return vd;
    }

    public void setVd(VaccineDelivery vd) {
        this.vd = vd;
    }

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }
    
}
