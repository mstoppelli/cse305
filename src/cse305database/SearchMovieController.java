package cse305database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static cse305database.CSE305Database.getMovieReviews;
import static cse305database.FXMLDocumentController.LOGINGUI;
import static cse305database.FXMLDocumentController.actorScene;
import static cse305database.FXMLDocumentController.movieScence;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
public class SearchMovieController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public static  Scene movieInformation;
    public static Movie one;
    public static  ObservableList<Review> obReview;
    
     @FXML
    public void tableRowClick(MouseEvent event) throws IOException{
        
         if(event.getClickCount()==2){
            TableView movieTable = (TableView)movieScence.lookup("#movieTable");
         ObservableList<Movie> temp = movieTable.getSelectionModel().getSelectedItems();
          one = temp.get(0);
         //Pop Actor Information
         
          Parent root = FXMLLoader.load(getClass().getResource("Movie.fxml"));
            movieInformation = new Scene(root);
            Stage movie = new Stage();
         movie.setTitle("Movie Information");
         
          Text name = (Text)movieInformation.lookup("#name");
         name.setText(one.getName());
          Text director = (Text)movieInformation.lookup("#director");
         director.setText(one.getDirectorName());
            Text genre = (Text)movieInformation.lookup("#genre");
         genre.setText(one.getGenre());
            Text rating = (Text)movieInformation.lookup("#rating");
         rating.setText(""+one.getRating());
         
           Text maturity = (Text)movieInformation.lookup("#maturity");
         maturity.setText(one.getMaturityRating());
          Text duration = (Text)movieInformation.lookup("#duration");
         duration.setText(""+one.getDuration());
         Text release = (Text)movieInformation.lookup("#release");
         release.setText(""+one.getReleaseDate());
         
          TextArea reviewText = (TextArea)movieInformation.lookup("#reviewText");
          Button reviewSubmit = (Button)movieInformation.lookup("#reviewSubmit");
          TextField ratingTextField = (TextField)movieInformation.lookup("#ratingTextField");
          Text errorMessage = (Text)movieInformation.lookup("#errorMessage");
          if(LOGINGUI){
             reviewText.setVisible(true);
             reviewSubmit.setVisible(true);
             ratingTextField.setVisible(true);
             errorMessage.setVisible(false);
         }else{
              reviewText.setVisible(false);
             reviewSubmit.setVisible(false);
             ratingTextField.setVisible(false);
              errorMessage.setVisible(false);
          }
          
          ImageView image = (ImageView)movieInformation.lookup("#image");
        
        
        Image testImage = new Image("/Movie/"+one.getMovieImage());
        if(testImage==null){
            System.out.print("NOT WORKING");
        }
        image.setImage(testImage);
        
        TableView reviewTable = (TableView)movieInformation.lookup("#reviewTable");
         reviewTable.setPlaceholder(new Label("No reviews available"));
         ArrayList<Review> reviewArrayList;
         //COMMENT OUT EVERYTHING HERE!!!
         //Review testReview = new Review("username", 1234,5.4,"AWESOME MOVIE");
         //reviewArrayList = new ArrayList<>();
         //reviewArrayList.add(testReview);
         
         //YOU NEED THIS PART HERE
         reviewArrayList =  getMovieReviews(one.getID());
         if(reviewArrayList.size() != 0){
              obReview = FXCollections.observableArrayList(reviewArrayList);
             
              TableColumn displayName =  (TableColumn) reviewTable.getColumns().get(0);
            displayName.setCellValueFactory(
            new PropertyValueFactory<Review,String>("username")
             );
            
            TableColumn ratingCol =  (TableColumn) reviewTable.getColumns().get(1);
            ratingCol.setCellValueFactory(
            new PropertyValueFactory<Review,Double>("rating")
             );
            
             TableColumn reviewTextCol =  (TableColumn) reviewTable.getColumns().get(2);
            reviewTextCol.setCellValueFactory(
            new PropertyValueFactory<Review,String>("reviewText")
             );
            reviewTable.setItems(obReview);
         }
         
         movie.setScene(movieInformation);
            movie.show();
         }
    }
    
    
    
}
