/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;
import static cse305database.FXMLDocumentController.setWelcomeText;

import static cse305database.CSE305Database.registerUser;

import static cse305database.LogInController.accountStage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author KelvinWongNYC
 */
public class CreateAccountController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    public void createAccount(ActionEvent event){
        Scene s1 = accountStage.getScene();
        TextField user = (TextField)s1.lookup("#userCreate");
        TextField pass = (TextField)s1.lookup("#passCreate");
        TextField display = (TextField)s1.lookup("#displayCreate");
        TextField email = (TextField)s1.lookup("#emailCreate");
         Text errorCreate = (Text)s1.lookup("#errorCreate");
        String result = registerUser(user.getText(), pass.getText(), email.getText(), display.getText());
        if(result.equals("True")){
            errorCreate.setVisible(false);
            setWelcomeText(display.getText());
            accountStage.close();
        }else{
            errorCreate.setText(result);
            errorCreate.setVisible(true);
        }
    }
    
}
