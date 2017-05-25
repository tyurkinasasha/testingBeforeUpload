package sample;
import javax.swing.*;
/**
 * Created by hp on 18.04.2017.
 */
public class TableValueSetter {
    public static JTable setValue(JTable jTable, double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                jTable.setValueAt(array[i][j], i, j);
            }
        }
        return jTable;
    }
}
