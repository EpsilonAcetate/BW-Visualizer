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
    @FXML private NumberAxis xAxis;
    @FXML private NumberAxis yAxis;
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
        //try {//checking the field isn't empty
            //PowerSpectrum p = new PowerSpectrum(c.readFile(input1));
            System.out.println("testing textfield1 received valid input");
            /* display the powerspectrum animation*/
        //} catch (FileNotFoundException f){
            //do nothing
        //}
    }
    
    @FXML
    private void handleSimilarityTestButton(ActionEvent event) {
        //checking the field isn't empty 
            //PowerSpectrum p = new PowerSpectrum(c.readFile(input1));
           // PowerSpectrum q = new PowerSpectrum(c.readFile(input2));           
            //display the powerspectrum animation of the two graphs
            //System.out.println("hello");
             System.out.println("testing textfield1 and 2 rec");
    }
    @FXML
    private void handleTest2ButtonAction(ActionEvent event) {
        System.out.println("Button 2 has been pressed.");
        handleGraph1();
    }
    
    @FXML
    private void handleTest3ButtonAction(ActionEvent event){
        //titleText.setText("New Title YAY");
    }

    int q=0;
    @FXML
    private void handleGraph1() {
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
        file1Button.setOnAction(this::handleTextField1ConfirmButton);
        file2Button.setOnAction(this::handleTextField2ConfirmButton);
        noTestButton.setOnAction(this::handleDisplayButton);
        simButton.setOnAction(this::handleSimilarityTestButton);
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