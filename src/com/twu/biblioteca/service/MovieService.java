package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.MovieEntity;
import java.util.List;
import java.util.ArrayList;
import com.twu.biblioteca.model.OperationMessage;

/**
 * Created by zhaoqiaoying on 2017/3/4.
 */
public class MovieService {
    private static MovieService movieService = null;

    public static MovieService getInstance(){
        if (movieService == null){
            return new MovieService();
        }
        return new MovieService();
    }
    /**
     * movie lists
     */
    private static List<MovieEntity> movieList= new ArrayList<MovieEntity>();

    /**
     * checkout movie list
     */
    private static List<MovieEntity> checkoutMovieList = new ArrayList<MovieEntity>();

    private MovieService() {
        init();
    }


    private void init() {
        movieList.add(new MovieEntity(1, "Iron Man", 9.1));
        movieList.add(new MovieEntity(2,"Super Man",10));
        movieList.add(new MovieEntity(3,"Source Code",8.9));
        movieList.add(new MovieEntity(4,"Se7en",6));
        movieList.add(new MovieEntity(5,"Interstellar",7.1));
        movieList.add(new MovieEntity(6,"StarTrek",8.1));
    }

    public List<MovieEntity> getMovieList(){
        return movieList;
    }

    public String getMovieListStr(){
        StringBuffer str = new StringBuffer();
        for (MovieEntity existMovieList:movieList){
            str.append("id: "+ existMovieList.getId() + "\tMovie name： "+ existMovieList.getMovieName()+
                    "\tmovieRating($):"+existMovieList.getMovieRating()+"\r");
        }
        return str.toString();
    }

    /**
     *
     * @param id
     * @param name
     * @return MovieEntity
     * According the id or name which given to get a book
     */
    private MovieEntity getMovie(Integer id, String name) {
        if (id == null && name == null)
            return null;
        Integer inputId;
        String inputName;
        inputId = id == null ? 0 : id;
        inputName = name == null ? "" : name;
        for (MovieEntity movie : movieList)
            if (inputId.equals(movie.getId()) || inputName.equals(movie.getMovieName()))
                return movie;
        return null;
    }

    public MovieEntity getMovie(Integer id) {
        return getMovie(id, null);
    }

    public MovieEntity getMovie(String name) {
        return getMovie(null, name);
    }

    /**
     * checkoutMovie
     * @param inputId
     * @param inputMovieName
     * @return
     */
    private OperationMessage checkoutMovie(Integer inputId,String inputMovieName) {
        String failMsg = "That Movie is not available.";
        String successMsg = "Thank you! Enjoy the Movie";

        if (inputId < 1 && inputMovieName == null)
            return new OperationMessage(false, failMsg);
        inputId = inputId == null ? 0 : inputId;
        inputMovieName = inputMovieName == null ? "" : inputMovieName;

        MovieEntity checkoutMovie = null;
        for (MovieEntity movie:movieList){
            if (inputId == movie.getId() || inputMovieName.equals(movie.getMovieName())) {
                checkoutMovie = movie;
                break;
            }
        }
        if (checkoutMovie == null)
            return new OperationMessage(false,failMsg);

        movieList.remove(checkoutMovie);
        checkoutMovieList.add(checkoutMovie);

        return new OperationMessage(true,successMsg);
    }

    public OperationMessage checkoutMovie(Integer id){
        return checkoutMovie(id,null);
    }

    public OperationMessage checkoutMovie(String bookName){
        return checkoutMovie(null,bookName);
    }
}
