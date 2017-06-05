//package bw.visualizer.fxml.ver1.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.chart.LineChart;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
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
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author guthy
 */
public class BWVisualizerFXMLController implements Initializable {
    @FXML private Button noTestButton;
    @FXML private Button simButton;
    @FXML private Button test2Button;
    @FXML private Button test3Button;
    @FXML private Button file1Button;
    @FXML private Button file2Button;
    @FXML private TextField file1TextField;
    @FXML private TextField file2TextField;
    @FXML private LineChart graph1;
    @FXML private LineChart graph2;
    @FXML private LineChart graph3;
    @FXML private NumberAxis xAxis1;
    @FXML private NumberAxis yAxis1;
    @FXML private NumberAxis xAxis2;
    @FXML private NumberAxis yAxis2;
    @FXML private NumberAxis xAxis3;
    @FXML private NumberAxis yAxis3;
    @FXML private Text titleText;

    private static final CSVReader CSVREADER = new CSVReader();
    private String input1;
    private String input2;
    @FXML
    private void handleTextField1ConfirmButton(ActionEvent event){
        input1 = file1TextField.getText();
        System.out.println("testing confirm 1 button");
    }

    @FXML
    private void handleTextField2ConfirmButton(ActionEvent event) {
        input2 = file2TextField.getText();
        System.out.println("testing confirm 2 button");
    }
    @FXML
    private void handleDisplayButton(ActionEvent event) {
        handleGraph1();
        handleGraph2();
        handleGraph3();
    }
    
    @FXML
    private void handleSimilarityTestButton(ActionEvent event) {
        handleGraph3();
    }
    @FXML
    private void handleTest2ButtonAction(ActionEvent event) {
        handleGraph1();
    }
    
    @FXML
    private void handleTest3ButtonAction(ActionEvent event){
        handleGraph2();
    }

    int q=0;
    @FXML
    private void handleGraph1() {
        Timeline tl = new Timeline();
        try {
            CSVReader c = new CSVReader();
            PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/"+input1));
            System.out.println("hello");
            tl.getKeyFrames().add(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                    try {
                        XYChart.Series series = new XYChart.Series();
                        for (int i=0;i<170;i+=4) {
                            series.getData().add(new XYChart.Data(i, p.getVal(q, i)));
                        }
                        graph1.getData().add(series);
                        System.out.println("okay.");
                        q++;
                        series.getData().removeAll(series.getData());
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.out.println("an excpetion was caught.");
                    }
                }
            }));
            tl.setCycleCount(Animation.INDEFINITE);
            tl.setAutoReverse(true);
            tl.play();
        } catch (Exception e) {
            System.out.println("there was an exception caught.");
        }
    }

    int q2=0;
    @FXML
    private void handleGraph2() {
        Timeline tl = new Timeline();
        try {
            CSVReader c = new CSVReader();
            PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/"+input2));
            System.out.println("hello");
            tl.getKeyFrames().add(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent actionEvent) {
                    try {
                        XYChart.Series series = new XYChart.Series();
                        for (int i=0;i<170;i+=4) {
                            series.getData().add(new XYChart.Data(i, p.getVal(q2, i)));
                        }
                        graph2.getData().add(series);
                        System.out.println("okay.");
                        q2++;
                        series.getData().removeAll(series.getData());
                    }
                    catch (IndexOutOfBoundsException e) {
                        //do nothing.
                    }
                }
            }));
            tl.setCycleCount(Animation.INDEFINITE);
            tl.setAutoReverse(true);
            tl.play();
        } catch (Exception e) {
            System.out.println("there was an exception caught.");
        }
    }

    int q3 = 0;
    private void handleGraph3() {
        Timeline tl = new Timeline();
        try {
            CSVReader c = new CSVReader();
            PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/"+input1));
            PowerSpectrum p2 = new PowerSpectrum(c.readFile("powerspec/"+input2));
            tl.getKeyFrames().add(
                new KeyFrame(Duration.millis(200), 
                        new EventHandler<ActionEvent>() {
                        @Override public void handle(ActionEvent actionEvent) {
                            XYChart.Series series3 = new XYChart.Series();
                            series3.getData().add(new XYChart.Data(q3, p.similarity(p2, q3, "cosine")));
                            series3.getData().add(new XYChart.Data(q3+1, p.similarity(p2, q3+1, "cosine")));
                            graph3.getData().add(series3);
                            q3++;
                            //series3.getData().clear();
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

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        file1Button.setOnAction(this::handleTextField1ConfirmButton);
        file2Button.setOnAction(this::handleTextField2ConfirmButton);
        noTestButton.setOnAction(this::handleDisplayButton);
        simButton.setOnAction(this::handleSimilarityTestButton);
        test2Button.setOnAction(this::handleTest2ButtonAction);
        test3Button.setOnAction(this::handleTest3ButtonAction);
        
        xAxis1.setAutoRanging(false);
        xAxis1.setLowerBound(0);
        xAxis1.setUpperBound(180);
        xAxis1.setTickUnit(10);
        yAxis1.setAutoRanging(false);
        yAxis1.setLowerBound(0);
        yAxis1.setUpperBound(10);
        yAxis1.setTickUnit(2);
        xAxis1.setLabel("Power");
        yAxis1.setLabel("Coefficient");   
        
        xAxis2.setAutoRanging(false);
        xAxis2.setLowerBound(0);
        xAxis2.setUpperBound(180);
        xAxis2.setTickUnit(10);
        yAxis2.setAutoRanging(false);
        yAxis2.setLowerBound(0);
        yAxis2.setUpperBound(10);
        yAxis2.setTickUnit(2);
        xAxis2.setLabel("Power");
        yAxis2.setLabel("Coefficient");

        xAxis3.setAutoRanging(false);
        xAxis3.setLowerBound(0);
        xAxis3.setUpperBound(180);
        xAxis3.setTickUnit(10);

        yAxis3.setAutoRanging(false);
        yAxis3.setLowerBound(0);
        yAxis3.setUpperBound(1);
        yAxis3.setTickUnit(0.1);
        xAxis3.setLabel("Time");
        yAxis3.setLabel("Similarity");
        
        graph1.setLegendVisible(false);
        graph2.setLegendVisible(false);
        graph3.setLegendVisible(false);

        System.out.println("hello world 0000");
    } 
    public BWVisualizerFXMLController() {
        //do nothing
        System.out.println("hello");
    } 
}