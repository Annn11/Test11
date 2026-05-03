package org.example;
import java.util.List;
import java.util.Optional;
public class MovieService {
    private Repository<Movie> movies = new Repository();
    public Movie createMovie(String id,String name) {
        if(id==null || id.isBlank()) {
            throw new MovieException("id cannot be blank");
        }
        if(name==null || name.isBlank()) {
            throw new MovieException("name cannot be blank");
        }
        Movie movie = new Movie(id,name);
        movies.add(movie);
        return movie;
    }
    public List<Movie> getAllMovies() {
        return movies.findAll();
    }
    public Optional<Movie> findMovieById(String id) {
        return movies.findById(id);

    }
}
