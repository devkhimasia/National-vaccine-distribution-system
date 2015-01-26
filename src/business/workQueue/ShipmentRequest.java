/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workQueue;

/**
 *
 * @author Dev
 */
public class ShipmentRequest extends WorkRequest{
    private DistributorVaccineOrder dvo;
    public DistributorVaccineOrder getDvo() {
        return dvo;
    }

    public void setDvo(DistributorVaccineOrder dvo) {
        this.dvo = dvo;
    }
    
}
