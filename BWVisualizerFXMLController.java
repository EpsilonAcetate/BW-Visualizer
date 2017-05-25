/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bw.visualizer.fxml.ver1.gui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.*;

/**
 * FXML Controller class
 *
 * @author guthy
 */
public class BWVisualizerFXMLController implements Initializable {
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction1(ActionEvent event) {
  //      label.set("Running Similarity Test");
        AnimTest a = new AnimTest();
        a.start();
         
   }
    
    @FXML
    private void handleButtonAction2(ActionEvent event){
        
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
