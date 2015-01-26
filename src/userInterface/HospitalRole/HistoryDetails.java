/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.HospitalRole;

import userInterface.ClinicRole.*;
import business.Order;
import business.OrderItem;
import java.awt.CardLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

    

/**
 *
 * @author admin
 */
public class HistoryDetails extends javax.swing.JPanel {

    
    JPanel userProcessContainer;
    Order order;
    public HistoryDetails(JPanel userProcessContainer, Order order) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        populate();
    }
public void populate()
{
    Border border = null;
    if(order.getStatus()=="Forwarded to Hospital"){
    progressBar.setValue(0);
     border = BorderFactory.createTitledBorder("Forwarded to Hospital...");
    }
    else if(order.getStatus()=="Forwarded to Provider"){
    progressBar.setValue(15);
     border = BorderFactory.createTitledBorder("Forwarded to Provider...");
    }
    else if(order.getStatus()=="Forwarded to State Dept"){
    progressBar.setValue(30);
     border = BorderFactory.createTitledBorder("Forwarded to State Dept...");
    }
    else if(order.getStatus()=="Forwarded to CDC"){
    progressBar.setValue(45);
     border = BorderFactory.createTitledBorder("Forwarded to CDC...");
    }
    else if(order.getStatus()=="Forwarded to Distributor"){
    progressBar.setValue(60);
     border = BorderFactory.createTitledBorder("Forwarded to Distributor...");
    }
    else if(order.getStatus()=="Ready for Shipment"){
    progressBar.setValue(70);
     border = BorderFactory.createTitledBorder("Forwarded to Distributor...");
    }
    else if(order.getStatus()=="In Shipment"){
    progressBar.setValue(80);
     border = BorderFactory.createTitledBorder("In Shipment...");
    }
    else if(order.getStatus()=="Shipped"){
    progressBar.setValue(90);
     border = BorderFactory.createTitledBorder("Shipped...");
    }
    else if(order.getStatus()=="Completed"){
    progressBar.setValue(100);
     border = BorderFactory.createTitledBorder("Complete...");
    }
    progressBar.setStringPainted(true);
    
    progressBar.setBorder(border);
    DefaultTableModel modal = (DefaultTableModel) tblHistory.getModel();
        modal.setRowCount(0);

    for(OrderItem oi: order.getOrder()) {
               Object row[] = new Object[4];
                row[0] = oi.getProduct().getName();
                row[1] = oi.getQuantity();
                row[2] = oi.getProduct().getHospitalPrice();
               row[3] = oi.getQuantity() * oi.getProduct().getHospitalPrice();
                modal.addRow(row);
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

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHistory = new javax.swing.JTable();
        progressBar = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(77, 49, 106, 0);
        add(btnBack, gridBagConstraints);

        tblHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product", "Quantity", "Price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHistory);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 451;
        gridBagConstraints.ipady = 92;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(25, 80, 0, 60);
        add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 408;
        gridBagConstraints.ipady = 53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(59, 39, 0, 0);
        add(progressBar, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTable tblHistory;
    // End of variables declaration//GEN-END:variables
}
