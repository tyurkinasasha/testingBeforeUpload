package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.embed.swing.SwingNode;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import static sample.TableCreator.*;
import static sample.MatrixCounter.*;
import static sample.Tools.*;

import javax.swing.*;

public class Main extends Application {
    Stage window;
    private static double[][] matrix1 = new double[15][15];
    private static double[][] matrix2 = new double[15][15];
    private static double[][] matrix3 = new double[15][15];
    private static double[][] prevMatrix1, prevMatrix2, prevMatrix3;
    static double prevMin1, prevMin2, prevMin3, prevMax1, prevMax2, prevMax3, min1, min2, min3, max1, max2, max3;
    private static double prevParamSE1, prevParamSE2, prevParamGE1, prevParamGE2, prevParamSWI1, prevParamSWI2;
    private static Scene scene;
    private static Label prevLabel1, prevLabel2, prevLabel3;
    private static JTable table1, table2, table3, prevTable1, prevTable2, prevTable3;

    public static Label createAndSetUpLabel(String textLabel) {
        Label label = new Label(textLabel);
        label.setFont(Font.font("Bodoni MT Condensed", 30));
        label.setTextFill(Color.BLACK);
        return label;

    }

    public static GridPane createAndSetUpLayout() {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(7);
        gridPane.setHgap(7);
        gridPane.setPadding(new Insets(5, 10, 5, 10));
        gridPane.setPrefWidth(screen.getWidth() / 3.1);
        return gridPane;
    }

    public static Label createAndSetUpPrevLabel(double p1, double p2, String s1, String s2) {
        Label label = new Label("Previous parameters: " + s1 + "=" + p1 + "," + s2 + "=" + p2);
        label.setFont(Font.font("Bodoni MT Condensed", 20));
        label.setTextFill(Color.BLACK);
        return label;
    }

    private static DropShadow shadow = new DropShadow();
    private static Rectangle2D screen = Screen.getPrimary().getVisualBounds();

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        initMat();
        //CREATING LAYOUTS

        BorderPane mainLayout = new BorderPane();

        GridPane gridPane1 = createAndSetUpLayout();

        GridPane gridPane2 = createAndSetUpLayout();

        GridPane gridPane3 = createAndSetUpLayout();

        //LAYOUT1
        gridPane1.setAlignment(Pos.BASELINE_CENTER);
        Label methodLabelSE = createAndSetUpLabel("SE");

        gridPane1.add(methodLabelSE, 0, 0, 3, 1);
        GridPane.setHalignment(methodLabelSE, HPos.RIGHT);

        TextField textSE1 = new TextField();
        textSE1.setPromptText("input TE");
        gridPane1.add(textSE1, 0, 1, 2, 1);

        TextField textSE2 = new TextField();
        textSE2.setPromptText("input TR");
        gridPane1.add(textSE2, 2, 1, 2, 1);


        //LAYOUT2
        gridPane2.setAlignment(Pos.BASELINE_CENTER);
        Label methodLabelGE = createAndSetUpLabel("GE");
        GridPane.setHalignment(methodLabelGE, HPos.RIGHT);
        gridPane2.add(methodLabelGE, 0, 0, 3, 1);

        TextField textGE1 = new TextField();
        textGE1.setPromptText("input TE");
        gridPane2.add(textGE1, 0, 1, 2, 1);

        TextField textGE2 = new TextField();
        textGE2.setPromptText("input TR");
        gridPane2.add(textGE2, 2, 1, 2, 1);

        //LAYOUT3
        gridPane3.setAlignment(Pos.BASELINE_CENTER);
        Label methodLabelSWI = createAndSetUpLabel("SWI");
        GridPane.setHalignment(methodLabelSWI, HPos.RIGHT);
        gridPane3.add(methodLabelSWI, 0, 0, 3, 1);

        TextField textSWI1 = new TextField();
        textSWI1.setPromptText("input TE");
        gridPane3.add(textSWI1, 0, 1, 2, 1);

        TextField textSWI2 = new TextField();
        textSWI2.setPromptText("input TR");
        gridPane3.add(textSWI2, 2, 1, 2, 1);

        Button but = new Button("Count");
        but.setEffect(shadow);
        but.styleProperty().bind(Bindings.format("-fx-base: #df9448;"));
        but.setAlignment(Pos.BOTTOM_CENTER);
        but.setPrefWidth(screen.getWidth());

        //setting position of layouts
        mainLayout.setLeft(gridPane1);
        mainLayout.setCenter(gridPane2);
        mainLayout.setRight(gridPane3);
        mainLayout.setBottom(but);


