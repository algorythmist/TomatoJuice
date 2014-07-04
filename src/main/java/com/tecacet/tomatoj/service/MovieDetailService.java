package com.tecacet.tomatoj.service;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.tecacet.tomatoj.model.Actor;
import com.tecacet.tomatoj.model.Clip;
import com.tecacet.tomatoj.model.Movie;
import com.tecacet.tomatoj.model.Review;
import com.tecacet.tomatoj.model.ReviewType;

public interface MovieDetailService {

    /**
     * Returns detailed information on a specific {@link Movie} object. You can
     * use the movies search endpoint or peruse the lists of movies/dvds to get
     * the movies objects.
     * 
     * @param movie
     *            A {@link Movie} object containing a valid movie id or a valid
     *            self-link in {@link Movie#links}. If both of them are non-null
     *            the method uses the id.
     * 
     * @return A {@link Movie} object containing all its detailed info.
     * @throws IOException
     * 
     */
    Movie getDetailedMovieInfo(String movieId) throws IOException;

    List<Clip> getClips(String movieId) throws IOException;

    Movie getByIMDBIdentifier(String imdbMovieId) throws IOException;

    /**
     * Returns the complete movie cast for a movie.
     * 
     * @param movieId
     *            A valid movie id.
     * 
     * @return A list of actors comprising the movie cast.
     * 
     * @throws IOException
     * 
     */
    List<Actor> getMovieCast(String movieId) throws IOException;

    /**
     * Returns similar movies for a given movie.
     * 
     * @param movieId
     *            A valid movie id
     * 
     * @return A list of similar movies
     * 
     * @throws IOException
     * 
     */
    List<Movie> getSimilarMovies(String movieId) throws IOException;

    /**
     * Returns the reviews for a movie. Results are paginated if they go past
     * the specified page limit.
     * 
     * @param movieId
     *            A valid movie id.
     * 
     * @param result
     *            A List of {@link Review} objects. The reviews obtained
     *            invoking this method are appended to this list.
     * 
     * @param reviewType
     *            3 different review types are possible: "all", "top_critic" and
     *            "dvd". "top_critic" shows all the Rotten Tomatoes designated
     *            top critics. "dvd" pulls the reviews given on the DVD of the
     *            movie. "all" as the name implies retrieves all reviews.
     * 
     * @param country
     *            Provides localized data for the selected country.
     * 
     * @param page
     *            The selected page of upcoming movies.
     * 
     * @return A page of reviews
     * 
     * @throws IOException
     * 
     */
    List<Review> getMovieReviews(String movieId, ReviewType reviewType,
	    Locale country, int limit, int page) throws IOException;

}
