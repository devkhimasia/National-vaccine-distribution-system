/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.inventory;

import business.Vaccine;
import java.util.Date;

/**
 *
 * @author Dev
 */
public class InventoryItem {
    private Vaccine vaccine;
    private int quantity;
    private Date expiry;
    private int tempQuantity=0;
    public Vaccine getVaccine() {
        return vaccine;
    }

    public int getTempQuantity() {
        return tempQuantity;
    }

    public void setTempQuantity(int tempQuantity) {
        this.tempQuantity = tempQuantity;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    @Override
    public String toString() {
        return String.valueOf(vaccine);
    }
    
}
