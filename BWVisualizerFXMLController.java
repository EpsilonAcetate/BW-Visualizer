//package bw.visualizer.fxml.ver1.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.chart.LineChart;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.*;

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
 //   @FXML private Pane graphingPane;
    @FXML private LineChart graph1;
    
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
        System.out.println("Hello World?");
    }
    
    @FXML
    private void handleTest3Button(ActionEvent event){
        
    }
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        test2Button.setOnAction(this::handleTest2ButtonAction);
        System.out.println("hello world 0000");
    } 
    public BWVisualizerFXMLController() {
        //do nothing
        System.out.println("hello");
    } 
}