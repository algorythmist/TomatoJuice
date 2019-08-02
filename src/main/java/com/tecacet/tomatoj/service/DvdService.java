package com.tecacet.tomatoj.service;

import com.tecacet.tomatoj.model.Movie;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public interface DvdService {

    /**
     * Returns the current top dvd rentals.
     *
     * @param country Provides localized data for the selected country
     * @param limit   Limits the number of top dvd rentals returned. The maximum
     *                value is 50, a request with a greater value is considered as
     *                if it were issued with a limit equal to 50 .
     * @return A List of {@link Movie} objects
     * @throws IOException
     */
    List<Movie> getTopRentalsMovies(Locale country, int limit) throws IOException;

    /**
     * Returns current release dvds. Results are paginated if they go past the
     * specified page limit.
     *
     * @param country Provides localized data for the selected country
     * @param page    The selected page of current released dvds.
     * @return A list of movies currently released in dvd.
     * @throws IOException
     */
    List<Movie> getCurrentReleaseDvds(Locale country, int limit, int page) throws IOException;

    /**
     * Returns new release dvds. Results are paginated if they go past the
     * specified page limit.
     *
     * @param country Provides localized data for the selected country
     * @param page    The selected page of new released dvds.
     * @return A list of new movies released in dvd.
     * @throws IOException
     */
    List<Movie> getNewReleaseDvds(Locale country, int limit, int page) throws IOException;

    /**
     * Returns upcoming dvds. Results are paginated if they go past the
     * specified page limit.
     *
     * @param country Provides localized data for the selected country
     * @param page    The selected page of new released dvds.
     * @return A list of new movies released in dvd.
     * @throws IOException
     */
    List<Movie> getUpcomingDvds(Locale country, int limit, int page) throws IOException;

}
