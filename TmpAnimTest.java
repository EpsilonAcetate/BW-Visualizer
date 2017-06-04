
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

public class TmpAnimTest extends Application {
    int q = 0;
    @Override public void start(Stage stage) throws FileNotFoundException{
        CSVReader c = new CSVReader();
        PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/s21.powerspec.csv"));
        PowerSpectrum p2 = new PowerSpectrum(c.readFile("powerspec/s12.powerspec.csv"));

        stage.setTitle("Brainwaves!");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);
        xAxis.setUpperBound(180);
        xAxis.setTickUnit(10);

        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(10);
        yAxis.setTickUnit(2);
        xAxis.setLabel("Power");
        yAxis.setLabel("Coefficient");
        final LineChart<Number,Number> lineChart =  new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("Brainwave sample visualization at t=0");
        Scene scene  = new Scene(lineChart,1200,800);
        lineChart.setLegendVisible(false);
   
        stage.setScene(scene);
        stage.show();
       // System.out.println(p.getLength());
        Timeline tl = new Timeline();
        try {
            System.out.println("hello");
            tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(50), 
                        new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent actionEvent) {
                            XYChart.Series series3 = new XYChart.Series();
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
        } catch (Exception e) {
            //do nada
        }
    }
 
    public static void main(String[] args) {
        launch();
    }
    public static void startAnimation() {
        launch();
    }
}