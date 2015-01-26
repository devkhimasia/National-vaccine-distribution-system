/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.network.Network;
import business.organization.Organization;
import business.role.Role;
import business.role.SystemAdminRole;
import java.util.ArrayList;
import business.role.Role;


/**
 *
 * @author Dev
 */
public class EcoSystem extends Organization {
    private static EcoSystem business;
    private ArrayList<Network> networkList;
   
    
    public static EcoSystem getInstance(){
        if(business == null){
            business = new EcoSystem();
        }
        return business;
    }
    
    private EcoSystem(){
        super(null);
        networkList = new ArrayList<>();
       
    }

   
    

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<Role>();
       roles.add(new SystemAdminRole());
       return roles;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
     
}
