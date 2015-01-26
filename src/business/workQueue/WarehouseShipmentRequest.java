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
public class WarehouseShipmentRequest extends WorkRequest{
   private ClinicOrderRequest cor;

    public ClinicOrderRequest getCor() {
        return cor;
    }

    public void setCor(ClinicOrderRequest cor) {
        this.cor = cor;
    }
    
}
