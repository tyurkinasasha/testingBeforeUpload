package sample;

import java.awt.*;

/**
 * Created by hp on 18.04.2017.
 */
public class ColorDistribution {
    Color[] col;
    double[] val;

    public ColorDistribution(double min, double max, int row, int column) {
        this.col = colorDistributor(row, column);
        this.val = valueDistributor(row, column, min, max);
    }
    //ITS NOT DISTRIBUTED BETWEEN NUMBERS ITS JUST DISTRIBUTED CONSTANTLY
    public Color[] colorDistributor(int row, int column) {
        Color [] result1 = new Color[row * column];
        int k = 255;
        for (int i = 0; i < result1.length; i++) {
            result1[i] = new Color(k, k, k);
            k--;
        }
        return result1;
    }

    public double[] valueDistributor(int row, int column, double min, double max) {
        double[] result2 = new double[row * column];
        double step = (max - min) / (row * column);
        double add = 0;
        for (int i = 0; i < result2.length; i++) {
            result2[i] = min + add;
            add += step;
        }
        return result2;
    }

}
