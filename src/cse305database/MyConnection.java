/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Nick
 */
public class MyConnection {
    private static Connection con = null;
    public static Connection getConnection()
    {
        if (con == null)
        {
            try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/imdb";
            String username = "root";
            String password = "password";
            Class.forName(driver);
            
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Database");
            con = conn;
            }    
            catch (Exception e) {
                System.out.println("Error initializing mysql connection!");
                System.exit(0);
            }
        }
        return con;
    }
}
