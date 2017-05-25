package sample;

import javax.swing.*;

import static sample.TableValueSetter.setValue;
import static sample.Tools.display;

/**
 * Created by hp on 18.04.2017.
 */
class TableCreator {

    static JTable createTable(double[][] data, double min, double max) {
        JTable jTable = new JTable(15, 15);
        setValue(jTable, data);

        ColorDistribution ouch=new ColorDistribution(min,max, 15, 15);
        MyColorRenderer cr = new MyColorRenderer(ouch.val,ouch.col,data);
            for (int j = 0; j< data[1].length; j++){
                jTable.getColumnModel().getColumn(j).setCellRenderer(cr);
            }
        for (int i = 0; i < jTable.getColumnCount(); i++) {
            jTable.getColumnModel().getColumn(i).setWidth(jTable.getRowHeight());
        }
        jTable.setRowHeight(18);
        jTable.setEnabled(false);
        return jTable;
    }
}
