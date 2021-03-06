/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ManufactureRole;

import business.organization.ManufactureOrganization;
import business.userAccount.UserAccount;
import business.workQueue.PaymentRequest;
import business.workQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userInterface.DistributorRole.*;

/**
 *
 * @author Dev
 */
public class IncomingPaymentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form IncomingPaymentJPanel
     */
        JPanel userProcessContainer;
    UserAccount ua;
    ManufactureOrganization o;

    public IncomingPaymentJPanel(JPanel userProcessContainer, ManufactureOrganization o) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.o=o;
        populate();
    }
public void populate() {
        DefaultTableModel dtm  =(DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        for(WorkRequest wr: o.getWorkQueue().getWorkRequestList()){
            if(wr instanceof PaymentRequest){
                PaymentRequest pr= (PaymentRequest)wr;
                if(pr.getStatus()=="Invoice Sent to Distributor" || pr.getStatus()=="Invoice Sent to CDC"){
                    Object row[] = new Object[5];
                    row[0] = pr;
                    row[1] = pr.getOrder();
                    row[2] = pr.getRequestDate();
                    row[3] = pr.getOrder().getTotalAmount();
                    row[4] = pr.getReceiver();
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
                "Request ID", "Order ID", "Invoice Date", "Total Amount", "From"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 79;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(49, 10, 145, 10);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
