package com.tecacet.tomatoj.service;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.tecacet.tomatoj.model.Movie;
import com.tecacet.tomatoj.service.feed.MovieFeed;
import com.tecacet.tomatoj.service.key.KeyProvider;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HttpMovieService extends AbstractTomatoService implements
        MovieService {

    public HttpMovieService(KeyProvider keyProvider) {
        super(keyProvider);
    }

    private static final String OPENING_MOVIES = "lists/movies/opening.json";
    private static final String BOX_OFFICE_MOVIES = "lists/movies/box_office.json";
    private static final String IN_THEATHERS_MOVIES = "lists/movies/in_theaters.json";
    private static final String UPCOMING_MOVIES = "lists/movies/upcoming.json";

    @Override
    public List<Movie> getBoxOfficeMovies(Locale country, int limit)
            throws IOException {
        String url = ROTTENTOMATOES_API + BOX_OFFICE_MOVIES;
        GenericUrl request = getMovieRequest(country, limit, url);
        HttpResponse response = executeRequest(request);
        MovieFeed feed = response.parseAs(MovieFeed.class);
        return feed.movies;
    }

    @Override
    public List<Movie> getOpeningMovies(Locale country, int limit)
            throws IOException {
        String url = ROTTENTOMATOES_API + OPENING_MOVIES;
        GenericUrl request = getMovieRequest(country, limit, url);
        HttpResponse response = executeRequest(request);
        MovieFeed feed = response.parseAs(MovieFeed.class);
        return feed.movies;
    }

    @Override
    public List<Movie> getInThreatersMovies(Locale country, int limit, int page)
            throws IOException {
        String url = ROTTENTOMATOES_API + IN_THEATHERS_MOVIES;
        GenericUrl request = getPagedRequest(country, limit, page, url);
        HttpResponse response = executeRequest(request);
        MovieFeed feed = response.parseAs(MovieFeed.class);
        return feed.movies;
    }

    @Override
    public List<Movie> getUpcomingMovies(Locale country, int limit, int page)
            throws IOException {
        String url = ROTTENTOMATOES_API + UPCOMING_MOVIES;
        GenericUrl request = getPagedRequest(country, limit, page, url);
        HttpResponse response = executeRequest(request);
        MovieFeed feed = response.parseAs(MovieFeed.class);
        return feed.movies;
    }


}
