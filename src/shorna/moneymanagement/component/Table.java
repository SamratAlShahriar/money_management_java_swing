package shorna.moneymanagement.component;

import shorna.moneymanagement.view.dashboard.model.StatusType;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                switch (i1) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        header.setHorizontalAlignment(JLabel.LEFT);
                        break;
                    default:
                        header.setHorizontalAlignment(JLabel.CENTER);

                }

                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                //if (i1 != 4) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                com.setBackground(Color.WHITE);
                setBorder(noFocusBorder);
                if (selected) {
                    com.setForeground(new Color(15, 89, 140));
                } else {
                    com.setForeground(new Color(102, 102, 102));
                }
                return com;
                //} 
//                else {
//                    StatusType type = (StatusType) o;
//                    CellStatus cell = new CellStatus(type);
//                    return cell;
//                }
            }
        });
        
       

    }

    @Override
    public synchronized void addMouseListener(MouseListener l) {
        super.addMouseListener(l); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }
}
