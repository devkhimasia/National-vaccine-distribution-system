/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ClinicRole;

import business.Patient;
import business.VaccineDelivery;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class PatientHistoryJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientHistoryJPanel
     */
    
JPanel userProcessContainer;
Patient patient;
    public PatientHistoryJPanel(JPanel userProcessContainer, Patient patient) {
         initComponents();
         this.userProcessContainer  = userProcessContainer;
         this.patient = patient;
         populate();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public void populate(){
    DefaultTableModel dtm = (DefaultTableModel)jTable1.getModel();
    dtm.setRowCount(0);
    for(VaccineDelivery vd: patient.getHistory()){
        Object row[] = new Object[6];
        row[0] = vd.getVaccine().getName();
        row[1] = vd.getClinicName().getName();
        row[2] = vd.getAppliedBy();
        row[3] = vd.getPosition();
        row[4] = vd.getRate();
        row[5] = vd.getExtra();
        dtm.addRow(row);
    }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine", "Clinic", "Applied by", "Position", "Rate", "Extras"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 885;
        gridBagConstraints.ipady = 52;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 359, 0);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}