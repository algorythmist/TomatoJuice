package com.tecacet.tomatoj.service;

import com.tecacet.tomatoj.model.*;
import com.tecacet.tomatoj.service.key.FilesystemKeyProvider;
import com.tecacet.tomatoj.service.key.KeyProvider;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

//TODO replace print with assert
public class MovieDetailServiceTest {

    private MovieDetailService service;

    @Before
    public void setUp() throws IOException {
        if (service == null) {
            KeyProvider keyProvider = new FilesystemKeyProvider(
                    "/Users/dimitri/dev/tomatos.properties", "key");
            service = new HttpMovieDetailService(keyProvider);
        }
    }

    @Test
    public void getByIMDBIdentifier() throws IOException {
        Movie movie = service.getByIMDBIdentifier("0031381");
        assertEquals(9818, movie.getId());
        assertEquals("Gone With the Wind", movie.getTitle());
    }

    @Test
    public void getSimilarMovies() throws IOException {
        List<Movie> movies = service.getSimilarMovies("770672122");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    @Test
    public void getDetailedMovieInfo() throws IOException {
        Movie movie = service.getDetailedMovieInfo("770672122");
        assertEquals("Toy Story 3", movie.getTitle());

        System.out.println(movie.getReleaseDate().getDvd());
    }

    @Test
    public void getMovieCast() throws IOException {
        List<Actor> cast = service.getMovieCast("770672122");
        for (Actor c : cast) {
            System.out.println(c);
            for (String characted : c.getCharacters()) {
                System.out.println(characted);
            }
        }
    }

    @Test
    public void getClips() throws IOException {
        List<Clip> clips = service.getClips("770672122");
        for (Clip clip : clips) {
            System.out.println(clip);
        }
    }

    @Test
    public void getMovieReviews() throws IOException {
        List<Review> reviews = service.getMovieReviews("770672122",
                ReviewType.ALL, Locale.US, 20, 1);
        Review review = reviews.get(0);
        System.out.println(review.getCritic());
        System.out.println(review.getDate());
        System.out.println(review.getFreshness());
        System.out.println(review.getOriginalScore());
        System.out.println(review.getPublication());
        System.out.println(review.getQuote());
        System.out.println(review.getLinks().getReview());
        //System.out.println(review.getLinks().getCast());

    }


}
