/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.organization;

import business.organization.Organization.Type;
import java.util.ArrayList;




/**
 *
 * @author Dev
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(String name,Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Clinic.getValue())){
            //organization = new ClinicOrganization(name);
            organizationList.add(organization);
        }
         if (type.getValue().equals(Type.Hospital.getValue())){
            organization = new HospitalOrganization(name);
            organizationList.add(organization);
        }
        return organization;
    }
}