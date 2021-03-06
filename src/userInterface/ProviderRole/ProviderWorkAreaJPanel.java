/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ProviderRole;

import business.enterprise.Enterprise;
import business.inventory.Inventory;
import business.organization.ProviderOrganization;
import business.userAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Dev
 */
public class ProviderWorkAreaJPanel extends javax.swing.JPanel {

   JPanel userProcessContainer;
   UserAccount account;
   ProviderOrganization providerOrganization;
   Enterprise e;
   
    public ProviderWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ProviderOrganization providerOrganization, Enterprise e) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.e=e;
        this.providerOrganization = providerOrganization;
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnAddHosp = new javax.swing.JButton();
        btnViewNewOrders = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        btnAddHosp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddHosp.setText("Hospital Join Requests");
        btnAddHosp.setBorder(new javax.swing.border.MatteBorder(null));
        btnAddHosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHospActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(81, 122, 0, 136);
        add(btnAddHosp, gridBagConstraints);

        btnViewNewOrders.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnViewNewOrders.setText("View New Orders");
        btnViewNewOrders.setBorder(new javax.swing.border.MatteBorder(null));
        btnViewNewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewNewOrdersActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 95;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 122, 0, 136);
        add(btnViewNewOrders, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Inventory");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 137;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 122, 0, 136);
        add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Distribute");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 139;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 122, 137, 136);
        add(jButton2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddHospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHospActionPerformed
        HospitalJoinRequestJPanel h = new HospitalJoinRequestJPanel(userProcessContainer, providerOrganization,e);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("Add Hosp",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_btnAddHospActionPerformed

    private void btnViewNewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewNewOrdersActionPerformed
        ViewNewOrdersJPanel h = new ViewNewOrdersJPanel(userProcessContainer, providerOrganization,e);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("HospitalJoinRequestJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_btnViewNewOrdersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InventoryListJPanel h = new InventoryListJPanel(userProcessContainer, providerOrganization);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("HospitalJoinRequestJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DistributeVaccine h = new DistributeVaccine(userProcessContainer, providerOrganization,e);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("HospitalJoinRequestJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHosp;
    private javax.swing.JButton btnViewNewOrders;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
