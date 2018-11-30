package cse305database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static cse305database.CSE305Database.addReview;
import static cse305database.CSE305Database.getMovie;
import static cse305database.FXMLDocumentController.LOGINGUI;
import static cse305database.FXMLDocumentController.currentUser;
import static cse305database.FXMLDocumentController.movieScence;
import static cse305database.SearchMovieController.movieInformation;
import static cse305database.SearchMovieController.obReview;
import static cse305database.SearchMovieController.one;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author KelvinWongNYC
 */
public class MovieController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public static boolean isDouble(String s)  
{  
  try  
  {  
    double d = Double.parseDouble(s);  
    return true; 
  }  
  catch(Exception e)  
  {  
    return false;  
  }  
   
}
    
    public void submitReview(MouseEvent event){
        
    Text rating = (Text)movieInformation.lookup("#rating");
    TableView reviewTable = (TableView)movieInformation.lookup("#reviewTable");

    TextArea reviewText = (TextArea)movieInformation.lookup("#reviewText");
    Button reviewSubmit = (Button)movieInformation.lookup("#reviewSubmit");
    TextField ratingTextField = (TextField)movieInformation.lookup("#ratingTextField");
    Text errorMessage = (Text)movieInformation.lookup("#errorMessage");
    
    if(LOGINGUI){
      //create method to add review
     String userName = currentUser.getUsername();
       
       Double ratingDouble;
      if(isDouble(ratingTextField.getText())){
              ratingDouble  = Double.parseDouble(ratingTextField.getText());
              if(ratingDouble < 0 || ratingDouble > 10){
                   errorMessage.setText("Error: You did not enter a rating between 0 and 10!");
                   errorMessage.setVisible(true);
              }else{
                Review newReview = new Review(userName, one.getID(), ratingDouble,reviewText.getText());
                errorMessage.setVisible(false);
                
                reviewText.clear();
                ratingTextField.clear();
                //ADD REVIEW RETURNS BOOLEAN
             
                if(addReview(newReview)){
                obReview.add(newReview);
                Movie newMovie = getMovie(one.getID());
                String f = String.format("%.2f", newMovie.getRating());
                rating.setText(f);
                reviewTable.setItems(obReview);
                reviewTable.refresh();
                }else{
                    System.out.println("made ith ere");
                 errorMessage.setText("Error: You have already made a review for this movie!");
                 errorMessage.setVisible(true);
                }
                
                
              }     
      }else{
          errorMessage.setText("Error: You did not enter a rating between 0 and 10!");
          errorMessage.setVisible(true);
      }
    }
    
    }
   
    
}
