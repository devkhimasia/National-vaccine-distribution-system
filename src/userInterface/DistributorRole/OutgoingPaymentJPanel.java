/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DistributorRole;

import business.organization.DistributorOrganization;
import business.userAccount.UserAccount;
import business.workQueue.PaymentRequest;
import business.workQueue.WorkRequest;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class OutgoingPaymentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OutgoingPaymentJPanel
     */
    JPanel userProcessContainer;
    UserAccount ua;
    DistributorOrganization o;

    public OutgoingPaymentJPanel(JPanel userProcessContainer, DistributorOrganization o) {
        initComponents();
        this.userProcessContainer = userProcessContainer;

        this.o = o;
        populate();
    }

    public void populate() {
        DefaultTableModel dtm  =(DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        for(WorkRequest wr: o.getWorkQueue().getWorkRequestList()){
            if(wr instanceof PaymentRequest){
                PaymentRequest pr= (PaymentRequest)wr;
                if(pr.getStatus()=="Invoice Sent to Distributor"){
                    Object row[] = new Object[5];
                    row[0] = pr;
                    row[1] = pr.getOrder();
                    row[2] = pr.getRequestDate();
                    row[3] = pr.getOrder().getTotalAmount();
                    row[4] = pr.getSender();
                    dtm.addRow(row);
                }
            }
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
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Order ID", "Invoice Date", "Total Amount", "To"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 79;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 74, 0, 91);
        add(jScrollPane1, gridBagConstraints);

        jButton2.setText("Paid");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 97;
        gridBagConstraints.ipady = 45;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 227, 210, 0);
        add(jButton2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int s= jTable1.getSelectedRow();
        if(s<0){
            return;
        }
        else{
            WorkRequest wr = (WorkRequest)jTable1.getValueAt(s, 0);
            wr.setStatus("Paid to Manufacturer");
            wr.setResolveDate(new Date());
            populate();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
