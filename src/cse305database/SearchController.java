/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

import static cse305database.FXMLDocumentController.actorScene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author KelvinWongNYC
 */
public class SearchController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void tableRow(MouseEvent event) throws IOException{
        if(event.getClickCount()==2){
            TableView actorTable = (TableView)actorScene.lookup("#actorTable");
         ObservableList<Actor> temp = actorTable.getSelectionModel().getSelectedItems();
         Actor one = temp.get(0);
         //Pop Actor Information
         
          Parent root = FXMLLoader.load(getClass().getResource("Actor.fxml"));
           Scene actorInformation = new Scene(root);
            Stage actor = new Stage();
         actor.setTitle("Actor Information");
         
         Text name = (Text)actorInformation.lookup("#name");
         name.setText(one.getName());
         
          Text height = (Text)actorInformation.lookup("#height");
         height.setText(""+one.getHeight());
         
          Text birthday = (Text)actorInformation.lookup("#birthday");
         birthday.setText(one.getBirthday().toString());
         
           Text gender = (Text)actorInformation.lookup("#gender");
         gender.setText(one.getGender());
         
          ImageView image = (ImageView)actorInformation.lookup("#image");
         
        
        Image testImage = new Image("/Actors/"+one.getName()+".jpg");
        if(testImage==null){
            System.out.print("NOT WORKING");
        }
        image.setImage(testImage);
         
         actor.setScene(actorInformation);
        actor.show();
            
        }
        
    }
    
}
