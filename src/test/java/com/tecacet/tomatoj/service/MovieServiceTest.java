package com.tecacet.tomatoj.service;

import com.tecacet.tomatoj.model.Movie;
import com.tecacet.tomatoj.service.key.FilesystemKeyProvider;
import com.tecacet.tomatoj.service.key.KeyProvider;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class MovieServiceTest {

    private MovieService movieService = null;

    @Before
    public void setUp() throws IOException {
        if (movieService == null) {
            KeyProvider keyProvider = new FilesystemKeyProvider(
                    "/Users/dimitri/dev/tomatos.properties", "key");
            movieService = new HttpMovieService(keyProvider);
        }
    }

    @Test
    public void getBoxOfficeMovies() throws IOException {
        List<Movie> movies = movieService.getBoxOfficeMovies(Locale.US, 10);
        assertEquals(10, movies.size());
    }

    @Test
    public void getOpeningMovies() throws IOException {
        List<Movie> movies = movieService.getOpeningMovies(Locale.US, 10);
        assertEquals(10, movies.size());
    }

    @Test
    public void getInThreatersMovies() throws IOException {
        List<Movie> movies = movieService.getInThreatersMovies(Locale.FRANCE,
                5, 1);
        assertEquals(5, movies.size());
    }

    @Test
    public void getUpcomingMovies() throws IOException {
        List<Movie> movies = movieService
                .getUpcomingMovies(Locale.CANADA, 5, 1);
        assertEquals(5, movies.size());
    }

}
