import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.animation.KeyFrame;
import javafx.animation.*;
import javafx.util.*;
import javafx.event.EventHandler;
import javafx.event.*;
import java.io.*;

public class AnimTest extends Application {
    double[] n = {0.0333,0.0796,0.821,1.34,5.51,20.5,15.2,2.64,11.0,1.56,5.58,8.2,11.1,22.9,8.66,1.0,2.03,9.05,26.8,29.2,23.0,54.6,45.6,14.6,2.59,0.487,4.39,4.45,8.18,4.29,1.45,5.78,6.31,13.4,0.824,3.62,7.48,39.1,11.7,1.67,1.43,1.9,0.773,3.46,5.09,3.24,7.35,10.5,7.92,4.5,2.89,3.12,2.23,0.63,0.269,0.0111,1.9,4.06,3.54,1.7,0.352,2.9,4.51,6.9,0.997,2.65,7.0,5.34,2.07,0.144,0.173,0.289,0.651,0.0865,0.981,1.02,0.98,1.83,0.384,0.335,0.505,0.232,0.191,1.02,1.61,0.699,0.0568,0.0344,0.533,1.07,0.937,1.25,1.75,1.6,0.117,0.853,0.563,0.237,1.22,0.921,0.641,0.917,0.211,0.182,0.0327,0.499,0.155,0.047,0.00961,0.242,0.0214,0.583,0.563,0.192,0.126,0.387,0.158,0.32,0.857,0.607,0.031,0.112,0.101,0.517,0.175,0.155,0.443,0.603,0.857,0.467,0.287,0.0966,0.243,0.145,0.165,0.237,0.281,0.177,0.00688,0.0202,0.0635,0.0387,0.0147,0.128,0.0565,0.00271,0.0233,0.0295,0.00791,0.00545,0.0142,0.00864,0.00856,0.0421,0.0703,0.0761,0.075,0.0161,0.0153,0.00742,0.0034,0.0157,0.015,5.32E-4,0.0115,0.0116,0.0125,0.0132,0.00325,0.019,0.00629,0.00471,0.00389,0.00262,0.0044,0.00115,0.00502,0.00323,0.00131,0.00377,2.75E-4,1.18E-4,0.00233,0.00564,0.00166,0.00107,0.00398,0.00673,0.00167,0.00135,3.65E-4,3.74E-4};
    double[] m = {0.0125,0.124,1.4,1.78,20.4,22.0,3.84,1.9,4.4,3.48,1.12,8.92,15.4,13.7,31.5,6.75,17.5,5.16,1.22,1.38,8.85,2.92,4.54,5.64,2.63,0.426,2.21,6.75,7.19,3.27,2.85,0.605,0.498,6.3,33.2,11.9,1.89,6.11,5.05,2.02,2.56,4.21,2.6,0.43,4.9,0.98,0.0881,0.626,0.0766,2.1,1.73,1.82,2.45,1.49,0.307,0.672,1.69,0.364,1.89,1.99,1.35,2.41,0.889,1.17,0.508,0.677,1.87,4.39,1.89,0.14,0.601,0.662,0.873,1.33,2.4,1.99,0.475,0.0593,0.31,0.731,0.669,0.565,0.111,1.84,1.98,1.06,2.22,2.21,1.2,0.754,1.8,1.57,1.61,2.27,0.817,1.03,1.32,0.242,0.0253,0.44,1.0,0.602,0.438,0.126,0.283,0.00789,0.448,0.699,0.298,0.26,0.103,1.08,1.17,0.0484,0.696,0.583,0.0241,0.467,0.735,0.698,0.203,0.0744,0.203,0.0771,0.25,0.234,0.0493,0.0539,0.12,0.234,0.327,0.391,0.344,0.0455,0.109,0.159,0.167,0.0528,0.136,0.266,0.055,0.0149,0.0303,0.023,0.0197,0.0614,0.0799,0.105,0.0662,0.0129,0.03,0.0201,0.0155,0.0267,0.00105,0.00505,0.0284,0.0185,0.0342,0.0204,0.00507,0.0197,0.0101,0.0126,0.00534,0.0163,0.0394,0.011,0.0035,0.00196,0.0073,0.0197,0.00813,0.0191,0.0034,0.00515,0.00227,0.0055,0.00828,0.0128,0.0176,0.0179,0.00454,6.13E-4,0.00271,0.0141,0.00607,8.37E-4,9.74E-4,5.55E-4,9.75E-4,0.00244};
    int q = 0;
    @Override public void start(Stage stage) throws FileNotFoundException{
        CSVReader c = new CSVReader();
        PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/s21.powerspec.csv"));
        stage.setTitle("Brainwaves!");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(180);
        xAxis.setTickUnit(10);

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(22.5);
        yAxis.setTickUnit(2);
        xAxis.setLabel("Power");
        yAxis.setLabel("Coefficient");
        final LineChart<Number,Number> lineChart =  new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("Brainwave sample visualization at t=0");
        Scene scene  = new Scene(lineChart,1200,800);
        lineChart.setLegendVisible(false);
   
        stage.setScene(scene);
        stage.show();

        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
        new KeyFrame(Duration.millis(50), 
            new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                    XYChart.Series series3 = new XYChart.Series();
                   // series3.setName("animated?.");
                    for (int i=0;i<170;i+=3) {
                        series3.getData().add(new XYChart.Data(i, p.getVal(q, i)));
                    }
                    lineChart.getData().add(series3);
                    q++;
                    series3.getData().clear();
                }
             }
            ));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.setAutoReverse(true);
        tl.play();
    }

    public void animatePSpec(PowerSpectrum p, Stage stage) {
        stage.setTitle("Brainwaves!");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Power");
        yAxis.setLabel("Coefficient");
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Brainwave sample visualization at t=0");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Prasana's brain");
        //populating the series with data
        for (int i=0;i<180;i+=1) {
            series.getData().add(new XYChart.Data(i, m[i]));
        }
        Scene scene  = new Scene(lineChart,600,400);
        lineChart.getData().add(series);

        lineChart.setLegendVisible(false);
   
        stage.setScene(scene);
        stage.show();

        Timeline tl = new Timeline();
        tl.getKeyFrames().add(
        new KeyFrame(Duration.millis(50), 
            new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                    XYChart.Series series3 = new XYChart.Series();
                   // series3.setName("animated?.");
                    for (int i=0;i<170;i+=4) {
                        series3.getData().add(new XYChart.Data(i, p.getVal(q, i)));
                    }
                    lineChart.getData().add(series3);
                    q++;
                    series3.getData().clear();
                }
             }
            ));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.setAutoReverse(true);
        tl.play(); 
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}