        //BUTTON PRESSED
        but.setOnAction(event -> {
            par11 = Double.parseDouble(textSE1.getText());
            par12 = Double.parseDouble(textSE2.getText());
            par21 = Double.parseDouble(textGE1.getText());
            par22 = Double.parseDouble(textGE2.getText());
            par31 = Double.parseDouble(textSWI1.getText());
            par32 = Double.parseDouble(textSWI2.getText());

            matrix1 = matrixSE(matrix1);
            matrix2 = matrixGE(matrix2);
            matrix3 = matrixSWI(matrix3);

            //CHANGED
            min1 = minMatrix(matrix1);
            min2 = minMatrix(matrix2);
            min3 = minMatrix(matrix3);
            max1 = maxMatrix(matrix1);
            max2 = maxMatrix(matrix2);
            max3 = maxMatrix(matrix3);

            SwingNode swingNode11 = new SwingNode();
            SwingNode swingNode21 = new SwingNode();
            SwingNode swingNode31 = new SwingNode();


            table1 = createTable(matrix1, min1, max1);
            swingNode11.setContent(table1);
            gridPane1.add(swingNode11, 0, 2, 4, 1);

            table2 = createTable(matrix2, min2, max2);
            swingNode21.setContent(table2);
            gridPane2.add(swingNode21, 0, 2, 4, 1);

            table3 = createTable(matrix3, min3, max3);
            swingNode31.setContent(table3);
            gridPane3.add(swingNode31, 0, 2, 4, 1);

            if (prevMatrix1 != null) {
                SwingNode swingNode12 = new SwingNode();
                SwingNode swingNode22 = new SwingNode();
                SwingNode swingNode32 = new SwingNode();
                gridPane1.getChildren().remove(prevLabel1);
                gridPane2.getChildren().remove(prevLabel2);
                gridPane3.getChildren().remove(prevLabel3);
                //noinspection SuspiciousMethodCalls
                gridPane1.getChildren().remove(prevTable1);
                //noinspection SuspiciousMethodCalls
                gridPane2.getChildren().remove(prevTable2);
                //noinspection SuspiciousMethodCalls
                gridPane3.getChildren().remove(prevTable3);

                prevLabel1 = createAndSetUpPrevLabel(prevParamSE1, prevParamSE2, "TE", "TR");
                GridPane.setHalignment(prevLabel1, HPos.CENTER);
                gridPane1.add(prevLabel1, 0, 3, 4, 1);
                prevLabel2 = createAndSetUpPrevLabel(prevParamGE1, prevParamGE2, "TE", "TR");
                GridPane.setHalignment(prevLabel2, HPos.CENTER);
                gridPane2.add(prevLabel2, 0, 3, 4, 1);
                prevLabel3 = createAndSetUpPrevLabel(prevParamSWI1, prevParamSWI2, "TE", "TR");
                GridPane.setHalignment(prevLabel3, HPos.CENTER);
                gridPane3.add(prevLabel3, 0, 3, 4, 1);

                prevTable1 = createTable(prevMatrix1, prevMin1, prevMax1);
                swingNode12.setContent(prevTable1);
                prevTable2 = createTable(prevMatrix2, prevMin2, prevMax2);
                swingNode22.setContent(prevTable2);
                prevTable3 = createTable(prevMatrix3, prevMin3, prevMax3);
                swingNode32.setContent(prevTable3);
                gridPane1.add(swingNode12, 0, 4, 4, 1);
                gridPane2.add(swingNode22, 0, 4, 4, 1);
                gridPane3.add(swingNode32, 0, 4, 4, 1);

            }
            prevMatrix1 = copyMatrix(matrix1);
            prevMatrix2 = copyMatrix(matrix2);
            prevMatrix3 = copyMatrix(matrix3);

            prevMin1 = minMatrix(prevMatrix1);
            prevMin2 = minMatrix(prevMatrix2);
            prevMin3 = minMatrix(prevMatrix3);

            prevMax1 = maxMatrix(prevMatrix1);
            prevMax2 = maxMatrix(prevMatrix2);
            prevMax3 = maxMatrix(prevMatrix3);

            prevParamSE1 = par11;
            prevParamSE2 = par12;
            prevParamGE1 = par21;
            prevParamGE2 = par22;
            prevParamSWI1 = par31;
            prevParamSWI2 = par32;

        });
        scene = new Scene(mainLayout, screen.getWidth(), screen.getHeight(), Color.BLACK);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
