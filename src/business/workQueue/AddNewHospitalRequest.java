/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workQueue;

import business.enterprise.Enterprise;
import business.organization.Organization;


/**
 *
 * @author Dev
 */
public class AddNewHospitalRequest extends WorkRequest {
    Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

  
    
}
