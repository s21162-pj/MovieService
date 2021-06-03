package pl.pjatk.robmov.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pl.pjatk.robmov.model.Category;
import pl.pjatk.robmov.model.Movie;
import pl.pjatk.robmov.Repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;



    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<Movie> findAllMovies() { return movieRepository.findAll(); }

    public Movie findMovieByID(Long ID) throws RuntimeException{
        Optional<Movie> movieSearch = movieRepository.findById(ID);
        if (movieSearch.isPresent()){
            return movieSearch.get();
        }
        else {
            throw new RuntimeException();
        }
    }
    public Movie addNewMovie (Movie movie) {
        return movie;
    }

    public Movie updateMovie (Movie movie, Long id) throws RuntimeException {
        Optional<Movie> movieAdd = movieRepository.findById(id);
        if (movieAdd.isPresent()){
            Movie putMovie = movie;
            putMovie.setId(id);
            return movieRepository.save(putMovie);
        }
        else {
            throw new RuntimeException();
        }
    }
    public Long deleteMovieByID(Long ID) {
        return ID;
    }

    public void updateMovieAvailability(Long id) { movieRepository.updateAvailabilityToTrue(id); }
}
