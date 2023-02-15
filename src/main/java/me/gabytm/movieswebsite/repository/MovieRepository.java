package me.gabytm.movieswebsite.repository;

import me.gabytm.movieswebsite.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findMovieByTitle(String title);

}
