package sample;

import static java.lang.StrictMath.*;
import static sample.Tools.copyMatrix;
import static sample.Tools.display;

/**
 * Created by hp on 18.04.2017.
 */
public class MatrixCounter {
    final static float k = 1, p = 1, theta = 15;
    static double par11,par12,par21,par22,par31,par32;
    static double[][] matA = new double[15][15];
    static double[][] matB = new double[15][15];
    private static float val1A = 551, val2A = 564, val3A = 524, val1B = 56, val2B = 60, val3B = 63;
    private static final float[] fttParams = new float[]{0.588f, 0.113f, 0.598f, 0.188f, 0.618f, 0.82f,
            0.126f, 0.345f, 0.126f, 0.82f, 0.618f, 0.188f, 0.598f, 0.113f, 0.588f};

    public static double[][] matrixSE(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[1].length; j++) {
                mat[i][j] = functionSE(i, j);
            }
        }
        return mat;
    }

    private static double functionSE(int i, int j) {
        return k * p * (1 - exp(-par11 / matA[i][j])) * exp(-par12 / matB[i][j]);
    }

    public static double[][] matrixGE(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[1].length; j++) {
                mat[i][j] = functionGE(i, j);
            }
        }
        return mat;

    }

    private static double functionGE(int i, int j) {
        return k * p * (1 - exp(-par21 / matA[i][j])) * ((sin(toRadians(theta))
                * exp(-par22 / matB[i][j])) / (1 - cos(toRadians(theta)) * exp(-par21 / matA[i][j])));
    }

    public static double[][] matrixSWI(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = functionSWI(i,j) + fttParams[j];
            }
        }
        return mat;
    }
    public static double functionSWI(int i,int j){
        return k * p * (1 - exp(-par31 / matA[i][j])) * ((sin(toRadians(theta))
                * exp(-par32 / matB[i][j])) / (1 - cos(toRadians(theta)) * exp(-par31 / matA[i][j])));
    }

    public static void setSquare(double val, int side, double[][] mat) {
        for (int i = 7 - (side - 1) / 2; i < 8 + (side - 1) / 2; i++) {
            for (int j = 7 - (side - 1) / 2; j < 8 + (side - 1) / 2; j++) {
                mat[i][j] = val;

            }

        }
    }

    public static void setConMat(double[][] mat, double val1, double val2, double val3) {
        setSquare(val1, 15, mat);
        setSquare(val2, 11, mat);
        setSquare(val3, 5, mat);
    }

    public static void initMat() {
        setConMat(matA, val1A, val2A, val3A);
        setConMat(matB, val1B, val2B, val3B);
    }
}
