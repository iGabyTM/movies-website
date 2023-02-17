package me.gabytm.movieswebsite.controller;

import me.gabytm.movieswebsite.exception.MovieNotFoundException;
import me.gabytm.movieswebsite.model.Movie;
import me.gabytm.movieswebsite.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin({"http://localhost:5173", "http://127.0.0.1:5173"})
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
        return movieRepository.save(movie);
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable long id) {
        return movieRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(movie.getTitle());
                    existing.setReleaseYear(movie.getReleaseYear());
                    return movieRepository.save(existing);
                })
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @GetMapping(value = "/movies", params = {"title"})
    public Movie getMovie(@Param("title") String title) {
        return movieRepository.findMovieByTitle(title)
                .orElseThrow(() -> new MovieNotFoundException(title));
    }

}
