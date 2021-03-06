/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.cdcRole;

import business.enterprise.Enterprise;
import business.userAccount.UserAccount;
import business.workQueue.InjectVaccine;
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
    Enterprise o;

    public OutgoingPaymentJPanel(JPanel userProcessContainer, Enterprise o) {
        initComponents();
        this.userProcessContainer = userProcessContainer;

        this.o = o;
        populate();
        populate2();
    }

    public void populate() {
        DefaultTableModel dtm  =(DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        for(WorkRequest wr: o.getWorkQueue().getWorkRequestList()){
            if(wr instanceof PaymentRequest){
                PaymentRequest pr= (PaymentRequest)wr;
                if(pr.getStatus()=="Invoice Sent to CDC"){
                    Object row[] = new Object[6];
                    
                    row[0] = pr;
                    row[1] = pr.getOrder().getOrder().get(0).getProduct();
                    row[2]= pr.getOrder().getOrder().get(0).getQuantity();
                    row[3] = pr.getRequestDate();
                    row[4] = pr.getOrder().getTotalAmount();
                    row[5] = pr.getSender();
                    dtm.addRow(row);
                }
            }
        }
    }
public void populate2() {
        DefaultTableModel dtm  =(DefaultTableModel)jTable2.getModel();
        dtm.setRowCount(0);
        for(WorkRequest wr: o.getWorkQueue().getWorkRequestList()){
            if(wr instanceof InjectVaccine){
                InjectVaccine pr= (InjectVaccine)wr;
                if(pr.getStatus()=="Bill forwarded to CDC"){
                    Object row[] = new Object[6];
                    
                    row[0] = pr;
                    row[1] = pr.getVd().getVaccine().getName();
                    row[2] = pr.getRequestDate();
                    row[3] = pr.getVd().getAppliedBy();
                    row[4] = pr.getAmount();
                    row[5] = pr.getSender();
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

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jButton2.setText("Paid");
        jButton2.setBorder(new javax.swing.border.MatteBorder(null));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Vaccine", "Qty", "Invoice Date", "Total Amount", "To"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("For Funded Vaccine Orders");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Vaccine Given", "Date", "By", "Amount", "To"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Paid");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("For Funded Vaccine Injections to Patients");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(142, 142, 142)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(291, 291, 291)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(292, Short.MAX_VALUE)))
        );
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int s= jTable2.getSelectedRow();
        if(s<0){
            return;
        }
        else{
            WorkRequest wr = (WorkRequest)jTable2.getValueAt(s, 0);
            wr.setStatus("Bill Paid");
            wr.setResolveDate(new Date());
            populate();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
