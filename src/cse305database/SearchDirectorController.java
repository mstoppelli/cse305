package cse305database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static cse305database.FXMLDocumentController.actorScene;
import static cse305database.FXMLDocumentController.directorScene;
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

/**
 * FXML Controller class
 *
 * @author KelvinWongNYC
 */
public class SearchDirectorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void selectDirectorTable(MouseEvent event) throws IOException{
        if(event.getClickCount()==2){
         TableView directorTable = (TableView)directorScene.lookup("#directorTable");
          ObservableList<Director> temp = directorTable.getSelectionModel().getSelectedItems();
         Director one = temp.get(0);
         
          Parent root = FXMLLoader.load(getClass().getResource("Director.fxml"));
           Scene directorInformation = new Scene(root);
            Stage director = new Stage();
         director.setTitle("Director Information");
         
         Text name = (Text)directorInformation.lookup("#name");
         name.setText(one.getName());
         
           Text age = (Text)directorInformation.lookup("#age");
         age.setText(""+one.getAge());
         
         //set photo
         
          ImageView image = (ImageView)directorInformation.lookup("#directorImage");
        Image testImage = new Image("/Directors/"+one.getName()+".jpg");
        if(testImage==null){
            System.out.print("NOT WORKING");
        }
        image.setImage(testImage);
         
          director.setScene(directorInformation);
        director.show();
         
        }
    }
    
}
