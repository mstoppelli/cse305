/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse305database;

/**
 *
 * @author Nick
 */
public class Review {
    private String username;
    private int movieID;
    private double rating;
    private String reviewText;
    public Review(String username, int movieID, double rating, String reviewText)
    {
        this.username = username;
        this.movieID = movieID;
        this.rating = rating;
        this.reviewText = reviewText;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
    
}

