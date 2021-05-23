package pl.pjatk.robmov.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.robmov.Service.MovieService;
import pl.pjatk.robmov.model.Movie;

import java.util.List;

@RestController
public class MovieRestController {

    private MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> findAllMovies() {
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.findMovieByID(id));
    }
    @PostMapping
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addNewMovie(movie));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long ID) {
        return ResponseEntity.ok(movieService.updateMovie(movie, ID));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieByID(@PathVariable Long ID) {
        movieService.deleteMovieByID(ID);
        return ResponseEntity.ok().build();
    }

}
