/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DistributorRole;

import business.organization.DistributorOrganization;
import business.organization.Organization;
import business.organization.ProviderOrganization;
import business.workQueue.ClinicOrderRequest;
import business.workQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class ManageDistributorOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageClinicOrderJPanel
     */
    JPanel userProcessContainer;
    DistributorOrganization o;

    public ManageDistributorOrderJPanel(JPanel userProcessContainer, DistributorOrganization o) {
        initComponents(); //To change body of generated methods, choose Tools | Templates.
        this.userProcessContainer = userProcessContainer;
        this.o = o;
        populate();
    }

    public void populate() {
        DefaultTableModel dtm = (DefaultTableModel) tblClinicOrders.getModel();
        dtm.setRowCount(0);

        for (WorkRequest w : o.getWorkQueue().getWorkRequestList()) {
            if (w instanceof ClinicOrderRequest) {
                ClinicOrderRequest c = (ClinicOrderRequest) w;
                if (c.getStatus() == "Forwarded to Distributor") {
                    Object row[] = new Object[3];
                    row[0] = c;
                    row[1] = c.getSender().getName();
                    row[2] = c.getOrder().getTimestamp();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClinicOrders = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        tblClinicOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order ID", "Site name", "Ordrer Date"
            }
        ));
        jScrollPane1.setViewportView(tblClinicOrders);

        jButton1.setText("View Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int s = tblClinicOrders.getSelectedRow();
        if (s < 0) {
            return;
        } else {
            ClinicOrderRequest cor = (ClinicOrderRequest) tblClinicOrders.getValueAt(s, 0);
            ViewOrderJPanel h = new ViewOrderJPanel(userProcessContainer, cor, o);
            CardLayout l = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("ShipmentRequestJPanel", h);
            l.next(userProcessContainer);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClinicOrders;
    // End of variables declaration//GEN-END:variables
}
