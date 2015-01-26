/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DistributorRole;

import business.OrderItem;
import business.inventory.Inventory;
import business.inventory.InventoryItem;
import business.organization.ClinicOrganization;
import business.organization.DistributorOrganization;
import business.organization.HospitalOrganization;
import business.organization.Organization;
import business.organization.WarehouseOrganization;
import business.workQueue.ClinicOrderRequest;
import business.workQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class ViewOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewOrderJPanel
     */
    JPanel userProcessContainer;
    ClinicOrderRequest cor;
    DistributorOrganization o;
    String address;

    ViewOrderJPanel(JPanel userProcessContainer, ClinicOrderRequest cor, DistributorOrganization o) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.cor = cor;
        this.o = o;
        if (cor.getHospOrg() == null) {
            HospitalOrganization ho = (HospitalOrganization) cor.getSender();
            address = ho.getStreet() +  ", "+ho.getCity() + ho.getState() + ", " + ho.getPin();
            txtDesc.setText(address);
        } else {
            ClinicOrganization ho = (ClinicOrganization) cor.getSender();
            address = ho.getStreet() + ", " + ho.getState() + ", " + ho.getPin();
            txtDesc.setText(address);
        }
        populate();
        populateCombo();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void populateCombo() {
        jComboBox1.removeAllItems();
        for (Organization o1 : o.getOrganizationDirectory().getOrganizationList()) {
            if (o1 instanceof WarehouseOrganization) {
                jComboBox1.addItem(o1);
            }
        }
    }

    public void populate() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        if (cor.getStatus() != "Forwarded to Warehouse") {
           // System.out.println("here i am ");

            int t1 = o.getOrganizationDirectory().getOrganizationList().size();
            for (Organization o2 : o.getOrganizationDirectory().getOrganizationList()) {
                if (o2 instanceof WarehouseOrganization) {
                    dtm.addColumn(o2.getName());
                }
            }

            for (OrderItem oi : cor.getOrder().getOrder()) {
                boolean flag = false;
                Object row[] = new Object[t1 + 3];
                row[0] = oi.getProduct();
                row[1] = oi.getProduct().getName();
                row[2] = oi.getQuantity();
                int temp = 2;
                for (Organization o2 : o.getOrganizationDirectory().getOrganizationList()) {
                    if (o2 instanceof WarehouseOrganization) {
                        temp++;
                        for (Inventory i : o2.getInventoryCatalog().getInventoryList()) {
                            if (i.getVaccine().equals(oi.getProduct())) {
                                int tempTotal = 0;
                                for (InventoryItem iii : i.getInventoryItemList()) {
                                    tempTotal += iii.getQuantity();
                                }
                                System.out.println(tempTotal);
                                System.out.println(o2.getName());
                                for (WorkRequest wr : o2.getWorkQueue().getWorkRequestList()) {
                                    ////System.out.println("s1");
                                    if (wr instanceof ClinicOrderRequest) {
                                        System.out.println("s2");
                                        ClinicOrderRequest corTemp = (ClinicOrderRequest) wr;
                                        System.out.println(corTemp.getStatus());
                                        if (corTemp.getStatus() == "Forwarded to Warehouse") {
                                            // System.out.println("s3");
                                            for (OrderItem oii : corTemp.getOrder().getOrder()) {
                                                if (oii.getProduct().equals(i.getVaccine())) {
                                                    // System.out.println("s4");
                                                    tempTotal = tempTotal - oii.getQuantity();
                                                }
                                            }
                                        }
                                    }
                                }
                                row[temp] = tempTotal;
                                //dtm.addRow(row);
                                flag = true;
                                break;
                            }

                        }
                        if (!flag) {
                            row[temp] = 0;
                            //break;
                        }
                    }

                }
                dtm.addRow(row);
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
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccine ID", "Vaccine", "Order Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 11, 832, 107));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 155, 170, 58));

        jButton1.setText("Forward");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 155, 104, 58));

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane2.setViewportView(txtDesc);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 229, 125));

        jLabel1.setText("Site Address");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 100, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 710, 30));

        jButton2.setText("Check Distance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Boolean flag = false;
        WarehouseOrganization wo = (WarehouseOrganization) jComboBox1.getSelectedItem();
        // System.out.println("now here");
        for (OrderItem oi : cor.getOrder().getOrder()) {
            flag = false;
            System.out.println(oi.getProduct().getName());
            for (Inventory i : wo.getInventoryCatalog().getInventoryList()) {
                if (i.getVaccine().equals(oi.getProduct())) {
                    System.out.println("t2");
                    int tempTotal = 0;
                    for (InventoryItem iii : i.getInventoryItemList()) {
                        tempTotal += iii.getQuantity();
                    }
                    System.out.println(tempTotal);
                    for (WorkRequest wr : wo.getWorkQueue().getWorkRequestList()) {
                        if (wr instanceof ClinicOrderRequest) {
                            ClinicOrderRequest corTemp = (ClinicOrderRequest) wr;
                            System.out.println("t3");
                            if (corTemp.getStatus() == "Forwarded to Warehouse") {
                                System.out.println("t4");
                                for (OrderItem oii : corTemp.getOrder().getOrder()) {
                                    if (oii.getProduct().equals(i.getVaccine())) {
                                        System.out.println("t5");
                                        tempTotal = tempTotal - oii.getQuantity();
                                    }
                                }
                            }
                        }
                    }
                    if (tempTotal < oi.getQuantity()) {
                        JOptionPane.showMessageDialog(null, "Cannot Process due to insufficient inventory");
                        return;
                    } else {
                        flag = true;
                        System.out.println("t7");
                        break;
                    }

                               // row[temp] = tempTotal;
                    //dtm.addRow(row);
                    // flag = true;
                }

            }
            if (!flag) {
                JOptionPane.showMessageDialog(null, "Cannot Process due to insufficient inventory");
                return;
            }
            //dtm.addRow(row);
        }
        System.out.println(flag);
        if (flag) {
            cor.setStatus("Forwarded to Warehouse");
            wo.getWorkQueue().getWorkRequestList().add(cor);
            populate();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         WarehouseOrganization wo = (WarehouseOrganization)jComboBox1.getSelectedItem();
        String a = wo.getStreet()+", "+wo.getCity()+", "+wo.getState()+", "+wo.getPin();
        JSONDistanceCalculator j = new JSONDistanceCalculator();
        String ans=j.calculate(a, address);
        jLabel2.setText(ans);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtDesc;
    // End of variables declaration//GEN-END:variables
}
