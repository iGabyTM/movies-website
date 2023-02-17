package me.gabytm.movieswebsite.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(Long id) {
        super("Could not found movie with id " + id);
    }

    public MovieNotFoundException(String title) {
        super("Could not found movie with title '" + title + "'");
    }

}
