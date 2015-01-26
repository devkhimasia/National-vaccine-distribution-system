/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.Vaccine;
import business.inventory.Inventory;
import business.inventory.InventoryItem;
import business.organization.HospitalOrganization;
import business.organization.Organization;
import business.role.Role;
import business.workQueue.ClinicOrderRequest;
import java.util.ArrayList;

/**
 *
 * @author Dev
 */
public class PhdEnterprise extends Enterprise{
ArrayList<ClinicOrderRequest> masterCatalog;
//private int totalInState;
    public PhdEnterprise(String name) {
        super(name, EnterpriseType.Phd);
        masterCatalog = new ArrayList<>();
    }

    public int getTotalInState(Vaccine v) {
        int total=0;
        for(Organization o: this.getOrganizationDirectory().getOrganizationList()){
            if(o instanceof HospitalOrganization){
                for(Inventory i:o.getInventoryCatalog().getInventoryList()){
                    if(i.getVaccine().getId()==v.getId()){
                        for(InventoryItem ii: i.getInventoryItemList()){
                            total+=ii.getQuantity();
                        }
                    }
                }
            }
        }
        return total;
    }

   

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<ClinicOrderRequest> getMasterCatalog() {
        return masterCatalog;
    }

    public void setMasterCatalog(ArrayList<ClinicOrderRequest> masterCatalog) {
        this.masterCatalog = masterCatalog;
    }
    
    
}
