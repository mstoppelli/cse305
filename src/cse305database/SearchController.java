/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

import static cse305database.FXMLDocumentController.actorScene;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

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
    
    public void tableRow(MouseEvent event){
        TableView actorTable = (TableView)actorScene.lookup("#actorTable");
        ObservableList<Actor> temp = actorTable.getSelectionModel().getSelectedItems();
      
        System.out.print("Row clicked " +   temp.get(0).getName());
    }
    
}
