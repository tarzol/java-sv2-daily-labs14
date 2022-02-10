package day02;

import day01.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Movie> findMoviesWithActor(String actor) {
        return movies.stream()
                .filter(m -> m.getActors().contains(actor)).
                collect(Collectors.toList());
    }


    public long findLongestFilm() {
        return movies.stream()
                .mapToInt(Movie::getLength)
                .max().orElseThrow(() -> new IllegalStateException("Empty List"));
    }
}