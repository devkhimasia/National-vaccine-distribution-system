/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workQueue;

import business.Order;
import business.organization.WarehouseOrganization;

/**
 *
 * @author Dev
 */
public class DistributorVaccineOrder extends WorkRequest{
    private WarehouseOrganization warehouse;
    //private int total;
 private Order order;

    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
 
    public WarehouseOrganization getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseOrganization warehouse) {
        this.warehouse = warehouse;
    }
    
    
}
