package com.tecacet.tomatoj.service;

import com.tecacet.tomatoj.model.Movie;
import com.tecacet.tomatoj.service.key.FilesystemKeyProvider;
import com.tecacet.tomatoj.service.key.KeyProvider;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovieSearchServiceTest {

    private MovieSearchService searchService = null;

    @Before
    public void setUp() throws IOException {
        if (searchService == null) {
            KeyProvider keyProvider = new FilesystemKeyProvider(
                    "/Users/dimitri/dev/tomatos.properties", "key");
            searchService = new HttpMovieSearchService(keyProvider);
        }

    }

    @Test
    public void testSearch() throws IOException {
        List<Movie> movies = searchService.search("The Two Faces of January",
                10, 1);
        assertEquals(1, movies.size());
        Movie movie = movies.get(0);
        assertEquals("The Two Faces of January", movie.getTitle());
        assertEquals(2014, movie.getYear());
        assertEquals("PG-13", movie.getMpaaRating());
        assertEquals(771317918, movie.getId());

    }

}
