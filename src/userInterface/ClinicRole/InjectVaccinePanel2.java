/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ClinicRole;

import business.Patient;
import business.enterprise.CdcEnterprise;
import business.organization.ClinicOrganization;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Dev
 */
public class InjectVaccinePanel2 extends javax.swing.JPanel {

    /**
     * Creates new form InjectVaccinePanel2
     */
    JPanel userProcessContainer;
    ClinicOrganization clinicOrganization;
    CdcEnterprise e ;
    Patient patient;
    public InjectVaccinePanel2(JPanel userProcessContainer, ClinicOrganization clinicOrganization, CdcEnterprise e, Patient patient) {
       initComponents();// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       this.userProcessContainer = userProcessContainer;
       this.clinicOrganization = clinicOrganization;
       this.e=e;
       this.patient = patient;
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

        jButton1.setText("View History");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(91, 163, 0, 154);
        add(jButton1, gridBagConstraints);

        jButton2.setText("Inject Vaccine");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.ipady = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 163, 161, 154);
        add(jButton2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         InjectVaccinePanel3 cpo = new InjectVaccinePanel3(userProcessContainer, clinicOrganization, e, patient);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("InjectVaccinePanel3", cpo);
            layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       PatientHistoryJPanel cpo = new PatientHistoryJPanel(userProcessContainer, patient);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("InjectVaccinePanel3", cpo);
            layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
