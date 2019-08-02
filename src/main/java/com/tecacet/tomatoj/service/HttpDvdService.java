package com.tecacet.tomatoj.service;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.tecacet.tomatoj.model.Movie;
import com.tecacet.tomatoj.service.feed.MovieFeed;
import com.tecacet.tomatoj.service.key.KeyProvider;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class HttpDvdService extends AbstractTomatoService implements DvdService {

    public HttpDvdService(KeyProvider keyProvider) {
        super(keyProvider);
    }

    private static final String BASE_URL = ROTTENTOMATOES_API + "lists/dvds";

    @Override
    public List<Movie> getTopRentalsMovies(Locale country, int limit)
            throws IOException {
        String url = String.format("%s/%s.json", BASE_URL, "top_rentals");
        logger.debug(url);
        GenericUrl request = getBaseRequest(url);
        request.set("limit", limit);
        HttpResponse response = executeRequest(request);
        MovieFeed feed = response.parseAs(MovieFeed.class);
        return feed.movies;
    }

    @Override
    public List<Movie> getCurrentReleaseDvds(Locale country, int limit, int page)
            throws IOException {
        return getDvdList("current_releases", limit, page);
    }

    @Override
    public List<Movie> getNewReleaseDvds(Locale country, int limit, int page)
            throws IOException {
        return getDvdList("new_releases", limit, page);
    }

    @Override
    public List<Movie> getUpcomingDvds(Locale country, int limit, int page)
            throws IOException {
        return getDvdList("upcoming", limit, page);

    }

    private List<Movie> getDvdList(String listName, int limit, int page)
            throws IOException {
        String url = String.format("%s/%s.json", BASE_URL, listName);
        logger.debug(url);
        GenericUrl request = getPagedRequest(limit, page, url);
        HttpResponse response = executeRequest(request);
        MovieFeed feed = response.parseAs(MovieFeed.class);
        return feed.movies;
    }

}
