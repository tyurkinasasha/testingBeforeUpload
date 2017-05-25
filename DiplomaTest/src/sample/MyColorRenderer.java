package sample;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

import static sample.Main.*;
import static sample.Tools.maxMatrix;

/**
 * Created by hp on 18.04.2017.
 */
//class MyColorRenderer extends DefaultTableCellRenderer {
class MyColorRenderer extends JLabel implements TableCellRenderer {
    Color[] colors;
    double[] values;
    static double[][] T1 = MatrixCounter.matA;
    static double[][] T2 = MatrixCounter.matB;
    double[][]data;


    public MyColorRenderer(double[] value, Color[] col,double data[][]) {
        this.colors = col;
        this.values = value;
        this.data=data;
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        double tmp = (Double) table.getValueAt(row, column);
        for (int i = 0; i < colors.length - 1; i++) {
            if (tmp >= values[i] && tmp < values[i + 1]
                    ) {
                //c.setBackground(colors[i]);
                setBackground(colors[i]);
                //setToolTipText("Value is "+table.getValueAt(row,column));
                setToolTipText("T1[" + (row + 1) + "][" + (column + 1) + "] = " + T1[row][column]
                        + ", T2[" + (row + 1) + "][" + (column + 1) + "] = " + T2[row][column]);
            }

            if (tmp==maxMatrix(data)){
                setBackground(colors[i]);
                setToolTipText("T1[" + (row + 1) + "][" + (column + 1) + "] = " + T1[row][column]
                        + ", T2[" + (row + 1) + "][" + (column + 1) + "] = " + T2[row][column]);
            }

        }
        //return c;
        return this;
    }
}