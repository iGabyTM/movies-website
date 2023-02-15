package me.gabytm.movieswebsite.controller;

import me.gabytm.movieswebsite.model.Movie;
import me.gabytm.movieswebsite.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies/getAll")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie movie) {
        movieRepository.saveAndFlush(movie);
        return movie;
    }

    @PatchMapping("/movies")
    public Movie updateMovie(@RequestBody Movie movie) {
        final var updated = movieRepository.findById(movie.getId())
                .map(existing -> {
                    existing.setTitle(movie.getTitle());
                    existing.setReleaseYear(movie.getReleaseYear());
                    return existing;
                })
                .orElse(movie);
        movieRepository.save(updated);
        return updated;
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable long id) {
        return movieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @GetMapping(value = "/movies", params = {"title"})
    public Movie getMovie(@Param("title") String title) {
        return movieRepository.findMovieByTitle(title);
    }

}
