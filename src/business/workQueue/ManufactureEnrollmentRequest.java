/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.workQueue;

import business.organization.ManufactureOrganization;

/**
 *
 * @author Dev
 */
public class ManufactureEnrollmentRequest extends WorkRequest{
    private ManufactureOrganization manufacturer;

    public ManufactureOrganization getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufactureOrganization manufacturer) {
        this.manufacturer = manufacturer;
    }
    
}
