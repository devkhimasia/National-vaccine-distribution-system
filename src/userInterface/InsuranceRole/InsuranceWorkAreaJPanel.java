/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.InsuranceRole;

import business.organization.InsuranceOrganization;
import business.organization.Organization;
import business.userAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Dev
 */
public class InsuranceWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form InsuranceWorkAreaJPanel
     */
   JPanel userProcessContainer;
   UserAccount account;
   Organization organization;
    public InsuranceWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        
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

        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jButton2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton2.setText("Payments");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 96;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(119, 195, 272, 198);
        add(jButton2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PaymentsJPanel h= new PaymentsJPanel(userProcessContainer, (InsuranceOrganization) organization);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("SentPaymentJPanelDis",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
