package sample;


/**
 * Created by hp on 18.04.2017.
 */
public class Tools {
    static double maxMat;
    static double minMat;

    public static double maxMatrix(double[][] array) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                if (array[i][j] > max) max = array[i][j];
            }
        }
        return max;
    }

    public static double maxMatrix(double[][] mat1, double[][] mat2, double[][] mat3) {
        maxMat = maxMatrix(mat1);
        if (maxMatrix(mat2) > maxMat) maxMat = maxMatrix(mat2);
        if (maxMatrix(mat3) > maxMat) maxMat = maxMatrix(mat3);
        return maxMat;


    }

    public static double minMatrix(double[][] array) {
        double min = Long.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[1].length; j++) {
                if (array[i][j] < min) min = array[i][j];
            }
        }
        return min;
    }

    public static double minMatrix(double[][] mat1, double[][] mat2, double[][] mat3) {
        minMat = minMatrix(mat1);
        if (minMatrix(mat2) < minMat) minMat = minMatrix(mat2);
        if (minMatrix(mat3) < minMat) minMat = minMatrix(mat3);
        return minMat;
    }
    public static void display(double[][] mat){
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[1].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static double[][] copyMatrix(double[][] sourceMatrix){
        double[][]disMatrix=new double[sourceMatrix.length][sourceMatrix[1].length];
        for (int i=0;i<sourceMatrix.length;i++){
            for (int j=0;j<sourceMatrix[1].length;j++){
                disMatrix[i][j]=sourceMatrix[i][j];
            }
        }
        return disMatrix;
    }
}
