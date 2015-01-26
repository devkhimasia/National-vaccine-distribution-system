/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.network;

import business.enterprise.EnterpriseDirectory;
import java.util.ArrayList;


/**
 *
 * @author Dev
 */
public  class Network {
    
   private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private ArrayList<Network> stateList;
    public Network() {
        stateList = new ArrayList<>();
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Network> getStateList() {
        return stateList;
    }

    public void setStateList(ArrayList<Network> stateList) {
        this.stateList = stateList;
    }

   
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    @Override
    public String toString() {
        return name;
    }

    

    
}
