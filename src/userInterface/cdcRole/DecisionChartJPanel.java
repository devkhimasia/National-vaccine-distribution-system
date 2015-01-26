/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.cdcRole;

import business.OrderItem;
import business.Vaccine;
import business.enterprise.CdcEnterprise;
import business.enterprise.Enterprise;
import business.enterprise.PhdEnterprise;
import business.network.Network;
import business.organization.ClinicOrganization;
import business.organization.DistributorOrganization;
import business.organization.HospitalOrganization;
import business.organization.ManufactureOrganization;
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
    CdcEnterprise e;
    Network n;

    public DecisionChartJPanel(JPanel userProcessContainer, CdcEnterprise e, Network n) {
        initComponents();//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.userProcessContainer = userProcessContainer;
        this.e = e;
        this.n = n;
        JFreeChart jfreechart = createChart(createDataset());
        Rotator rotator = new Rotator((PiePlot3D) jfreechart.getPlot());
        rotator.start();
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(1000, 540));
        pieChartPanel.add(chartpanel);
        CardLayout layout = (CardLayout) pieChartPanel.getLayout();
        layout.next(pieChartPanel);
        
        JFreeChart jfreechart2 = createChart2(createDataset2());
        Rotator rotator2 = new Rotator((PiePlot3D) jfreechart2.getPlot());
        rotator.start();
        ChartPanel chartpanel2 = new ChartPanel(jfreechart2);
        chartpanel2.setPreferredSize(new Dimension(1000, 540));
        jPanel1.add(chartpanel2);
        CardLayout layout2 = (CardLayout) jPanel1.getLayout();
        layout2.next(jPanel1);

        JFreeChart jfreechart1 = createChart1(createDataset1());
        Rotator rotator1 = new Rotator((PiePlot3D) jfreechart1.getPlot());
        rotator1.start();
        ChartPanel chartpanel1 = new ChartPanel(jfreechart1);
        chartpanel1.setPreferredSize(new Dimension(1000, 540));
        top5HospPanel.add(chartpanel1);
        CardLayout layout1 = (CardLayout) top5HospPanel.getLayout();
        layout1.next(top5HospPanel);

        populate();
    }

    public void populate() {
        int totalOrders = e.getMasterOrderList().size();
        txtOrderTotal.setText(String.valueOf(totalOrders));
        int totalHosp = 0;
        for (Network n1 : n.getStateList()) {
            for (Enterprise e1 : n1.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e1.getOrganizationDirectory().getOrganizationList()) {
                    if (o instanceof HospitalOrganization) {
                        totalHosp++;
                    }
                }
            }
        }

        txtHosptotal.setText(String.valueOf(totalHosp));

        int tv = 0;

        for (Network n1 : n.getStateList()) {
            for (Enterprise e1 : n1.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o1 : e1.getOrganizationDirectory().getOrganizationList()) {
                    if (o1 instanceof HospitalOrganization) {
                        HospitalOrganization hoo = (HospitalOrganization) o1;
                        tv += hoo.getTotalVaccine();
                        for (Organization o2 : o1.getOrganizationDirectory().getOrganizationList()) {
                            if (o2 instanceof ClinicOrganization) {
                                ClinicOrganization coo = (ClinicOrganization) o2;
                                tv += coo.getTotalVaccine();

                            }
                        }
                    }
                }
            }
        }
        jTextField1.setText(String.valueOf(tv));

        int t = 0;
        int t1 = 0;

        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof DistributorOrganization) {
                for (Organization o2 : o.getOrganizationDirectory().getOrganizationList()) {
                    if (o2 instanceof ManufactureOrganization) {
                        t += 1;
                        ManufactureOrganization mo = (ManufactureOrganization) o2;
                        for (Vaccine v : mo.getProductCatalog()) {
                            t1 += 1;
                        }
                    }
                }
            }
        }
        jTextField2.setText(String.valueOf(t));
        jTextField3.setText(String.valueOf(t1));

    }

    private static JFreeChart createChart(PieDataset piedataset) {
        // System.out.println("1");
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Top 5 States (For Vaccinations)", piedataset, true, false, false);
        PiePlot3D pieplot3d = (PiePlot3D) jfreechart.getPlot();
      pieplot3d.setDrawingSupplier(new ChartDrawingSupplier());
        pieplot3d.setStartAngle(270D);
        pieplot3d.setDirection(Rotation.ANTICLOCKWISE);
        pieplot3d.setForegroundAlpha(0.6F);
        return jfreechart;
    }

    private static JFreeChart createChart1(PieDataset piedataset) {
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Top 5 Hospitals (For Orders Placed)", piedataset, true, false, false);
        PiePlot3D pieplot3d = (PiePlot3D) jfreechart.getPlot();
        pieplot3d.setStartAngle(270D);
        pieplot3d.setDirection(Rotation.ANTICLOCKWISE);
        pieplot3d.setForegroundAlpha(0.6F);
        return jfreechart;
    }
 private static JFreeChart createChart2(PieDataset piedataset) {
        JFreeChart jfreechart = ChartFactory.createPieChart3D("Top 5 Vaccines", piedataset, true, false, false);
        PiePlot3D pieplot3d = (PiePlot3D) jfreechart.getPlot();
        pieplot3d.setStartAngle(270D);
        pieplot3d.setDirection(Rotation.ANTICLOCKWISE);
        pieplot3d.setForegroundAlpha(0.6F);
        return jfreechart;
    }
    class stateQty {

        private Enterprise e;
        private int q;

        public Enterprise getE() {
            return e;
        }

        public void setE(Enterprise e) {
            this.e = e;
        }

        public int getQ() {
            return q;
        }

        public void setQ(int q) {
            this.q = q;
        }

    }

    private PieDataset createDataset() {
        System.out.println("2");
        ArrayList<stateQty> temp = new ArrayList<>();
        //temp = supplier.getProductCatalog().getProductCatalog();
        //temp = supplier.getProductCatalog().getProductCatalog();
        stateQty sq = null;
        Boolean flag = true;

        for (Network n1 : n.getStateList()) {
            for (Enterprise e1 : n1.getEnterpriseDirectory().getEnterpriseList()) {
                if (e1 instanceof PhdEnterprise) {
                    int total = 0;
                    for (Organization o3 : e1.getOrganizationDirectory().getOrganizationList()) {
                        if (o3 instanceof HospitalOrganization) {
                            HospitalOrganization ho1 = (HospitalOrganization) o3;
                            total += ho1.getTotalVaccine();
                        }
                    }
                    for (Organization o4 : e1.getOrganizationDirectory().getOrganizationList()) {
                        if (o4 instanceof HospitalOrganization) {
                            for (Organization o5 : o4.getOrganizationDirectory().getOrganizationList()) {
                                if (o5 instanceof ClinicOrganization) {
                                    ClinicOrganization co1 = (ClinicOrganization) o5;
                                    total += co1.getTotalVaccine();
                                }
                            }
                        }
                    }
                    sq = new stateQty();
                    sq.setE(e1);
                    sq.setQ(total);
                    temp.add(sq);
                }
            }
        }

        Collections.sort(temp, new Comparator<stateQty>() {
            public int compare(stateQty one, stateQty other) {
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
        System.out.println(temp.size());
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        //defaultpiedataset.setValue("Java", 10);
        int i = 1;
        for (stateQty p : temp) {
            if (i == 6) {
                break;
            } else {
                defaultpiedataset.setValue(p.getE().getName() + "(" + p.getQ() + ")", p.getQ());
                i++;
            }
        }

        return defaultpiedataset;
    }

    // for top 5 hosp
    class hospQty {

        private HospitalOrganization o;
        private int q;

        public HospitalOrganization getO() {
            return o;
        }

        public void setO(HospitalOrganization o) {
            this.o = o;
        }

        public int getQ() {
            return q;
        }

        public void setQ(int q) {
            this.q = q;
        }

    }

    private PieDataset createDataset1() {
        ArrayList<hospQty> temp = new ArrayList<>();
        //temp = supplier.getProductCatalog().getProductCatalog();
        //temp = supplier.getProductCatalog().getProductCatalog();
        hospQty sq = null;
        Boolean flag = true;
        for (ClinicOrderRequest cor : e.getMasterOrderList()) {
            HospitalOrganization o = null;
            if (cor.getHospOrg() != null) {
                o = cor.getHospOrg();
            } else {
                o = (HospitalOrganization) cor.getSender();
            }
            if (temp.size() == 0) {
                sq = new hospQty();
                sq.setO(o);
                for (OrderItem oi : cor.getOrder().getOrder()) {
                    sq.setQ(sq.getQ() + oi.getQuantity());
                }
                temp.add(sq);
            }
            for (hospQty sq1 : temp) {
                if (sq1.getO().equals(o)) {
                    for (OrderItem oi : cor.getOrder().getOrder()) {
                        sq1.setQ(sq1.getQ() + oi.getQuantity());
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                sq = new hospQty();
                sq.setO(o);
                for (OrderItem oi : cor.getOrder().getOrder()) {
                    sq.setQ(sq.getQ() + oi.getQuantity());
                }
                temp.add(sq);
            }
        }

        Collections.sort(temp, new Comparator<hospQty>() {
            public int compare(hospQty one, hospQty other) {
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
        for (hospQty p : temp) {
            if (i == 6) {
                break;
            } else {
                defaultpiedataset.setValue(p.getO().getName() + "(" + p.getQ() + ")", p.getQ());
                i++;
            }
        }

        return defaultpiedataset;
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

    private PieDataset createDataset2() {
        ArrayList<VaccineQty> temp = new ArrayList<>();
        //temp = supplier.getProductCatalog().getProductCatalog();
        //temp = supplier.getProductCatalog().getProductCatalog();
        VaccineQty vq = null;
        Boolean flag = true;
        for (ClinicOrderRequest cor : e.getMasterOrderList()) {
            //System.out.println("ORder");
            for (OrderItem oi : cor.getOrder().getOrder()) {
               // System.out.println("1st-" + oi.getProduct());
                if (temp.size() == 0) {
                   // System.out.println("here 1st");
                    vq = new VaccineQty();
                    vq.setV(oi.getProduct());
                    vq.setQ(oi.getQuantity());
                    temp.add(vq);
                } else {
                    for (VaccineQty vqc : temp) {
                       // System.out.println("oi-" + oi.getProduct() + " ," + "vg-" + vq.getV());
                        if (vqc.getV().equals(oi.getProduct())) {
                            //System.out.println("in same");
                            vqc.setQ(vqc.getQ() + oi.getQuantity());
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        //System.out.println("hello");
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
        top5HospPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        backJButton = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHosptotal.setEditable(false);
        txtHosptotal.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        add(txtHosptotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 184, 56, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Total Hospitals Listed");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 187, -1, -1));

        txtOrderTotal.setEditable(false);
        txtOrderTotal.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        add(txtOrderTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 229, 56, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setText("Total Orders Placed");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 232, -1, -1));

        pieChartPanel.setLayout(new java.awt.CardLayout());
        add(pieChartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 330, 290));

        top5HospPanel.setLayout(new java.awt.CardLayout());
        add(top5HospPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 34, 340, 280));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText("Total Vaccinations");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 292, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 289, 56, -1));

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 335, 56, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setText("Total Manufactures");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 338, -1, -1));

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 376, 56, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setText("Total Vaccines");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 379, -1, -1));

        jPanel1.setLayout(new java.awt.CardLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 320, 270));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel pieChartPanel;
    private javax.swing.JPanel top5HospPanel;
    private javax.swing.JTextField txtHosptotal;
    private javax.swing.JTextField txtOrderTotal;
    // End of variables declaration//GEN-END:variables
}
