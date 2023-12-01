package shorna.moneymanagement.view.dashboard.form;

import shorna.moneymanagement.view.dashboard.model.Model_Card;
import shorna.moneymanagement.component.ScrollBar;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import shorna.moneymanagement.model.SummaryModel;
import shorna.moneymanagement.model.TransactionModel;
import shorna.moneymanagement.repository.TransactionRepository;
import shorna.moneymanagement.session.Session;
import shorna.moneymanagement.view.constant.TransactionType;

public class Home extends javax.swing.JPanel {
    int userId = 0;
    
    

    public Home() {
        initComponents();
        //  add row table
        userId = Session.getUserModel().getId();
                
                
        System.out.println(Session.isIsLoggedIn());
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        
    
        refreshTableData();
        populateHomeData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JLayeredPane();
        card1 = new shorna.moneymanagement.component.Card();
        card2 = new shorna.moneymanagement.component.Card();
        card3 = new shorna.moneymanagement.component.Card();
        panelBorder1 = new shorna.moneymanagement.component.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new shorna.moneymanagement.component.Table();

        setBackground(new java.awt.Color(242, 242, 242));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(127, 127, 127));
        jLabel1.setText("History");

        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SL", "Date", "Transaction Type", "Category", "Note", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false
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
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spTable))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void refreshTableData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        displayDatasWithinTable();
    }

    public void displayDatasWithinTable() {
        TransactionRepository transactionRepository = new TransactionRepository();
        List<TransactionModel> trList = transactionRepository.getAllTransactionList(userId);
        Object[] row = new Object[6];

        for (int i = 0; i < trList.size(); i++) {
            TransactionModel tm = trList.get(i);
            row[0] = String.valueOf(i+1);
            row[1] = tm.getDate();
            TransactionType tt = tm.getTransactionType() == 1 ? TransactionType.income:TransactionType.expense;
            row[2] = tt.name();
            row[3] = tm.getCategory();
            row[4] = tm.getNote();
            row[5] = String.valueOf(tm.getAmount());
            table.addRow(row);
        }

        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
           //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private shorna.moneymanagement.component.Card card1;
    private shorna.moneymanagement.component.Card card2;
    private shorna.moneymanagement.component.Card card3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane panel;
    private shorna.moneymanagement.component.PanelBorder panelBorder1;
    private javax.swing.JScrollPane spTable;
    private shorna.moneymanagement.component.Table table;
    // End of variables declaration//GEN-END:variables

    public void populateHomeData() {
        TransactionRepository transactionRepository = new TransactionRepository();
        SummaryModel sm = transactionRepository.getSummary(userId);

        card1.setData(new Model_Card(new ImageIcon(getClass()
                .getResource("/shorna/moneymanagement/images/profit.png")), "Income", "৳"+sm.getTotalIncome(), ""));
        
        card2.setData(new Model_Card(new ImageIcon(getClass()
                .getResource("/shorna/moneymanagement/images/stock.png")), "Expense", "৳"+sm.getTotalExpense(), ""));
        
        card3.setData(new Model_Card(new ImageIcon(getClass()
                .getResource("/shorna/moneymanagement/images/flag.png")), "Balance", "৳"+(sm.getTotalIncome() - sm.getTotalExpense()), ""));

    }
}
