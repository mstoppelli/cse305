/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

import static cse305database.FXMLDocumentController.setWelcomeText;
import static cse305database.FXMLDocumentController.stageLogin;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
     
    }
    @FXML
    public void signIn(ActionEvent event){
        Scene s1 = stageLogin.getScene();
        TextField username = (TextField)s1.lookup("#username");
        TextField password = (TextField)s1.lookup("#password");
        Text error = (Text)s1.lookup("#error");
        User user = CSE305Database.loginUser(username.getText(), password.getText());
        if(user==null){
            error.setVisible(true);
        }else{
            error.setVisible(false);
            setWelcomeText(user);
            stageLogin.close();
        }
        
    }
    public static Stage accountStage = null;
    public void linkCreateAccount(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Create Account.fxml"));
        Scene scene = new Scene(root);
         accountStage = new Stage();
        accountStage.setTitle("Create Account");
        accountStage.setScene(scene);
        accountStage.show();
         stageLogin.close();
    }
    
}
