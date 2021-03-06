/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.InsuranceRole;

import business.enterprise.Enterprise;
import business.organization.InsuranceOrganization;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Dev
 */
public class PaymentsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PaymentsJPanel
     */
    JPanel userProcessContainer;
    InsuranceOrganization o;
    public PaymentsJPanel(JPanel userProcessContainer,   InsuranceOrganization o) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.o=o;
        
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Outgoing Payments");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 88;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(97, 115, 0, 115);
        add(jButton1, gridBagConstraints);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sent Payments");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 115, 121, 115);
        add(jButton2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         OutgoingPaymentJPanel h= new OutgoingPaymentJPanel(userProcessContainer,o);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("OutgoingPaymentJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SentPaymentJPanel h= new SentPaymentJPanel(userProcessContainer,o);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("SentPaymentJPanelDis",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
