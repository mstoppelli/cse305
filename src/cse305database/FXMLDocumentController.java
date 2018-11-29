/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

import static cse305database.CSE305Database.searchActors;
import static cse305database.CSE305Database.searchDirectors;
import static cse305database.CSE305Database.searchMovies;
import static cse305database.IMBD.s;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    
    public static void setWelcomeText(String user){
        Scene s1 = s.getScene();
        Text t = (Text)s1.lookup("#welcome");
        t.setVisible(true);
        t.setText("Welcome " + user+ "!");
        
        
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
    
    private static boolean movieSearch = true;
    private static boolean actorSearch = false;
    private static boolean directorSearch = false;

    
    @FXML
    private void movie(ActionEvent event) {
        Scene s1 = s.getScene();
        SplitMenuButton split = (SplitMenuButton)s1.lookup("#menuButton");
        split.setText("Movie"); 
        movieSearch=true;
        actorSearch=false;
        directorSearch=false;
    }
     @FXML
     private void actor(ActionEvent event) {
         Scene s1 = s.getScene();
        SplitMenuButton split = (SplitMenuButton)s1.lookup("#menuButton");
        split.setText("Actor"); 
         movieSearch=false;
        actorSearch=true;
        directorSearch=false;
    }
      @FXML
     private void director(ActionEvent event) {
         Scene s1 = s.getScene();
        SplitMenuButton split = (SplitMenuButton)s1.lookup("#menuButton");
        split.setText("Director"); 
         movieSearch=false;
        actorSearch=false;
        directorSearch=true;
    }
     
    
     public static Scene actorScene;
     @FXML
    private void search(MouseEvent event) throws IOException{
        Scene s1 = s.getScene();
        TextField split = (TextField)s1.lookup("#searchBar");
        String searchBar = split.getText();
        
        if(actorSearch){
            
          Parent root = FXMLLoader.load(getClass().getResource("Search.fxml"));
         actorScene = new Scene(root);
        
         Stage actor = new Stage();
         actor.setTitle("Actor Search");
          Text actorResults = (Text)actorScene.lookup("#searchResultsActor");
        actorResults.setText("Search Results for \"" + searchBar + "\"");
        
        TableView actorTable = (TableView)actorScene.lookup("#actorTable");
        actorTable.setPlaceholder(new Label("No search results for \"" + searchBar + "\""));
        ArrayList<Actor> actorArrayList;
        
        //COMMENT OUT THIS PART OF THE CODE!!!
        /*actorArrayList = new ArrayList<>();
        Date testDate = new Date();
        Actor testActor = new Actor(0, "Name",100,testDate,"Male");
        actorArrayList.add(testActor);*/
        
        actorArrayList = searchActors(searchBar);
        if(actorArrayList.size() !=0){
             ObservableList<Actor> ob = FXCollections.observableArrayList(actorArrayList);
            TableColumn name =  (TableColumn) actorTable.getColumns().get(0);
            name.setCellValueFactory(
            new PropertyValueFactory<Actor,String>("name")
               );
            TableColumn height =  (TableColumn) actorTable.getColumns().get(1);
             height.setCellValueFactory(
            new PropertyValueFactory<Actor,Integer>("height")
               );
            TableColumn birthday =  (TableColumn) actorTable.getColumns().get(2);
             birthday.setCellValueFactory(
            new PropertyValueFactory<Actor,Date>("birthday")
               );
            TableColumn gender =  (TableColumn) actorTable.getColumns().get(3);
             gender.setCellValueFactory(
            new PropertyValueFactory<Actor,String>("gender")
               );
             actorTable.setItems(ob);
        }
        actor.setScene(actorScene);
        actor.show();
            
        }else if(movieSearch){
            
         Parent root = FXMLLoader.load(getClass().getResource("SearchMovie.fxml"));
        Scene scene = new Scene(root);
         Stage movie = new Stage();
         movie.setTitle("Movie Search");
          Text movieResults = (Text)scene.lookup("#searchResultsMovie");
        movieResults.setText("Search Results for \"" + searchBar + "\"");
        
        TableView movieTable = (TableView)scene.lookup("#movieTable");
        movieTable.setPlaceholder(new Label("No search results for \"" + searchBar + "\""));
        ArrayList<Movie> movieArrayList;
        
        //Comment out this part here
        /*movieArrayList = new ArrayList<>();
        Movie testMovie = new Movie(0,"TEST", "DIRECTOR", "FICTIOn",5.0,"Adult",2,2006,"null");
        movieArrayList.add(testMovie);*/
        
        movieArrayList = searchMovies(searchBar);
        if(movieArrayList.size() != 0){
            
            ObservableList<Movie> ob = FXCollections.observableArrayList(movieArrayList);
            TableColumn name =  (TableColumn) movieTable.getColumns().get(0);
            name.setCellValueFactory(
            new PropertyValueFactory<Movie,String>("name")
               );
             TableColumn director =  (TableColumn) movieTable.getColumns().get(1);
            director.setCellValueFactory(
            new PropertyValueFactory<Movie,String>("directorName")
               );
            
             TableColumn genre =  (TableColumn) movieTable.getColumns().get(2);
            genre.setCellValueFactory(
            new PropertyValueFactory<Movie,String>("genre")
               );
            
             TableColumn rating =  (TableColumn) movieTable.getColumns().get(3);
            rating.setCellValueFactory(
            new PropertyValueFactory<Movie,Double>("rating")
               );
            
             TableColumn maturityRating =  (TableColumn) movieTable.getColumns().get(4);
            maturityRating.setCellValueFactory(
            new PropertyValueFactory<Movie,String>("maturityRating")
               );
            
             TableColumn duration =  (TableColumn) movieTable.getColumns().get(5);
            duration.setCellValueFactory(
            new PropertyValueFactory<Movie,Integer>("duration")
               );
        
             TableColumn releaseDate =  (TableColumn) movieTable.getColumns().get(6);
            releaseDate.setCellValueFactory(
            new PropertyValueFactory<Movie,Integer>("releaseDate")
               );
            movieTable.setItems(ob);
        }
        
        
        movie.setScene(scene);
        movie.show();
        
        }else if(directorSearch){
                Parent root = FXMLLoader.load(getClass().getResource("SearchDirector.fxml"));
        Scene scene = new Scene(root);
         Stage director = new Stage();
         director.setTitle("Director Search");
         Text directorResults = (Text)scene.lookup("#searchResultsDirector");
        directorResults.setText("Search Results for \"" + searchBar + "\"");
        
        TableView directorTable = (TableView)scene.lookup("#directorTable");
        directorTable.setPlaceholder(new Label("No search results for \"" + searchBar + "\""));
        ArrayList<Director> directorArrayList;
        
        //COMMENT THIS PART BELOW
        //directorArrayList = new ArrayList<>();
        //directorArrayList.add(new Director(0, "NAME", 100));
     
        directorArrayList = searchDirectors(searchBar);
        
        if(directorArrayList.size() != 0){
            ObservableList<Director> ob = FXCollections.observableArrayList(directorArrayList);
            TableColumn name =  (TableColumn) directorTable.getColumns().get(0);
            name.setCellValueFactory(
            new PropertyValueFactory<Movie,String>("name")
               );
            TableColumn age =  (TableColumn) directorTable.getColumns().get(1);
            age.setCellValueFactory(
            new PropertyValueFactory<Movie,String>("age")
               );
            
            directorTable.setItems(ob);
            
        }
     
        
        director.setScene(scene);
        director.show();
        
        }
        split.clear();
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
    private static Stage moviePage;
    private static Stage actorPage;
   @FXML
    private void viewMoviePage(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Movie.fxml"));
        Scene scene = new Scene(root);
         moviePage = new Stage();
        moviePage.setTitle("Movie");
        moviePage.setScene(scene);
        moviePage.show();
    }
    @FXML
    private void viewActorPage(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Actor.fxml"));
        Scene scene = new Scene(root);
          actorPage = new Stage();
        actorPage.setTitle("Actor");
        actorPage.setScene(scene);
        actorPage.show();
    
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
