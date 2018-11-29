/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Nick
 */
/*
Alternatively,
MysqlDataSource dataSource = new MysqlDataSource();
dataSource.setUser("root");
dataSource.setPassword("password");
datasource.setNerverName("localhost:3306/imdb");
*/
public class CSE305Database {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       ArrayList<Movie> answers = searchMovies("Pirates");
       for (Movie m : answers)
       {
            System.out.println(m.getName());
       }
    }
    public static ArrayList<Movie> searchMovies(String phrase)
    {
        ArrayList<Movie> matchedMovies = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String statement = "SELECT * FROM Movie";
            PreparedStatement st = conn.prepareStatement(statement);
            String regex = "(.*)" + phrase + "(.*)";
            Pattern regpattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String movieName = rs.getString("Name");
                if(regpattern.matcher(movieName).matches()) {
                    int movieID = rs.getInt("ID");
                    matchedMovies.add(getMovie(movieID));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CSE305Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchedMovies;
    }
    public static ArrayList<Director> searchDirectors(String phrase)
    {
        ArrayList<Director> matchedDirectors = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String statement = "SELECT * FROM director";
            PreparedStatement st = conn.prepareStatement(statement);
            String regex = "(.*)" + phrase + "(.*)";
            Pattern regpattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String directorName = rs.getString("Name");
                if(regpattern.matcher(directorName).matches()) {
                    int id = rs.getInt("ID");
                    matchedDirectors.add(getDirector(id));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CSE305Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchedDirectors;
    }
    public static ArrayList<Actor> searchActors(String phrase)
    {
        ArrayList<Actor> matchedActors = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String statement = "SELECT * FROM actor";
            PreparedStatement st = conn.prepareStatement(statement);
            String regex = "(.*)" + phrase + "(.*)";
            Pattern regpattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String actorName = rs.getString("Name");
                if(regpattern.matcher(actorName).matches()) {
                    int id = rs.getInt("ID");
                    matchedActors.add(getActor(id));
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CSE305Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchedActors;
    }
    public static List<Movie> topMovies(int amount) {
        ArrayList<Movie> topMovies = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String statement = "SELECT * FROM Movie";
            PreparedStatement st = conn.prepareStatement(statement);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                topMovies.add(getMovie(rs.getInt("ID")));
            }
            Collections.sort(topMovies);
            Collections.reverse(topMovies);
            
        } catch (SQLException ex) {
            Logger.getLogger(CSE305Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topMovies.subList(0, Math.min(amount, topMovies.size()));
    }
    public static ArrayList<Actor> findActorsWithBirthday(int month)
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        try
        {
            Connection conn = MyConnection.getConnection();
            String statement = "select * from actor where MONTH(birthday)=" + month;
            PreparedStatement st = conn.prepareStatement(statement);
            ResultSet r = st.executeQuery();
            while (r.next())
            {
                Actor a = new Actor(r.getInt("ID"), r.getString("Name"), r.getInt("Height"),
                r.getDate("birthday"), r.getString("Gender"));
                actors.add(a);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        return actors;
    }
    public static ArrayList<Actor> findAllActorsOnMovie(int movieID)
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        try
        {
            Connection conn = MyConnection.getConnection();
            String statement = "select * from actorsonmovie where movieID = " + movieID;
            PreparedStatement st = conn.prepareStatement(statement);
            ResultSet r = st.executeQuery();
            while (r.next())
            {
                int actorID = r.getInt("ActorID");
                statement = "select * from actor where ID = " + actorID;
                st = conn.prepareStatement(statement);
                ResultSet r1 = st.executeQuery();
                if (r1.next())
                {
                    actors.add(new Actor(r1.getInt("ID"), r1.getString("Name"),
                            r1.getInt("Height"), r1.getDate("birthday"),
                            r1.getString("Gender")));
                    
                }
                
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        return actors;
    }
    
    public static ArrayList<Review> getMovieReviews(int movieID)
    {
        ArrayList<Review> reviews = new ArrayList<Review>();
        try
        {
            Connection conn = MyConnection.getConnection();
            String statement = "select * from reviews where MovieID = " + movieID;
            PreparedStatement st = conn.prepareStatement(statement);
            ResultSet r = st.executeQuery();
            while (r.next())
            {
                Review review = new Review(r.getString("Username"),
                r.getInt("MovieID"), r.getDouble("Rating"), r.getString("ReviewText"));
                reviews.add(review);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return reviews;
    }
   /* public static String generateUniqueID()
    {
        return RandomStringUtils.randomNumeric(9);
    }*/
    public static Movie getMovie(int id) {
        try {
            Connection conn = MyConnection.getConnection();
            String statement = "SELECT * FROM Movie WHERE ID = " + id + ";";
            PreparedStatement st = conn.prepareStatement(statement);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String movieName = rs.getString("Name");
                String director = rs.getString("Director");
                String genre = rs.getString("Genre");
                Double rating = rs.getDouble("Rating");
                String maturityRating = rs.getString("MaturityRating");
                int duration = rs.getInt("Duration");
                int releaseDate = rs.getInt("ReleaseDate");
                String movieImage = rs.getString("movieImage");
                return new Movie(id, movieName, director, genre, rating, maturityRating, duration, releaseDate, movieImage);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CSE305Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Actor getActor(int id) {
        try {
            Connection conn = MyConnection.getConnection();
            String statement = "SELECT * FROM Actor WHERE ID = " + id + ";";
            PreparedStatement st = conn.prepareStatement(statement);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String actorName = rs.getString("name");
                int height = rs.getInt("height");
                Date birthday = rs.getDate("birthday");
                String gender = rs.getString("gender");
                return new Actor(id, actorName, height, birthday, gender);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CSE305Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Director getDirector(int id) {
        try {
            Connection conn = MyConnection.getConnection();
            String statement = "SELECT * FROM Director WHERE ID = " + id + ";";
            PreparedStatement st = conn.prepareStatement(statement);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                String actorName = rs.getString("name");
                int age = rs.getInt("age");
                return new Director(id, actorName, age);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CSE305Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String registerUser(String username, String password,
            String email, String displayName)
    {
        boolean success = true;
        try
        {
            Connection conn = MyConnection.getConnection();
            String statement = "select * from User";
             PreparedStatement st = conn.prepareStatement(statement);
             ResultSet r = st.executeQuery();
             String currentUsername;
             String currentEmail;
             String currentDisplay;
             while (r.next())
             {
                 currentUsername = r.getString("Username");
                 currentEmail = r.getString("Email");
                 currentDisplay = r.getString("DisplayName");
                 if (currentUsername.equals(username))
                     return "Username already in use!";
                 if (currentEmail.equals(email)) 
                     return "Email address already in use!";
                 if (currentDisplay.equals(displayName))
                     return "Display Name already in use!";
                 
                 
             }
                statement = "INSERT INTO User(Username, Password, Email, DisplayName) VALUES " + "('" + username + "', '" + password + "', '" + email + "', '" + displayName + "')";
                PreparedStatement create = conn.prepareStatement(statement);
                create.executeUpdate();
                return "True";
             
        }
        catch (SQLException ex)
        {
            return ex.getMessage();
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "False";
        }
       
        
    }
            
    public static User loginUser(String username, String password)
    {
        try
        {
            Connection conn = MyConnection.getConnection();
            String statement = "select * from User";
             PreparedStatement st = conn.prepareStatement(statement);
             ResultSet r = st.executeQuery();
             String currentUsername;
             String currentPassword;
             while (r.next())
             {
                 currentUsername = r.getString("Username");
                 currentPassword = r.getString("Password");
                 if (currentUsername.equals(username) && currentPassword.equals(password))
                 {
                     User u = new User(currentUsername, currentPassword, 
                     r.getString("Email"), r.getString("DisplayName"));
                     return u;
                 }
             }
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
        
        return null;
         
    }
    
}
