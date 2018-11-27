/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

import static cse305database.IMBD.s;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author KelvinWongNYC
 */
public class FXMLDocumentController implements Initializable {
   
    public static Stage stageLogin = null;
    
    public static void setWelcomeText(User user){
        Scene s1 = s.getScene();
        Text t = (Text)s1.lookup("#welcome");
        t.setVisible(true);
        t.setText("Welcome " + user.getDisplayName() + "!");
        
        
        Button b = (Button)s1.lookup("#button");
       b.setVisible(false);
        Button logout = (Button)s1.lookup("#button1");
       logout.setVisible(true);
    }
    
    @FXML
    private void logout(ActionEvent event) {
        Scene s1 = s.getScene();
        
        Text t = (Text)s1.lookup("#welcome");
        t.setVisible(false);
        t.setText("");
        
        Button b = (Button)s1.lookup("#button");
        b.setVisible(true);
        Button logout = (Button)s1.lookup("#button1");
       logout.setVisible(false);
       //Remove Label!
    }
    
    @FXML
    private void movie(ActionEvent event) {
        Scene s1 = s.getScene();
   SplitMenuButton split = (SplitMenuButton)s1.lookup("#menuButton");
        split.setText("Movie"); 
    }
     @FXML
     private void actor(ActionEvent event) {
         Scene s1 = s.getScene();
   SplitMenuButton split = (SplitMenuButton)s1.lookup("#menuButton");
        split.setText("Actor"); 
    }
      @FXML
     private void director(ActionEvent event) {
         Scene s1 = s.getScene();
   SplitMenuButton split = (SplitMenuButton)s1.lookup("#menuButton");
        split.setText("Director"); 
    }
    
     @FXML
    private void login(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Log In.fxml"));
        Scene scene = new Scene(root);
         stageLogin = new Stage();
        stageLogin.setTitle("Login");
        stageLogin.setScene(scene);
        stageLogin.show();
    }
      
     @FXML
    private void viewHomePage(MouseEvent event){
        
        Scene s1 = s.getScene();
        Text m = (Text)s1.lookup("#movie");
        m.setVisible(true);
        Text b = (Text)s1.lookup("#birthday");
        b.setVisible(true);
        
        ImageView pirates = (ImageView) s1.lookup("#Pirates");
        pirates.setVisible(true);
        ImageView avatar = (ImageView) s1.lookup("#Avatar");
        avatar.setVisible(true);
        ImageView legend = (ImageView) s1.lookup("#legend");
        legend.setVisible(true);
        ImageView polar = (ImageView) s1.lookup("#polar");
        polar.setVisible(true);
        ImageView up = (ImageView) s1.lookup("#up");
        up.setVisible(true);
        ImageView brad = (ImageView) s1.lookup("#brad");
        brad.setVisible(true);
        ImageView sarah = (ImageView) s1.lookup("#sarah");
        sarah.setVisible(true);
        ImageView cch = (ImageView) s1.lookup("#cch");
        cch.setVisible(true);
         ImageView steve = (ImageView) s1.lookup("#steve");
        steve.setVisible(true);
         ImageView jeff = (ImageView) s1.lookup("#jeff");
        jeff.setVisible(true);    
    }
    @FXML
    private void search(MouseEvent event){
        clearScreen(event);
    }
     @FXML
     private void clearScreen(MouseEvent event) {
        Scene s1 = s.getScene();
        Text m = (Text)s1.lookup("#movie");
        m.setVisible(false);
        Text b = (Text)s1.lookup("#birthday");
        b.setVisible(false);
        
        ImageView pirates = (ImageView) s1.lookup("#Pirates");
        pirates.setVisible(false);
        ImageView avatar = (ImageView) s1.lookup("#Avatar");
        avatar.setVisible(false);
        ImageView legend = (ImageView) s1.lookup("#legend");
        legend.setVisible(false);
        ImageView polar = (ImageView) s1.lookup("#polar");
        polar.setVisible(false);
        ImageView up = (ImageView) s1.lookup("#up");
        up.setVisible(false);
        ImageView brad = (ImageView) s1.lookup("#brad");
        brad.setVisible(false);
        ImageView sarah = (ImageView) s1.lookup("#sarah");
        sarah.setVisible(false);
        ImageView cch = (ImageView) s1.lookup("#cch");
        cch.setVisible(false);
         ImageView steve = (ImageView) s1.lookup("#steve");
        steve.setVisible(false);
         ImageView jeff = (ImageView) s1.lookup("#jeff");
        jeff.setVisible(false);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
