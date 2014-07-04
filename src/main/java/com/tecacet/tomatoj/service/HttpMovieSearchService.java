package com.tecacet.tomatoj.service;

import java.io.IOException;
import java.util.List;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.tecacet.tomatoj.model.Movie;
import com.tecacet.tomatoj.service.feed.MovieFeed;
import com.tecacet.tomatoj.service.key.KeyProvider;

public class HttpMovieSearchService extends AbstractTomatoService implements
	MovieSearchService {

    private static final String SEARCH_MOVIES = "movies.json";

    public HttpMovieSearchService(KeyProvider keyProvider) {
	super(keyProvider);
    }

    @Override
    public List<Movie> search(String query, int limit, int page)
	    throws IOException {
	String url = ROTTENTOMATOES_API + SEARCH_MOVIES;
	GenericUrl request = getSearchRequest(query, limit, page, url);
	HttpResponse response = executeRequest(request);
	MovieFeed feed = response.parseAs(MovieFeed.class);
	return feed.movies;
    }

    private GenericUrl getSearchRequest(String query, int limit, int page,
	    String url) {
	GenericUrl request = getPagedRequest(limit, page, url);
	request.set("q", query);
	return request;
    }
}
