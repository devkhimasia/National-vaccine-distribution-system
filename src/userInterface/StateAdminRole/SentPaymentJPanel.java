/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.StateAdminRole;

import userInterface.cdcRole.*;
import business.enterprise.Enterprise;
import business.userAccount.UserAccount;
import business.workQueue.InjectVaccine;
import business.workQueue.PaymentRequest;
import business.workQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class SentPaymentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SentPaymentJPanel
     */
    JPanel userProcessContainer;
    UserAccount ua;
    Enterprise o;

    public SentPaymentJPanel(JPanel userProcessContainer, Enterprise o) {
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
                if(pr.getStatus()=="Bill Paid"){
                    Object row[] = new Object[7];
                      row[0] = pr;
                    row[1] = pr.getOrder().getOrder().get(0).getProduct();
                    row[2]= pr.getOrder().getOrder().get(0).getQuantity();
                    row[3] = pr.getRequestDate();
                    row[4] = pr.getOrder().getTotalAmount();
                    //row[5] = pr.getP().getValidTill();
                    row[5] = pr.getSender();
                    row[6] = pr.getResolveDate();
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Vaccine", "Qty", "Invoice Date", "Total Amount", "To", "Payment Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 693;
        gridBagConstraints.ipady = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(77, 10, 238, 10);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}