import {Movie} from "../model/Movie";

export class MovieService {

    getMovies(callback: (movies: Movie[]) => void): void {
        fetch("http://localhost:8080/movies/getAll")
            .then(res => res.json())
            .then(data => callback(data as Movie[]))
            .catch(exception => console.error(exception))
    }

}