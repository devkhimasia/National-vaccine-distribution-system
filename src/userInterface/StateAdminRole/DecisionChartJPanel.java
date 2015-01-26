/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.StateAdminRole;

import business.OrderItem;
import business.Patient;
import business.Vaccine;
import business.VaccineDelivery;
import business.enterprise.CdcEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.PhdEnterprise;
import business.network.Network;
import business.organization.ClinicOrganization;
import business.organization.HospitalOrganization;
import business.organization.Organization;
import business.workQueue.ClinicOrderRequest;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Dev
 */
public class DecisionChartJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DecisionChartJPanel
     */
    JPanel userProcessContainer;
    PhdEnterprise e;
    Network n;
    public DecisionChartJPanel(JPanel userProcessContainer, Enterprise e, Network n) {
        initComponents();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.userProcessContainer = userProcessContainer;
        this.e = (PhdEnterprise) e;
        this.n=n;
        JFreeChart jfreechart = createChart(createDataset());
        Rotator rotator = new Rotator((PiePlot3D) jfreechart.getPlot());
        rotator.start();
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(1000, 540));
        pieChartPanel.add(chartpanel);
        CardLayout layout = (CardLayout) pieChartPanel.getLayout();
        layout.next(pieChartPanel);

        populate();
    }

    public void populate() {
        int totalOrders = e.getMasterCatalog().size();
        txtOrderTotal.setText(String.valueOf(totalOrders));
        int totalHosp = 0;
        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof HospitalOrganization) {
                totalHosp++;
            }
        }
        txtHosptotal.setText(String.valueOf(totalHosp));
        int tot=0;
        int tv=0;
        for(Organization o1: e.getOrganizationDirectory().getOrganizationList()){
            if(o1 instanceof HospitalOrganization){
                HospitalOrganization hoo = (HospitalOrganization)o1;
                tv+=hoo.getTotalVaccine();
                for(Organization o2: o1.getOrganizationDirectory().getOrganizationList()){
                    if(o2 instanceof ClinicOrganization){
                        ClinicOrganization coo = (ClinicOrganization)o2;
                        tv+=coo.getTotalVaccine();
                        tot++;
                    }
                }
            }
        }
        jTextField1.setText(String.valueOf(tot));
        jTextField2.setText(String.valueOf(tv));
        
    }


   
 private static JFreeChart createChart(PieDataset piedataset) {
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Top 5 Vaccines", piedataset, true, false, false);
        PiePlot3D pieplot3d = (PiePlot3D) jfreechart.getPlot();
        pieplot3d.setStartAngle(270D);
        pieplot3d.setDirection(Rotation.ANTICLOCKWISE);
        pieplot3d.setForegroundAlpha(0.6F);
        return jfreechart;
    }

    class VaccineQty {

        Vaccine v;
        int q;

        public Vaccine getV() {
            return v;
        }

        public void setV(Vaccine v) {
            this.v = v;
        }

        public int getQ() {
            return q;
        }

        public void setQ(int q) {
            this.q = q;
        }

    }

    private PieDataset createDataset() {
        ArrayList<VaccineQty> temp = new ArrayList<>();
        //temp = supplier.getProductCatalog().getProductCatalog();
        //temp = supplier.getProductCatalog().getProductCatalog();
        VaccineQty vq = null;
        Boolean flag = true;
        for (ClinicOrderRequest cor : e.getMasterCatalog()) {
            System.out.println("ORder");
            for (OrderItem oi : cor.getOrder().getOrder()) {
                System.out.println("1st-" + oi.getProduct());
                if (temp.size() == 0) {
                    System.out.println("here 1st");
                    vq = new VaccineQty();
                    vq.setV(oi.getProduct());
                    vq.setQ(oi.getQuantity());
                    temp.add(vq);
                } else {
                    for (VaccineQty vqc : temp) {
                        System.out.println("oi-" + oi.getProduct() + " ," + "vg-" + vq.getV());
                        if (vqc.getV().equals(oi.getProduct())) {
                            System.out.println("in same");
                            vqc.setQ(vqc.getQ() + oi.getQuantity());
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.println("hello");
                        vq = new VaccineQty();
                        vq.setV(oi.getProduct());
                        vq.setQ(oi.getQuantity());
                        temp.add(vq);
                    }
                }
            }
        }
        Collections.sort(temp, new Comparator<VaccineQty>() {
            public int compare(VaccineQty one, VaccineQty other) {
                if (one.getQ() < other.getQ()) {
                    return -1;
                }
                if (one.getQ() > other.getQ()) {
                    return 1;
                }

                return 0;
            }
        });
        Collections.reverse(temp);
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        //defaultpiedataset.setValue("Java", 10);
        int i = 1;
        for (VaccineQty p : temp) {
            if (i == 6) {
                break;
            } else {
                defaultpiedataset.setValue(p.getV().getName() + "(" + p.getQ() + ")", p.getQ());
                i++;
            }
        }

        return defaultpiedataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtHosptotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtOrderTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pieChartPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        txtHosptotal.setEditable(false);
        txtHosptotal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Total Hospitals Listed");

        txtOrderTotal.setEditable(false);
        txtOrderTotal.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Total Orders Placed");

        pieChartPanel.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Total Clinic Listed");

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        jButton1.setText(">>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Total people vaccined");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHosptotal)
                    .addComponent(txtOrderTotal)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(pieChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtHosptotal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtOrderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pieChartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       DecisionCartJPanel2 h= new DecisionCartJPanel2(userProcessContainer,e);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("OutgoingPaymentJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel pieChartPanel;
    private javax.swing.JTextField txtHosptotal;
    private javax.swing.JTextField txtOrderTotal;
    // End of variables declaration//GEN-END:variables
}
