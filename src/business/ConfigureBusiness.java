/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.person.Person;
import business.role.SystemAdminRole;
import business.userAccount.UserAccount;


/**
 *
 * @author Dev
 */
public class ConfigureBusiness {
      
    public static EcoSystem configure(){
        EcoSystem system = EcoSystem.getInstance();
      
        
        Person employee = system.getEmployeeDirectory().createEmployee("Dev");
        
        UserAccount ua  = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", 
                                                                             employee, new SystemAdminRole());
        return system;
    }
    
}
