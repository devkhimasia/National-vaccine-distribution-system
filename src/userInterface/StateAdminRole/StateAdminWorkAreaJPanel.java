/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.StateAdminRole;

import business.enterprise.Enterprise;
import business.network.Network;
import business.userAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;


/**
 *
 * @author Dev
 */
public class StateAdminWorkAreaJPanel extends javax.swing.JPanel {

   
  
JPanel userProcessContainer;
UserAccount account;
Enterprise e;
Network n;
    public StateAdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Enterprise e, Network n) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.e= e;
        this.n=n;
        //jLabel1.setText(e.getName());
         //System.out.println(n.getName());
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

        btnAddHosp1 = new javax.swing.JButton();
        btnViewNewOrders = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        btnAddHosp1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddHosp1.setText("Manage State Provider");
        btnAddHosp1.setBorder(new javax.swing.border.MatteBorder(null));
        btnAddHosp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddHosp1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 57;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(89, 99, 0, 0);
        add(btnAddHosp1, gridBagConstraints);

        btnViewNewOrders.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnViewNewOrders.setText("View New Orders");
        btnViewNewOrders.setBorder(new javax.swing.border.MatteBorder(null));
        btnViewNewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewNewOrdersActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(90, 63, 0, 76);
        add(btnViewNewOrders, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Decision Charts");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 93;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(70, 226, 134, 0);
        add(jButton1, gridBagConstraints);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Report Emergency");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(81, 99, 0, 0);
        add(jButton2, gridBagConstraints);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Payments");
        jButton3.setBorder(new javax.swing.border.MatteBorder(null));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(83, 63, 0, 76);
        add(jButton3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddHosp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddHosp1ActionPerformed
         ManageProviderJPanel h = new ManageProviderJPanel(userProcessContainer, e);
       CardLayout l = (CardLayout) userProcessContainer.getLayout();
       userProcessContainer.add("ManageProviderJPanel",h);
       l.next(userProcessContainer);
    }//GEN-LAST:event_btnAddHosp1ActionPerformed

    private void btnViewNewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewNewOrdersActionPerformed
        ViewNewStateOrdersJPanel h = new ViewNewStateOrdersJPanel(userProcessContainer, e,n);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("HospitalJoinRequestJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_btnViewNewOrdersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DecisionChartJPanel h = new DecisionChartJPanel(userProcessContainer, e,n);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("DecisionChartJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ReportEmergency h = new ReportEmergency(userProcessContainer, e, n);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("DecisionChartJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         PaymentsJPanel h = new PaymentsJPanel(userProcessContainer, e);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("DecisionChartJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddHosp1;
    private javax.swing.JButton btnViewNewOrders;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
