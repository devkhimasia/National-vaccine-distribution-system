/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.role;

import business.DB40Util.DB4OUtil;
import business.EcoSystem;
import business.enterprise.CdcEnterprise;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.DistributorOrganization;
import business.organization.ManufactureOrganization;
import business.organization.Organization;
import business.userAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.ManufactureRole.ManufactureWorkAreaJPanel;

/**
 *
 * @author Dev
 */
public class ManufactureRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system, Network network, Organization parentOrg, Enterprise parentEnt) {
        return new ManufactureWorkAreaJPanel(userProcessContainer, account, (ManufactureOrganization) organization, (DistributorOrganization)parentOrg, (CdcEnterprise) enterprise);
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
