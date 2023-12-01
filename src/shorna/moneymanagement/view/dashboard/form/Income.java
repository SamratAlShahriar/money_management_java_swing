/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shorna.moneymanagement.view.dashboard.form;

import java.awt.Color;
import java.awt.event.MouseEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import shorna.moneymanagement.component.ScrollBar;
import shorna.moneymanagement.model.TransactionModel;
import shorna.moneymanagement.repository.TransactionRepository;
import shorna.moneymanagement.session.Session;
import shorna.moneymanagement.utils.PopUpMessage;
import shorna.moneymanagement.view.constant.TransactionType;
import shorna.moneymanagement.view.dashboard.DashboardPage;

/**
 *
 * @author Mst. Taslima Aktar Shorna
 */
public class Income extends javax.swing.JPanel {

    int userId = 0;

    private TransactionModel selectedModel;

    private List<TransactionModel> trList = new ArrayList<>();

    public Income() {
        initComponents();

        userId = Session.getUserModel().getId();

        txtAmount.setLabelText("Amount");
        txtNote.setLabelText("Note");
        cmbCategory.setLabeText("");
        dcDate.setDate(new Date());
         dcDate.enableInputMethods(false);
        ((JTextField) (dcDate.getDateEditor().getUiComponent())).setEditable(false);
        dcDate.setDateFormatString("dd-MM-yyyy");

        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

        table.addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                TableModel model = table.getModel();
                int row = table.getSelectedRow();

                if (row >= 0 && row < trList.size()) {
                    TransactionModel tm = trList.get(row);
                    setSeletectedData(tm);
                }

            }

        });

        refreshTableData();

    }

    public void setSeletectedData(TransactionModel model) {
        try {
            if (model.getCategory().toLowerCase().equals("unknown")) {
                cmbCategory.setSelectedIndex(0);
            } else {
                cmbCategory.setSelectedItem(model.getCategory());
            }
            txtAmount.setText(String.valueOf(model.getAmount()));
            txtNote.setText(String.valueOf(model.getNote()));
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(model.getDate());
            dcDate.setDate(date);

            selectedModel = model;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshTableData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        displayDatasWithinTable();
    }

    public void displayDatasWithinTable() {
        TransactionRepository transactionRepository = new TransactionRepository();
        trList = transactionRepository.getAllIncomeTransactionList(userId);
        Object[] row = new Object[6];

        for (int i = 0; i < trList.size(); i++) {
            TransactionModel tm = trList.get(i);
            row[0] = String.valueOf(i + 1);
            row[1] = tm.getDate();
            row[2] = tm.getCategory();
            row[3] = tm.getNote();
            row[4] = String.valueOf(tm.getAmount());
            table.addRow(row);
        }

        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        panel = new javax.swing.JLayeredPane();
        cmbCategory = new shorna.moneymanagement.component.ComboBox();
        dcDate = new com.toedter.calendar.JDateChooser();
        txtAmount = new shorna.moneymanagement.component.TextField();
        txtNote = new shorna.moneymanagement.component.TextField();
        jPanel3 = new javax.swing.JPanel();
        btnDelete = new javax.swing.JPanel();
        jlabel4 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JPanel();
        jlabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelBorder1 = new shorna.moneymanagement.component.PanelBorder();
        jLabel2 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new shorna.moneymanagement.component.Table();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(915, 600));

        panel.setLayout(new java.awt.GridLayout(2, 2, 20, 20));

        cmbCategory.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Category", "Salary", "Profit", "Wage", "Sale", "Others" }));
        cmbCategory.setLineColor(new java.awt.Color(204, 204, 204));
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });
        panel.add(cmbCategory);
        panel.add(dcDate);
        panel.add(txtAmount);
        panel.add(txtNote);

        jPanel3.setBackground(new java.awt.Color(242, 242, 242));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 20, 20));

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 0, true));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.setLayout(new java.awt.BorderLayout());

        jlabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlabel4.setForeground(new java.awt.Color(255, 255, 255));
        jlabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel4.setText("Delete");
        btnDelete.add(jlabel4, java.awt.BorderLayout.CENTER);

        jPanel3.add(btnDelete);

        btnUpdate.setBackground(new java.awt.Color(51, 0, 102));
        btnUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 0, true));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        btnUpdate.setLayout(new java.awt.BorderLayout());

        jlabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlabel3.setForeground(new java.awt.Color(255, 255, 255));
        jlabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabel3.setText("Update");
        btnUpdate.add(jlabel3, java.awt.BorderLayout.CENTER);

        jPanel3.add(btnUpdate);

        btnSave.setBackground(new java.awt.Color(0, 102, 51));
        btnSave.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 0, true));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        btnSave.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Save");
        jLabel4.setPreferredSize(new java.awt.Dimension(37, 40));
        btnSave.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel3.add(btnSave);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(127, 127, 127));
        jLabel2.setText("Income History");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL", "Date", "Category", "Note", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(464, 464, 464)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoryActionPerformed

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked

        if (selectedModel == null) {
            PopUpMessage.popUpMsgBox("Please select a row first", "Failed", WIDTH);
            return;
        } else {

            String amountText = txtAmount.getText().trim();
            double amount = 0;
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException e) {
            }
            String note = txtNote.getText().trim();
            String category = "Unknown";
            if (cmbCategory.getSelectedIndex() > 0) {
                category = cmbCategory.getSelectedItem().toString();
            }

            Date sDate = dcDate.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String selectedDate = sdf.format(sDate);
            int transactionType = 1; //income

            String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());

            TransactionModel model = new TransactionModel(selectedModel.getId(), userId, selectedModel.getTransactionType(), category, selectedDate, amount, note, selectedModel.getInsertTime());

            TransactionRepository transactionRepository = new TransactionRepository();
            boolean isUpdated = transactionRepository.updateTransaction(model);
            if (isUpdated) {
                resetFields();
                selectedModel = null;
                PopUpMessage.popUpMsgBox("Income data updated!", "Success", WIDTH);
                DashboardPage.instance.refreshAllData();

            }
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        String amountText = txtAmount.getText().trim();
        double amount = 0;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
        }
        String note = txtNote.getText().trim();
        String category = "Unknown";
        if (cmbCategory.getSelectedIndex() > 0) {
            category = cmbCategory.getSelectedItem().toString();
        }

        Date sDate = dcDate.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String selectedDate = sdf.format(sDate);
        int transactionType = 1; //income

        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());

        TransactionModel model = new TransactionModel(userId, transactionType, category, selectedDate, amount, note, currentDateTime);

        TransactionRepository transactionRepository = new TransactionRepository();
        boolean isInserted = transactionRepository.insertTransaction(model);
        if (isInserted) {
            resetFields();
            PopUpMessage.popUpMsgBox("Income data saved!", "Success", WIDTH);

            DashboardPage.instance.refreshAllData();

        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
         if (selectedModel == null) {
            PopUpMessage.popUpMsgBox("Please select a row first", "Failed", WIDTH);
            return;
        } else {

            TransactionRepository transactionRepository = new TransactionRepository();
            boolean isUpdated = transactionRepository.deleteTransaction(selectedModel);
            if (isUpdated) {
                resetFields();
                selectedModel = null;
                PopUpMessage.popUpMsgBox("Income data deleted!", "Success", WIDTH);
                DashboardPage.instance.refreshAllData();

            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    void resetFields() {
        cmbCategory.setSelectedIndex(0);
        txtAmount.setText("");
        txtNote.setText("");
        dcDate.setDate(new Date());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnDelete;
    private javax.swing.JPanel btnSave;
    private javax.swing.JPanel btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private shorna.moneymanagement.component.ComboBox cmbCategory;
    private com.toedter.calendar.JDateChooser dcDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLayeredPane panel;
    private shorna.moneymanagement.component.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private shorna.moneymanagement.component.Table table;
    private shorna.moneymanagement.component.TextField txtAmount;
    private shorna.moneymanagement.component.TextField txtNote;
    // End of variables declaration//GEN-END:variables
}
