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

public class DvdServiceTest {

    private DvdService service = null;

    @Before
    public void setUp() throws IOException {
        if (service == null) {
            String userHome = System.getProperty("user.home");
            KeyProvider keyProvider = new FilesystemKeyProvider(
                    userHome + "/tomatoes.properties", "key");
            service = new HttpDvdService(keyProvider);
        }
    }

    @Test
    public void testGetTopRentalsMovies() throws IOException {
        List<Movie> movies = service.getTopRentalsMovies(Locale.US, 10);
        assertEquals(10, movies.size());
    }

    @Test
    public void testGetCurrentReleaseDvds() throws IOException {
        List<Movie> movies = service.getCurrentReleaseDvds(Locale.US, 10, 1);
        assertEquals(10, movies.size());
    }

    @Test
    public void testGetNewReleaseDvds() throws IOException {
        List<Movie> movies = service.getNewReleaseDvds(Locale.US, 10, 1);
        assertEquals(10, movies.size());
    }

    @Test
    public void testGetUpcomingDvds() throws IOException {
        List<Movie> movies = service.getUpcomingDvds(Locale.US, 10, 1);
        assertEquals(10, movies.size());
    }

}
