/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

import static cse305database.IMBD.s;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author KelvinWongNYC
 */
public class LogInController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    public void signIn(ActionEvent event){
        Scene s1 = s.getScene();
        TextField username = (TextField)s1.lookup("#username");
        TextField password = (TextField)s1.lookup("#password");
        System.out.print("HEllo world");
    }
    
}
