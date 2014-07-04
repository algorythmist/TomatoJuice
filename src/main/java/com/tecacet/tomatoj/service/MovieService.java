package com.tecacet.tomatoj.service;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.tecacet.tomatoj.model.Movie;

public interface MovieService {

    /**
     * Returns Top Box Office Earning Movies, Sorted by Most Recent Weekend
     * Gross Ticket Sales.
     * 
     * @param country
     *            Provides localized data for the selected country
     * 
     * @param limit
     *            Limits the number of box office movies returned. The maximum
     *            value is 50, a request with a greater value is considered as
     *            if it were issued with a limit equal to 50.
     * 
     * @return A List of {@link Movie} objects
     * 
     * @throws IOException
     * 
     */
    List<Movie> getBoxOfficeMovies(Locale country, int limit)
	    throws IOException;

    /**
     * Returns current opening movies.
     * 
     * @param country
     *            Provides localized data for the selected country
     * 
     * @param limit
     *            Limits the number of opening movies returned. The maximum
     *            value is 50, a request with a greater value is considered as
     *            if it were issued with a limit equal to 50
     * 
     * @return A List of {@link Movie} objects
     * @throws IOException
     * 
     */
    List<Movie> getOpeningMovies(Locale country, int limit) throws IOException;

    /**
     * Returns movies currently in theaters. Results are paginated if they go
     * past the specified page limit.
     * 
     * 
     * @param country
     *            Provides localized data for the selected country
     * @param limit
     *            Limits the number of opening movies returned. The maximum
     *            value is 50, a request with a greater value is considered as
     *            if it were issued with a limit equal to 50
     * @param page
     *            The selected page
     * 
     * @return A List of {@link Movie} objects.
     * 
     * @throws IOException
     * 
     */
    List<Movie> getInThreatersMovies(Locale country, int limit, int page)
	    throws IOException;

    /**
     * Returns upcoming movies. Results are paginated if they go past the
     * specified page limit.
     * 
     * 
     * @param country
     *            Provides localized data for the selected country <a
     *            href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2"
     *            target="_blank"> (ISO 3166-1 alpha-2)</a> if available. If
     *            this parameter is null, the method returns US data.
     * 
     * @param limit
     *            Limits the number of opening movies returned. The maximum
     *            value is 50, a request with a greater value is considered as
     *            if it were issued with a limit equal to 50
     * 
     * @param page
     *            The selected page of upcoming movies.
     * 
     * @return A list of upcoming movies.
     * 
     * @throws IOException
     * 
     */
    List<Movie> getUpcomingMovies(Locale country, int limit, int page)
	    throws IOException;

}
