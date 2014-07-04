package com.tecacet.tomatoj.service;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.tecacet.tomatoj.model.Actor;
import com.tecacet.tomatoj.model.Clip;
import com.tecacet.tomatoj.model.Movie;
import com.tecacet.tomatoj.model.Review;
import com.tecacet.tomatoj.model.ReviewType;
import com.tecacet.tomatoj.service.feed.CastFeed;
import com.tecacet.tomatoj.service.feed.ClipFeed;
import com.tecacet.tomatoj.service.feed.MovieFeed;
import com.tecacet.tomatoj.service.feed.ReviewFeed;
import com.tecacet.tomatoj.service.key.KeyProvider;

public class HttpMovieDetailService extends AbstractTomatoService implements
	MovieDetailService {

    private static final String BASE_URL = ROTTENTOMATOES_API + "movies";

    public HttpMovieDetailService(KeyProvider keyProvider) {
	super(keyProvider);
    }

    @Override
    public Movie getDetailedMovieInfo(String movieId) throws IOException {
	String url = String.format("%s/%s.json", BASE_URL, movieId);
	logger.debug(url);
	GenericUrl request = getMovieRequest(movieId, url);
	HttpResponse response = executeRequest(request);
	return response.parseAs(Movie.class);
    }

    @Override
    public List<Actor> getMovieCast(String movieId) throws IOException {
	String url = String.format("%s/%s/cast.json", BASE_URL, movieId);
	logger.debug(url);
	GenericUrl request = getMovieRequest(movieId, url);
	HttpResponse response = executeRequest(request);
	CastFeed cast = response.parseAs(CastFeed.class);
	return cast.cast;
    }

    @Override
    public List<Clip> getClips(String movieId) throws IOException {
	String url = String.format("%s/%s/clips.json", BASE_URL, movieId);
	logger.debug(url);
	GenericUrl request = getMovieRequest(movieId, url);
	HttpResponse response = executeRequest(request);
	ClipFeed clips = response.parseAs(ClipFeed.class);
	return clips.clips;
    }

    @Override
    public Movie getByIMDBIdentifier(String imdbMovieId) throws IOException {
	String url = ROTTENTOMATOES_API + "movie_alias.json";
	logger.debug(url);
	GenericUrl request = getBaseRequest(url);
	request.set("id", imdbMovieId);
	request.set("type", "imdb");
	HttpResponse response = executeRequest(request);
	return response.parseAs(Movie.class);
    }

    @Override
    public List<Movie> getSimilarMovies(String movieId) throws IOException {
	String url = String.format("%s/%s/similar.json", BASE_URL, movieId);
	logger.debug(url);
	System.out.println(url);
	GenericUrl request = new GenericUrl(url);
	request.set("apikey", getApiKey());
	HttpResponse response = executeRequest(request);
	MovieFeed feed = response.parseAs(MovieFeed.class);
	return feed.movies;
    }

    @Override
    public List<Review> getMovieReviews(String movieId, ReviewType reviewType,
	    Locale country, int limit, int page) throws IOException {
	String url = String.format("%s/%s/reviews.json", BASE_URL, movieId);
	logger.debug(url);
	GenericUrl request = getReviewRequest(movieId, reviewType, country,
		limit, page, url);
	HttpResponse response = executeRequest(request);
	ReviewFeed reviews = response.parseAs(ReviewFeed.class);
	return reviews.reviews;
    }

    private GenericUrl getReviewRequest(String movieId, ReviewType reviewType,
	    Locale country, int limit, int page, String url) {
	GenericUrl request = getPagedRequest(country, limit, page, url);
	request.set("id", movieId);
	request.set("reviewType", reviewType.toString());
	return request;
    }

}
