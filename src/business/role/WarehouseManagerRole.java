/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.DB40Util.DB4OUtil;
import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.DistributorOrganization;
import business.organization.Organization;
import business.organization.WarehouseOrganization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.WarehouseRole.WarehouseManagerWorkAreaJPanel;

/**
 *
 * @author Dev
 */
public class WarehouseManagerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system, Network network, Organization parentOrg, Enterprise parentEnt) {
        return new WarehouseManagerWorkAreaJPanel(userProcessContainer, account, (WarehouseOrganization)organization,(DistributorOrganization) parentOrg);
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
