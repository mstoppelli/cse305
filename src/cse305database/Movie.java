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
public class Movie {
    private int ID;
    private String name;
    private String directorName;
    private String genre;
    private Double rating;
    private String maturityRating;
    private int duration;
    private int releaseDate;
    private String movieImage;

    public Movie(int ID, String name, String directorName, String genre, Double rating, String maturityRating, int duration, int releaseDate, String movieImage) {
        this.ID = ID;
        this.name = name;
        this.directorName = directorName;
        this.genre = genre;
        this.rating = rating;
        this.maturityRating = maturityRating;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.movieImage = movieImage;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMaturityRating() {
        return maturityRating;
    }

    public void setMaturityRating(String maturityRating) {
        this.maturityRating = maturityRating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(String movieImage) {
        this.movieImage = movieImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
