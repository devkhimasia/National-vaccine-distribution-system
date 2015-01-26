/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.HospitalRole;

import business.Vaccine;
import business.inventory.Inventory;
import business.organization.HospitalOrganization;
import business.workQueue.CallBack;
import business.workQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class CallBackJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CallBackJPanel
     */
    JPanel userProcessContainer;
    HospitalOrganization o;

    public CallBackJPanel(JPanel userProcessContainer, HospitalOrganization o) {
        initComponents();//To change body of generated methods, choose Tools | Templates.
        this.userProcessContainer = userProcessContainer;
        this.o = o;
        populate();
    }

    public void populate() {
        DefaultTableModel dtm  = (DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        for(WorkRequest wr: o.getWorkQueue().getWorkRequestList()){
            if(wr instanceof CallBack){
                CallBack cb = (CallBack)wr;
                Object row[] = new Object[5];
                row[0] = cb;
                row[1] = cb.getVaccine();
                row[2] = cb.getVaccine().getName();
                row[3] = cb.getDescription();
                row[4] = cb.getRequestDate();
                dtm.addRow(row);
            }
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Vaccine ID", "Vaccine", "Reason", "Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 103;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(28, 73, 0, 78);
        add(jScrollPane1, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButton1.setText("Process and Remove Inventory");
        jButton1.setBorder(new javax.swing.border.MatteBorder(null));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 86;
        gridBagConstraints.ipady = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(55, 149, 162, 0);
        add(jButton1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int s = jTable1.getSelectedRow();
        if(s<0){
            return;
        }
        else{
            Vaccine v  = (Vaccine)jTable1.getValueAt(s, 1);
            for(Inventory i : o.getInventoryCatalog().getInventoryList()){
                if(i.getVaccine().getId()==v.getId()){
                    o.getInventoryCatalog().getInventoryList().remove(i);
                    break;
                }
            }
            WorkRequest cb= (WorkRequest) jTable1.getValueAt(s, 0);
            o.getWorkQueue().getWorkRequestList().remove(cb);
            populate();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
