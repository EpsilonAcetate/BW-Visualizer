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
    @FXML private TextField file1TextField;
    @FXML private TextField file2TextField;
    @FXML private LineChart graph1;
    @FXML private NumberAxis xAxis;
    @FXML private NumberAxis yAxis;
    @FXML private Text titleText;
    
    @FXML
    private void handleDisplayButton(ActionEvent event){
        /*CSVReader c = new CSVReader();
        String input1 = file1TextField.getSelectedText();
        if(!(input1.equals(""))){//checking the field isn't empty
            PowerSpectrum p = new PowerSpectrum(c.readFile(input1));
            display the powerspectrum animation
        }*/
    }
    
    @FXML
    private void handleSimilarityTestButton(ActionEvent event) throws FileNotFoundException{
     /*   CSVReader c = new CSVReader();
        String input1 = file1TextField.getSelectedText();
        String input2 = file2TextField.getSelectedText();
        if(!((input2.equals("")) && input1.equals(""))){//checking the field isn't empty
            PowerSpectrum p = new PowerSpectrum(c.readFile(input1));
            PowerSpectrum q = new PowerSpectrum(c.readFile(input2));           
            //display the powerspectrum animation of the two graphs*/
            System.out.println("hello");
            
      //  }
    }
    @FXML
    private void handleTest2ButtonAction(ActionEvent event) {
        System.out.println("Button 2 has been pressed.");
        handleGraph();
    }
    
    @FXML
    private void handleTest3ButtonAction(ActionEvent event){
        titleText.setText("New Title YAY");
    }

    int q=0;
    @FXML
    private void handleGraph() {
        //do things
        /*try {
            Stage stage = new Stage();
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
            graph1 = lineChart;
            stage.setScene(scene);
            stage.show();
            System.out.println(p.getLength());
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
                                graph1.getData().add(series3);
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
        } catch (FileNotFoundException e) {
            //do nothing
        }*/
        

        /*try {
            
            for (int j=0;j<5;j++) {
                XYChart.Series series0 = new XYChart.Series();
                for (int i=0;i<170;i+=4) {
                    series0.getData().add(new XYChart.Data(i, p.getVal(j, i)));
                }
                graph1.getData().add(series0);
                try {Thread.sleep(1000);}
                catch (InterruptedException e) {System.out.println("DO NOT INTERRUPT ME.");}
            }
        } catch (FileNotFoundException e) {
            System.out.println("there was a filenotfoundexception!!!!111!");
        }*/




        Timeline tl = new Timeline();
        try {
            CSVReader c = new CSVReader();
            PowerSpectrum p = new PowerSpectrum(c.readFile("powerspec/s21.powerspec.csv"));
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
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        test2Button.setOnAction(this::handleTest2ButtonAction);
        test3Button.setOnAction(this::handleTest3ButtonAction);
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
        graph1.setLegendVisible(false);
     
        System.out.println("hello world 0000");
    } 
    public BWVisualizerFXMLController() {
        //do nothing
        System.out.println("hello");
    } 
}