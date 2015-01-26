/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.ClinicRole;

import userInterface.WarehouseRole.*;
import business.inventory.Inventory;
import business.inventory.InventoryItem;
import business.organization.ClinicOrganization;
import business.organization.WarehouseOrganization;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dev
 */
public class InventoryItemListJPanel extends javax.swing.JPanel {

    /**
     * Creates new form InventoryItemListJPanel
     */
    JPanel userProcessContainer;
    ClinicOrganization o;
    Inventory inventory;

    public InventoryItemListJPanel(JPanel userProcessContainer, ClinicOrganization o, Inventory i) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.inventory = i;
        this.o = o;
        populate();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void populate() {
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        for (Inventory i : o.getInventoryCatalog().getInventoryList()) {
            if (i.equals(inventory)) {
                for (InventoryItem ii : i.getInventoryItemList()) {
                    if (ii.getQuantity() > 0) {
                        Object row[] = new Object[3];
                        row[0] = i.getVaccine().getName();
                        row[1] = ii.getQuantity();
                        row[2] = ii.getExpiry();
                        dtm.addRow(row);
                    }
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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccine", "Batch Quantity", "Expiry"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 104;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 103, 326, 88);
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
