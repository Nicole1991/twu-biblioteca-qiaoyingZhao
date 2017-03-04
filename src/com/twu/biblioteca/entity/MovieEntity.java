package com.twu.biblioteca.entity;

/**
 * Created by zhaoqiaoying on 2017/3/4.
 */
public class MovieEntity {
    private Integer id;
    private String movieName;
    private String year;
    private String director;
    private double movieRating;

    public MovieEntity(Integer id, String movieName, String year, String director, double movieRating) {
        this.id = id;
        this.movieName = movieName;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
    }

    public MovieEntity(Integer id, String movieName,double movieRating){
        this(id,movieName,null,null,movieRating);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(double movieRating) {
        this.movieRating = movieRating;
    }

    public String toString() {
        return "Movie{" +
                "name:'" + movieName + '\'' +
                ", year:'" + year + '\'' +
                ", director:'" + director + '\'' +
                ", rating:" + movieRating +
                '}';
    }
}
