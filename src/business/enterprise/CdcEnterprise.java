/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.enterprise;

import business.Order;
import business.Patient;
import business.role.Role;
import business.workQueue.ClinicOrderRequest;
import java.util.ArrayList;

/**
 *
 * @author Dev
 */
public class CdcEnterprise extends Enterprise{
    private ArrayList<ClinicOrderRequest> masterOrderList;
    private ArrayList<Patient> patientList;
    public CdcEnterprise(String name) {
        super(name, EnterpriseType.Cdc);
        masterOrderList = new ArrayList<>();
        patientList = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
    }

    public ArrayList<ClinicOrderRequest> getMasterOrderList() {
        return masterOrderList;
    }

    public void setMasterOrderList(ArrayList<ClinicOrderRequest> masterOrderList) {
        this.masterOrderList = masterOrderList;
    }

    

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
