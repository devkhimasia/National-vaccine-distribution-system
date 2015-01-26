/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workQueue;

import business.Order;
import business.organization.HospitalOrganization;

/**
 *
 * @author Dev
 */
public class ClinicOrderRequest extends WorkRequest{
    private Order order;
    private HospitalOrganization hospOrg;
    private Order shippedOrder;

    public Order getShippedOrder() {
        return shippedOrder;
    }

    public void setShippedOrder(Order shippedOrder) {
        this.shippedOrder = shippedOrder;
    }
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public HospitalOrganization getHospOrg() {
        return hospOrg;
    }

    public void setHospOrg(HospitalOrganization hospOrg) {
        this.hospOrg = hospOrg;
    }

   
    
}
