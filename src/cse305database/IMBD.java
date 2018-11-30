/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

import static cse305database.CSE305Database.findActorsWithBirthday;
import static cse305database.CSE305Database.topMovies;

import java.util.ArrayList;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author KelvinWongNYC
 */
public class IMBD extends Application {
    
    public static Stage s = null;
    
    public static ArrayList<Movie> topMovies;
     public static ArrayList<Actor> actorBirthdays;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        s = stage;
        stage.setScene(scene);
        stage.setOnHidden(e -> {
            Platform.exit();
            });     
        topMovies = new ArrayList<>(topMovies(5));
        
        //NEED TO COMMENT OUT ALL OF THIS
         /*topMovies = new ArrayList<>();
         Movie testMovie1 = new Movie(0,"TEST", "DIRECTOR", "FICTIOn",5.0,"Adult",2,2006,"2012.jpg");
         Movie testMovie2 = new Movie(0,"TEST", "DIRECTOR", "FICTIOn",5.0,"Adult",2,2006,"2012.jpg");
         Movie testMovie3 = new Movie(0,"TEST", "DIRECTOR", "FICTIOn",5.0,"Adult",2,2006,"2012.jpg");
         Movie testMovie4 = new Movie(0,"TEST", "DIRECTOR", "FICTIOn",5.0,"Adult",2,2006,"2012.jpg");
         Movie testMovie5 = new Movie(0,"TEST", "DIRECTOR", "FICTIOn",5.0,"Adult",2,2006,"2012.jpg");
        topMovies.add(testMovie1);
        topMovies.add(testMovie2);
        topMovies.add(testMovie3);
        topMovies.add(testMovie4);
        topMovies.add(testMovie5);*/
        
        
        ImageView image1 = (ImageView)scene.lookup("#image0");
        image1.setImage(new Image("/Movie/"+topMovies.get(0).getMovieImage()));
        
        ImageView image2 = (ImageView)scene.lookup("#image1");
        image2.setImage(new Image("/Movie/"+topMovies.get(1).getMovieImage()));
        ImageView image3 = (ImageView)scene.lookup("#image2");
        image3.setImage(new Image("/Movie/"+topMovies.get(2).getMovieImage()));
        ImageView image4 = (ImageView)scene.lookup("#image3");
        image4.setImage(new Image("/Movie/"+topMovies.get(3).getMovieImage()));
        ImageView image5 = (ImageView)scene.lookup("#image4");
        image5.setImage(new Image("/Movie/"+topMovies.get(4).getMovieImage()));
        
        
     actorBirthdays = new ArrayList<>(findActorsWithBirthday(12));
       
       //NEED TO COMMENT OUT ALL OF THIS
       /*actorBirthdays = new ArrayList<>();
        Date testDate = new Date();
        Actor testActor1 = new Actor(0, "Bill Murray",100,testDate,"Male");
       Actor testActor2 = new Actor(0, "Amy Poehler",300,testDate,"Female");
        Actor testActor3 = new Actor(0, "Bill Murray",100,testDate,"Male");
        Actor testActor4 = new Actor(0, "Bill Murray",100,testDate,"Male");
        Actor testActor5 = new Actor(0, "Bill Murray",100,testDate,"Male");
        actorBirthdays.add(testActor1);
        actorBirthdays.add(testActor2);
        actorBirthdays.add(testActor3);
        actorBirthdays.add(testActor4);
        actorBirthdays.add(testActor5);*/

        
         ImageView image6 = (ImageView)scene.lookup("#image5");
        image6.setImage(new Image("/Actors/"+actorBirthdays.get(0).getName()+".jpg"));
        ImageView image7 = (ImageView)scene.lookup("#image6");
        image7.setImage(new Image("/Actors/"+actorBirthdays.get(1).getName()+".jpg"));
        
        ImageView image8 = (ImageView)scene.lookup("#image7");
        image8.setImage(new Image("/Actors/"+actorBirthdays.get(2).getName()+".jpg"));
         ImageView image9 = (ImageView)scene.lookup("#image8");
        image9.setImage(new Image("/Actors/"+actorBirthdays.get(3).getName()+".jpg"));
         ImageView image10 = (ImageView)scene.lookup("#image9");
        image10.setImage(new Image("/Actors/"+actorBirthdays.get(4).getName()+".jpg"));
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(CSE305Database.getMovie(4458).getName());
        launch(args);
    }
    
}
