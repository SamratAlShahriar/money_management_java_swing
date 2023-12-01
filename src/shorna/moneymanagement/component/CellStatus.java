package shorna.moneymanagement.component;

import shorna.moneymanagement.view.dashboard.model.StatusType;

public class CellStatus extends javax.swing.JPanel {

     public CellStatus(StatusType type) {
        initComponents();
        status.setType(type);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

       status = new shorna.moneymanagement.component.TableStatus();

        setBackground(new java.awt.Color(255, 255, 255));

        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("tableStatus1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private shorna.moneymanagement.component.TableStatus status;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
