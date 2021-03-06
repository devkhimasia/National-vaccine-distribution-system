/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import business.DB40Util.DB4OUtil;
import business.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.userAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import userInterface.guestLogin.GuestLoginJPanel;



/**
 *
 * @author Dev
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    public MainJFrame() {
        initComponents();
        TextPrompt tp1 = new TextPrompt("Username", txtUserName);
        TextPrompt tp2 = new TextPrompt("Password", txtPassword);
        system = dB4OUtil.retrieveSystem();
        jLabel1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                GuestLoginJPanel g = new GuestLoginJPanel(userProcessContainer, system);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                //userProcessContainer.add("Admin",);
                userProcessContainer.add("guest", g);
                layout.next(userProcessContainer);

            }
        });
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

        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userProcessContainer = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane2.setDividerLocation(55);
        jSplitPane2.setDividerSize(1);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel3.setText("USA Vaccine Distribution System");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/1416213953_Login_in.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/1416214249_on-off.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Login as a Guest");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(26, 26, 26))
        );

        jSplitPane2.setLeftComponent(jPanel1);

        userProcessContainer.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userInterface/main_icon.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = -51;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 296, 67, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 0));
        jLabel4.setText("National Vaccine Distribution System");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 315, 0, 242);
        jPanel2.add(jLabel4, gridBagConstraints);

        userProcessContainer.add(jPanel2, "card2");

        jSplitPane2.setRightComponent(userProcessContainer);

        getContentPane().add(jSplitPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String userName = txtUserName.getText();
        // Get Password
        char[] passwordCharArray = txtPassword.getPassword();
        String password = String.valueOf(passwordCharArray);

        //Step1 : check whether systemlevel useraccount exists in the system
        UserAccount ua = system.getUserAccountDirectory().authenticateUser(userName, password);
        Enterprise inEnterprise = null;
        Enterprise parentEnt=null;
        Organization inOrganization = null;
        Organization inOrganizationParent = null;
        Network inNetwork = null;
        Network parentNetwork = null;
        if (ua == null) {
         
            //Step 2: if not, check whether it exists Enterprise UserAccountDirectory
            for (Network n : system.getNetworkList()) {
                //ua = n.getUserAccountDirectory().authenticateUser(userName, password);
                //System.out.println(n.getName());
                    for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                        ua = e.getUserAccountDirectory().authenticateUser(userName, password);
                        if (ua == null) {
                            //Step3 : if not, check whether it exists in Organiation USerAccountDirectory

                            for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                                ua = org.getUserAccountDirectory().authenticateUser(userName, password);
                                
                                if (ua != null) {
                                   // System.out.println("here");
                                    inEnterprise = e;
                                    inOrganization = org;
                                    break;

                                }
                            }
                            if(ua==null){
                               for(Organization o1: e.getOrganizationDirectory().getOrganizationList()){
                                   for(Organization o2: o1.getOrganizationDirectory().getOrganizationList()){
                                       ua=o2.getUserAccountDirectory().authenticateUser(userName, password);
                                       if(ua!=null){
                                           inEnterprise = e;
                                           inOrganization = o2;
                                           inOrganizationParent = o1;
                                           break;
                                           //System.out.println(o2.getName());
                                       }
                                   }
                               }
                           } 
                        } else {
                            inEnterprise = e;
                           inNetwork = n;
                            break;
                        }
                        if (inOrganization != null) {
                            break;
                        }

                    }
                 
                if (inEnterprise != null) {
                    break;
                }
                
            }
            
        }
        if (ua == null) {
             
            for (Network n1 : system.getNetworkList()) {
               // System.out.println(n1.getName());
               // System.out.println("i m here");
                for(Network n: n1.getStateList()){
                   // System.out.println(n.getName());
                //ua = n.getUserAccountDirectory().authenticateUser(userName, password);
                //System.out.println(n.getName());
                    for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
                       // System.out.println(e.getName());
                        ua = e.getUserAccountDirectory().authenticateUser(userName, password);
                       
                        if (ua == null) {
                            //System.out.println("here again");
                            //Step3 : if not, check whether it exists in Organiation USerAccountDirectory

                            for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                                ua = org.getUserAccountDirectory().authenticateUser(userName, password);
                                if (ua != null) {
                                    parentEnt=n1.getEnterpriseDirectory().getEnterpriseList().get(0);
                                    inEnterprise = e;
                                    inOrganization = org;
                                    break;

                                }
                            }
                           if(ua==null){
                               for(Organization o1: e.getOrganizationDirectory().getOrganizationList()){
                                   for(Organization o2: o1.getOrganizationDirectory().getOrganizationList()){
                                       ua=o2.getUserAccountDirectory().authenticateUser(userName, password);
                                       if(ua!=null){
                                           inEnterprise = n1.getEnterpriseDirectory().getEnterpriseList().get(0);
                                           inOrganization = o2;
                                           inOrganizationParent = o1;
                                           //inNetwork = n1;
                                       }
                                   }
                               }
                           } 
                        } else {
                            System.out.println(n1);
                            inEnterprise = e;
                           inNetwork = n1;
                            break;
                           
                        }
                        if (inOrganization != null) {
                            break;
                        }

                    }
                 
                if (inEnterprise != null) {
                    break;
                }
                } 
                if (inEnterprise != null) {
                    break;
                }
            }
        }
        if(ua==null){
            JOptionPane.showMessageDialog(null, "Invalid");
            return;
        }
        else {
            
            // AdminWorkAreaJPanel awajp = new AdminWorkAreaJPanel(userProcessContainer, ua, system, dB4OUtil);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            //userProcessContainer.add("Admin",);
            userProcessContainer.add("WorkArea", ua.getRole().createWorkArea(userProcessContainer, ua, inOrganization, inEnterprise, system, inNetwork, inOrganizationParent, parentEnt));
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //System.out.println("here");
        userProcessContainer.removeAll();
        //System.out.println("here");
        dB4OUtil.storeSystem(system);
        //System.out.println("after");
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JPanel userProcessContainer;
    // End of variables declaration//GEN-END:variables
}
