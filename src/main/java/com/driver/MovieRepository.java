package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    HashMap<String, Movie> movieList;
    HashMap<String , Director> directorList;
    HashMap<Movie, Director> movieDirector;

    public  MovieRepository(){
        movieList = new HashMap<>();
        directorList = new HashMap<>();
        movieDirector = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        String name = movie.getName();
        movieList.put(name, movie);
    }

    public void addDirector(Director director) {
        String name = director.getName();
        directorList.put(name, director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        Movie movie = movieList.get(movieName);
        Director director = directorList.get(directorName);
        movieDirector.put(movie,director);
    }

    public Movie getMovieByName(String name) {
        Movie movie = movieList.get(name);
        return movie;
    }

    public Director getDirectorByName(String name) {
        Director director = directorList.get(name);
        return director;
    }

    public List<String> getMoviesByDirectorName(String director) {
        List<String> list = new ArrayList<>();
        for(Movie m : movieDirector.keySet()){
            if((movieDirector.get(m).getName()).equals(director)){
                list.add(m.getName());
            }
        }
        return list;
    }

    public List<String> findAllMovies() {
        List<String> list = new ArrayList<>();
        for(String s : movieList.keySet()){
            list.add(s);
        }
        return list;
    }

    public void deleteDirectorByName(String name) {
        for(Movie m : movieDirector.keySet()){
            if((movieDirector.get(m).getName()).equals(name)){
                movieList.remove(m.getName());
                movieDirector.remove(m);
            }
        }
        directorList.remove(name);
    }

    public void deleteAllDirectors() {
        for(String dName : directorList.keySet()) {
            for(Movie m : movieDirector.keySet()) {
                if((movieDirector.get(m).getName()).equals(dName)){
                    movieList.remove(m.getName());
                    movieDirector.remove(m);
                }
            }
            directorList.remove(dName);
        }
    }
}
