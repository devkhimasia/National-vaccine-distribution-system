/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workQueue;

import business.Vaccine;
import business.organization.ProviderOrganization;

/**
 *
 * @author Dev
 */
public class EmergencyREquest extends WorkRequest{
    private ProviderOrganization provider;
    private int quantity;
    private Vaccine vaccine;

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
    
    public ProviderOrganization getProvider() {
        return provider;
    }

    public void setProvider(ProviderOrganization provider) {
        this.provider = provider;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
