/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.HospitalRole;

import business.organization.HospitalOrganization;
import business.workQueue.InjectVaccine;
import business.workQueue.PaymentRequest;
import business.workQueue.WorkRequest;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class ReceivedPaymentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReceivedPaymentJPanel
     */
    
JPanel userProcessContainer;
HospitalOrganization o;
    public ReceivedPaymentJPanel(JPanel userProcessContainer, HospitalOrganization o) {
        initComponents();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.userProcessContainer = userProcessContainer;
        this.o=o;
        populate();
         populate2();
    }
public void populate() {
        DefaultTableModel dtm  =(DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
        for(WorkRequest wr: o.getWorkQueue().getWorkRequestList()){
            if(wr instanceof PaymentRequest){
                PaymentRequest pr= (PaymentRequest)wr;
                if(pr.getStatus()=="Bill Paid"){
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


public void populate2() {
        DefaultTableModel dtm  =(DefaultTableModel)jTable2.getModel();
        dtm.setRowCount(0);
        for(WorkRequest wr: o.getWorkQueue().getWorkRequestList()){
            if(wr instanceof InjectVaccine){
                InjectVaccine pr= (InjectVaccine)wr;
                if(pr.getStatus()=="Bill Paid"){
                    Object row[] = new Object[7];
                    row[0] = pr;
                    row[1] = pr.getVd().getVaccine().getName();
                    row[2] = pr.getRequestDate();
                    row[3] = pr.getVd().getAppliedBy();
                    row[4] = pr.getVd().getRate();
                    row[5] = pr.getReceiver();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Order ID", "Invoice Date", "Total Amount", "From", "Payment Date"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 654;
        gridBagConstraints.ipady = 79;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 38, 55, 20);
        add(jScrollPane1, gridBagConstraints);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Vaccine Given", "Date", "By", "Amount", "From", "Payment Date"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 642;
        gridBagConstraints.ipady = 79;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 38, 0, 0);
        add(jScrollPane2, gridBagConstraints);

        jLabel1.setText("From Emergencies");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(58, 80, 0, 0);
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("From Vaccines given");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 68;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 77, 0, 0);
        add(jLabel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
