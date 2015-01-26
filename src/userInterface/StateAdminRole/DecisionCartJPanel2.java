/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.StateAdminRole;

import business.enterprise.PhdEnterprise;
import business.organization.HospitalOrganization;
import business.organization.Organization;
import business.workQueue.ClinicOrderRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Dev
 */
public class DecisionCartJPanel2 extends javax.swing.JPanel {

    /**
     * Creates new form DecisionCartJPanel2
     */
    JPanel userProcessContainer;
    PhdEnterprise e;

    public DecisionCartJPanel2(JPanel userProcessContainer, PhdEnterprise e) {
        initComponents();// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.userProcessContainer = userProcessContainer;
        this.e = e;
        JFreeChart jfreechart1 = createChart1(createDataset1());
        ChartPanel chartpanel1 = new ChartPanel(jfreechart1);
        chartpanel1.setPreferredSize(new Dimension(1000, 540));
        jPanel1.add(chartpanel1);
        CardLayout layout1 = (CardLayout) jPanel1.getLayout();
        layout1.next(jPanel1);
    }

    private static JFreeChart createChart1(CategoryDataset categorydataset) {
        JFreeChart jfreechart = ChartFactory.createBarChart("Order Statistics",
                "Hospital", "Value", categorydataset, PlotOrientation.VERTICAL,
                true, true, false);
        CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setRangeCrosshairVisible(true);
        categoryplot.setRangeCrosshairPaint(Color.blue);
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barrenderer = (BarRenderer) categoryplot.getRenderer();
        barrenderer.setDrawBarOutline(false);
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue,
                0.0F, 0.0F, new Color(0, 0, 64));
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F,
                Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, Color.red,
                0.0F, 0.0F, new Color(64, 0, 0));
        barrenderer.setSeriesPaint(0, gradientpaint);
        barrenderer.setSeriesPaint(1, gradientpaint1);
        barrenderer.setSeriesPaint(2, gradientpaint2);
        barrenderer
                .setLegendItemToolTipGenerator(new StandardCategorySeriesLabelGenerator(
                                "Tooltip: {0}"));
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions
                .createUpRotationLabelPositions(0.52359877559829882D));
        return jfreechart;
    }

    private CategoryDataset createDataset1() {
        String s = "Orders Placed";

        //ArrayList<HospitalOrganization> temp = new ArrayList<>();
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        for (Organization ho : e.getOrganizationDirectory().getOrganizationList()) {
            int total = 0;
            if (ho instanceof HospitalOrganization) {
                //temp.add((HospitalOrganization) ho);
                for (ClinicOrderRequest cor : e.getMasterCatalog()) {
                    if(cor.getHospOrg()==null && cor.getSender().equals(ho)){
                        total+=1;
                    }
                    if(cor.getHospOrg()!=null && cor.getHospOrg().equals(ho)){
                        total++;
                    }
                }
                defaultcategorydataset.addValue(total, s, ho.getName());
            }
        }
        

        return defaultcategorydataset;
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.CardLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 748;
        gridBagConstraints.ipady = 402;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(76, 0, 0, 0);
        add(jPanel1, gridBagConstraints);

        jButton1.setText(">>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 53;
        gridBagConstraints.ipady = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 371, 11, 0);
        add(jButton1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       DecisionChartJPanel3 h= new DecisionChartJPanel3(userProcessContainer,e);
        CardLayout l = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("OutgoingPaymentJPanel",h);
        l.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}