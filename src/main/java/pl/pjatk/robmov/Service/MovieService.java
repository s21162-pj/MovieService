package pl.pjatk.robmov.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.robmov.model.Movie;

import java.util.List;

@Service
public class MovieService {

    public List<Movie> findAllMovies() {
        return List.of(
                new Movie(1L, "Fast and furious", Category.ACTION));

    }

    public Movie findMovieByID(Long ID) {
        return new Movie(2L, "Tokyo Drift", Category.ACTION);
    }
}