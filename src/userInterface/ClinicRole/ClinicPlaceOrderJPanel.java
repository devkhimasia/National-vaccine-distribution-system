/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ClinicRole;

import business.Order;
import business.OrderItem;
import business.Vaccine;
import business.enterprise.Enterprise;
import business.organization.ClinicOrganization;
import business.organization.DistributorOrganization;
import business.organization.HospitalOrganization;
import business.organization.ManufactureOrganization;
import business.organization.Organization;
import business.userAccount.UserAccount;
import business.workQueue.ClinicOrderRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class ClinicPlaceOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ClinicPlaceOrderJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    ClinicOrganization clinicOrganization;
    Enterprise e;
    HospitalOrganization parentOrg;
    Order order;
    private Boolean isCheckOut = false;
    ClinicPlaceOrderJPanel(JPanel userProcessContainer, UserAccount account, ClinicOrganization clinicOrganization, Enterprise e, HospitalOrganization parentOrg) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.clinicOrganization = clinicOrganization;
        this.e = e;
        this.parentOrg = parentOrg;
        if (!isCheckOut) {
            order = clinicOrganization.addOrder();
        }
        //order= clinicOrganization.addOrder();
        // System.out.println(network.getName());
        populateVaccineTable();
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void populateVaccineTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblProducts.getModel();
        dtm.setRowCount(0);
        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof DistributorOrganization) {
                for (Organization o1 : o.getOrganizationDirectory().getOrganizationList()) {
                    if (o1 instanceof ManufactureOrganization) {
                        ManufactureOrganization mo = (ManufactureOrganization) o1;
                        for (Vaccine v : mo.getProductCatalog()) {

                            Object row[] = new Object[4];
                            row[0] = v;
                            row[1] = v.getName();
                            row[2] = v.getType();
                            row[3] = v.getHospitalPrice();
                            dtm.addRow(row);
                        }
                    }
                }
            }
        }
    }

    public void populateVaccineTable(Vaccine v) {
        DefaultTableModel dtm = (DefaultTableModel) tblProducts.getModel();
        dtm.setRowCount(0);
        Object row[] = new Object[3];
        row[0] = v;
        row[1] = v.getName();
        row[2] = v.getType();
        dtm.addRow(row);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProduct = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        btnAddToCart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCart = new javax.swing.JTable();
        spnQuantity = new javax.swing.JSpinner();
        btnCheckOut = new javax.swing.JButton();
        txtModify = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnModify = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Type", "Price"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        btnAddToCart.setText("Add To Order List");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        tblCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine", "Quantity", "Unit Price", "Total Price"
            }
        ));
        jScrollPane2.setViewportView(tblCart);

        btnCheckOut.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        btnCheckOut.setText("Check Out");
        btnCheckOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        jLabel1.setText("Modify Quantity");

        btnModify.setText("Modify Quantity");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter Product Name");

        btnRemove.setText("Remove Item");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel4.setText("Order List");

        jLabel5.setText("Vaccine List");

        jButton1.setText("View Vaccine");
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
                        .addGap(41, 41, 41)
                        .addComponent(btnBack))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(173, 173, 173)
                                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                    .addComponent(jButton1))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(btnBrowse)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtModify, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnModify)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemove))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(485, 485, 485)
                        .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(628, 628, 628))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBrowse)
                    .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnModify)
                    .addComponent(btnRemove))
                .addGap(18, 18, 18)
                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232)
                .addComponent(btnBack)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        String name = txtProduct.getText();
        boolean flag = false;
        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof DistributorOrganization) {
                for (Organization o1 : o.getOrganizationDirectory().getOrganizationList()) {
                    if (o1 instanceof ManufactureOrganization) {
                        ManufactureOrganization mo = (ManufactureOrganization) o1;
                        for (Vaccine v : mo.getProductCatalog()) {

                            if (v.getName().equalsIgnoreCase(name)) {
                                flag = true;
                                populateVaccineTable(v);
                                break;
                            }

                        }
                    }
                }
            }
        }

        if (!flag) {
            JOptionPane.showMessageDialog(null, "Product doesnt exist");
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        int selectedRow = tblProducts.getSelectedRow();
        boolean isIncluded = false;

        if (selectedRow >= 0) {
            int quantity = (Integer) spnQuantity.getValue();
            Vaccine vaccine = (Vaccine) tblProducts.getValueAt(selectedRow, 0);
            for (OrderItem oi : order.getOrder()) {
                if (oi.getProduct().getName().equals(vaccine.getName())) {
                    int newQuantity = (Integer) spnQuantity.getValue();
                    
                        oi.setQuantity(newQuantity + oi.getQuantity());
                        //sproduct.setAvailablity((product.getAvailablity() - newQuantity));
                        isIncluded = true;
                        populateVaccineTable();
                        populateCartTable(order);
                    
                }
            }

            if (quantity <= 0) {
                JOptionPane.showMessageDialog(null, "Select quantity");
            } else if (!isIncluded) {
                //Order order = new Order();
                OrderItem orderItem = order.addOrderItem();
                orderItem.setProduct(vaccine);
                orderItem.setQuantity(quantity);
                //product.setAvailablity((product.getAvailablity() - quantity));
                populateCartTable(order);
                populateVaccineTable();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Selec a row");
        }
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        order.setTimestamp(new Date());
        int total=0;
        for (OrderItem oi : order.getOrder()) {
            
            total+=oi.getProduct().getHospitalPrice()*oi.getQuantity();
            oi.getProduct().setSold(oi.getQuantity());
            // System.out.print(oi.getProduct().getProdName() + "->" + oi.getProduct().getSold());
        }
        System.out.println("total="+total);
        order.setStatus("Forwarded to Hospital");
        order.setTotalAmount(total);
        
                ClinicOrderRequest cor = new ClinicOrderRequest();
                cor.setSender(clinicOrganization);
                cor.setStatus("Forwarded to Hospital");
                cor.setOrder(order);
                cor.setReceiver(parentOrg);
               // System.out.println(parentOrg.getName());
                
                parentOrg.getWorkQueue().getWorkRequestList().add(cor);
                clinicOrganization.getWorkQueue().getWorkRequestList().add(cor);
      //  moc.addOrder(order);
        isCheckOut = true;
        int opt = JOptionPane.showConfirmDialog(null, "Successfully Checked Out. Do you want to continue Ordering?", "Warning", JOptionPane.YES_NO_OPTION);
        if (opt == JOptionPane.YES_OPTION) {
            order = clinicOrganization.addOrder();
            populateCartTable(order);
        } else {
            userProcessContainer.remove(this);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        int selectedRow = tblCart.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row.");
        } else {
            OrderItem oi = (OrderItem) tblCart.getValueAt(selectedRow, 0);
            //int q=(Integer)spnQuantity.getValue();
            int modq = Integer.parseInt(txtModify.getText());
            if (modq > oi.getQuantity()) {
                int value = modq - oi.getQuantity();
                
                    oi.setQuantity(modq);
                    //oi.getProduct().setAvailablity(oi.getProduct().getAvailablity() - value);
                    populateVaccineTable();
                    populateCartTable(order);
                
            } else {
                int value = oi.getQuantity() - modq;
                oi.setQuantity(modq);
                //oi.getProduct().setAvailablity(oi.getProduct().getAvailablity() + value);
                populateVaccineTable();
                populateCartTable(order);
            }
        }
    }//GEN-LAST:event_btnModifyActionPerformed
private void populateCartTable(Order order) {
        DefaultTableModel dtm = (DefaultTableModel) tblCart.getModel();
        dtm.setRowCount(0);

        for (OrderItem oi : order.getOrder()) {
            Object row[] = new Object[4];
            row[0] = oi;
            row[1] = oi.getQuantity();
            Vaccine vaccine = oi.getProduct();
            row[2] = vaccine.getHospitalPrice();
            row[3] = vaccine.getHospitalPrice()* oi.getQuantity();
            
            dtm.addRow(row);
        }
    }
    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int s = tblCart.getSelectedRow();
        if (s < 0) {
            JOptionPane.showMessageDialog(null, "Select a row");
        } else {
            OrderItem oi = (OrderItem) tblCart.getValueAt(s, 0);
            int opt = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Warning", JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
               // oi.getProduct().setIsCancelled();
               // oi.getProduct().setAvailablity(oi.getProduct().getAvailablity() + oi.getQuantity());
                order.removeOrderItem(oi);
                populateCartTable(order);
                populateVaccineTable();
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

       
            userProcessContainer.remove(this);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selected = tblProducts.getSelectedRow();
        if (selected < 0) {
            return;
        } else {
            Vaccine d = (Vaccine) tblProducts.getValueAt(selected, 0);
         ViewVaccineDetailsJPanel v = new ViewVaccineDetailsJPanel(userProcessContainer, d);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("ViewVaccineDetails", v);
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTable tblCart;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtModify;
    private javax.swing.JTextField txtProduct;
    // End of variables declaration//GEN-END:variables
}
