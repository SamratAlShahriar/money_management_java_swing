/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.view.dashboard.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javaswingdev.chart.ModelPieChart;
import javaswingdev.chart.PieChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import shorna.moneymanagement.model.CategoryTotalModel;
import shorna.moneymanagement.model.MonthWiseSummary;
import shorna.moneymanagement.repository.TransactionRepository;
import shorna.moneymanagement.service.TransactionService;
import shorna.moneymanagement.session.Session;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class Analysis extends javax.swing.JPanel {

    private String startDate;
    private String endDate;

    /**
     * Creates new form Form_1
     */
    public Analysis() {
        initComponents();

        refreshData();

    }

    public void showPieChart() {

        TransactionRepository repository = new TransactionRepository();
        int userId = Session.getUserModel().getId();
        List<CategoryTotalModel> allIncomeCategoryList = repository.getCategoryTotalList(userId, 1, startDate, endDate);
        List<CategoryTotalModel> allExpenseCategoryList = repository.getCategoryTotalList(userId, 2, startDate, endDate);

        setBackground(new Color(255, 255, 255));
        incomePieChart.clearData();
        incomePieChart.setChartType(PieChart.PeiChartType.DONUT_CHART);

        Random random = new Random();
        allIncomeCategoryList.forEach(item -> {
            incomePieChart.addData(new ModelPieChart(item.getCategory(), item.getAmount(), new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))));
        });
        incomePieChart.validate();

        expensePieChart.clearData();
        expensePieChart.setChartType(PieChart.PeiChartType.DONUT_CHART);
        allExpenseCategoryList.forEach(item -> {
            expensePieChart.addData(new ModelPieChart(item.getCategory(), item.getAmount(), new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))));
        });
        expensePieChart.validate();
    }

    public void showLineChart() {

        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] monthNames = dfs.getMonths();

        TransactionRepository repository = new TransactionRepository();
        int userId = Session.getUserModel().getId();
        List<MonthWiseSummary> incomeMonthSummary = repository.getMonthWiseSummary(userId, 1);
        List<MonthWiseSummary> expenseMonthSummary = repository.getMonthWiseSummary(userId, 2);

        List<MonthWiseSummary> modifiedIncomeMonthSummary = new ArrayList<>();
        List<MonthWiseSummary> modifiedExpenseMonthSummary = new ArrayList<>();
        for (String month : monthNames) {
            MonthWiseSummary incomeModel = new MonthWiseSummary(month, 0);
            
            MonthWiseSummary expenseModel = new MonthWiseSummary(month, 0);
            for (var income : incomeMonthSummary) {
                if(income.getMonth().equalsIgnoreCase(month)){
                    incomeModel = income;
                    break;
                }
            }
            
             for (var expense : expenseMonthSummary) {
                if(expense.getMonth().equalsIgnoreCase(month)){
                    expenseModel = expense;
                    break;
                }
            }
            modifiedIncomeMonthSummary.add(incomeModel);
            modifiedExpenseMonthSummary.add(expenseModel);
        }

        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        modifiedIncomeMonthSummary.forEach(item -> {
            dataset.setValue(item.getTotal(), "Income", item.getMonth());
        });

        modifiedExpenseMonthSummary.forEach(item -> {
            dataset.setValue(item.getTotal(), "Expense", item.getMonth());
        });

        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Month Wise Comparison", "month", "amount",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);

        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor1 = new Color(5, 255, 10);
        Color lineChartColor2 = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor1);
        lineRenderer.setSeriesPaint(1, lineChartColor2);
        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        jPanel8.removeAll();
        jPanel8.add(lineChartPanel, BorderLayout.CENTER);
        jPanel8.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        top = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rbToday = new javax.swing.JRadioButton();
        rbSevenDays = new javax.swing.JRadioButton();
        rbThirtyDays = new javax.swing.JRadioButton();
        rbAll = new javax.swing.JRadioButton();
        btnFilter = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        incomePieChart = new javaswingdev.chart.PieChart();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        expensePieChart = new javaswingdev.chart.PieChart();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        botoom = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        right = new javax.swing.JPanel();

        setBackground(new java.awt.Color(242, 242, 242));
        setLayout(new java.awt.BorderLayout());

        top.setPreferredSize(new java.awt.Dimension(474, 30));
        top.setLayout(new java.awt.GridBagLayout());

        jPanel2.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel2.setMinimumSize(new java.awt.Dimension(305, 20));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        buttonGroup1.add(rbToday);
        rbToday.setSelected(true);
        rbToday.setText("Today");
        jPanel2.add(rbToday);

        buttonGroup1.add(rbSevenDays);
        rbSevenDays.setText("Last 7 Days");
        jPanel2.add(rbSevenDays);

        buttonGroup1.add(rbThirtyDays);
        rbThirtyDays.setText("Last 30 Days");
        jPanel2.add(rbThirtyDays);

        buttonGroup1.add(rbAll);
        rbAll.setText("All");
        jPanel2.add(rbAll);

        btnFilter.setText("Filter");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });
        jPanel2.add(btnFilter);

        top.add(jPanel2, new java.awt.GridBagConstraints());

        add(top, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.CardLayout());

        incomePieChart.setLayout(new java.awt.CardLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Income");
        incomePieChart.add(jLabel3, "card2");

        jPanel4.add(incomePieChart, "card3");

        jPanel3.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.CardLayout());

        expensePieChart.setBackground(new java.awt.Color(248, 248, 248));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Expnse");

        javax.swing.GroupLayout expensePieChartLayout = new javax.swing.GroupLayout(expensePieChart);
        expensePieChart.setLayout(expensePieChartLayout);
        expensePieChartLayout.setHorizontalGroup(
            expensePieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expensePieChartLayout.createSequentialGroup()
                .addGap(0, 117, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        expensePieChartLayout.setVerticalGroup(
            expensePieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expensePieChartLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        jPanel5.add(expensePieChart, "card2");

        jPanel3.add(jPanel5);

        jPanel1.add(jPanel3);

        jPanel6.setLayout(new java.awt.CardLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.CardLayout());
        jPanel6.add(jPanel8, "card2");

        jPanel1.add(jPanel6);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        botoom.setPreferredSize(new java.awt.Dimension(474, 20));

        javax.swing.GroupLayout botoomLayout = new javax.swing.GroupLayout(botoom);
        botoom.setLayout(botoomLayout);
        botoomLayout.setHorizontalGroup(
            botoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        botoomLayout.setVerticalGroup(
            botoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        add(botoom, java.awt.BorderLayout.PAGE_END);

        left.setPreferredSize(new java.awt.Dimension(10, 0));

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(left, java.awt.BorderLayout.WEST);

        right.setPreferredSize(new java.awt.Dimension(10, 0));

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(right, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    void calculateDays() {
        int days = 0;
        if (rbToday.isSelected()) {
            days = 0;
        } else if (rbSevenDays.isSelected()) {
            days = 7;
        } else if (rbThirtyDays.isSelected()) {
            days = 30;
        } else {
            days = 99999;
        }
        LocalDate today = LocalDate.now();
        endDate = today.toString();
        LocalDate prevDay = today.minusDays(days);
        startDate = prevDay.toString();
    }

    public void refreshData() {
        calculateDays();
        showPieChart();
        showLineChart();
    }

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        refreshData();
    }//GEN-LAST:event_btnFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botoom;
    private javax.swing.JButton btnFilter;
    private javax.swing.ButtonGroup buttonGroup1;
    private javaswingdev.chart.PieChart expensePieChart;
    private javaswingdev.chart.PieChart incomePieChart;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel left;
    private javax.swing.JRadioButton rbAll;
    private javax.swing.JRadioButton rbSevenDays;
    private javax.swing.JRadioButton rbThirtyDays;
    private javax.swing.JRadioButton rbToday;
    private javax.swing.JPanel right;
    private javax.swing.JPanel top;
    // End of variables declaration//GEN-END:variables
}
