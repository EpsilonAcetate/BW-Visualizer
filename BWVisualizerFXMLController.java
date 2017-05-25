/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bw.visualizer.fxml.ver1.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    
    
    @FXML
    private void handleDisplayButton(ActionEvent event){
        CSVReader c = new CSVReader();
        String input1 = file1TextField.getSelectedText();
        if(!(input1.equals(""))){//checking the field isn't empty
            PowerSpectrum p = new PowerSpectrum(c.readFile(input1));
            //display the powerspectrum animation
        }
    }
    
    @FXML
    private void handleSimilarityTestButton(ActionEvent event) {
        CSVReader c = new CSVReader();
        String input1 = file1TextField.getSelectedText();
        String input2 = file2TextField.getSelectedText();
        if(!((input2.equals("")) && input1.equals(""))){//checking the field isn't empty
            PowerSpectrum p = new PowerSpectrum(c.readFile(input1));
            PowerSpectrum q = new PowerSpectrum(c.readFile(input2));           
            //display the powerspectrum animation of the two graphs
            
        }
    }
    @FXML
    private void handleTest2ButtonAction(ActionEvent event) {
        
         
   }
    
    @FXML
    private void handleTest3Button(ActionEvent event){
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // DO NOTHING
    }    
    
}