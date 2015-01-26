/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business;

import java.util.Date;

/**
 *
 * @author Dev
 */
public class OrderItem {
    private Vaccine vaccine;
    private int quantity;
    private Date expiryDate;

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public Vaccine getProduct() {
        return vaccine;
    }

    public void setProduct(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return vaccine.getName();
    }
    
    
}
