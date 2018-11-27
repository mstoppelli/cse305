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
import java.util.ArrayList;

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
        
    }
    public static ArrayList<Movie> searchMovies(String phrase)
    {
        return null;
    }
    public static ArrayList<Director> searchDirectors(String phrase)
    {
        return null;
    }
    public static ArrayList<Actor> searchActors(String phrase)
    {
        return null;
    }
    public static ArrayList<String> getMovieReviews(int movieID)
    {
        return null;
    }
   /* public static String generateUniqueID()
    {
        return RandomStringUtils.randomNumeric(9);
    }*/
    public static boolean registerUser(String username, String password,
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
             if (r.next())
             {
                 currentUsername = r.getString("Username");
                 currentEmail = r.getString("Email");
                 currentDisplay = r.getString("DisplayName");
                 if (currentUsername.equals(username) || currentEmail.equals(email) ||
                         currentDisplay.equals(displayName))
                     success = false;
                 
                 
             }
             if (success)
             {
                 statement = "INSERT INTO User(Username, Password, Email, DisplayName) VALUES " + "('" + username + "', '" + password + "', '" + email + "', '" + displayName + "')";
                 PreparedStatement create = conn.prepareStatement(statement);
                create.executeUpdate();
                return success;
             }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return false;
        
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
             if (r.next())
             {
                 currentUsername = r.getString("Username");
                 currentPassword = r.getString("currentPassword");
                 if (currentUsername.equals(username) && currentPassword.equals(password))
                 {
                             
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
