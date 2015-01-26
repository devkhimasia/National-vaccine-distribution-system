/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.organization.ProviderOrganization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.ProviderRole.ProviderWorkAreaJPanel;

/**
 *
 * @author Dev
 */
public class ProviderRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system, Network network, Organization parentOrg, Enterprise parentEnt) {
        return new ProviderWorkAreaJPanel(userProcessContainer, account, (ProviderOrganization) organization,  enterprise); //To change body of generated methods, choose Tools | Templates.
    }
    
}
