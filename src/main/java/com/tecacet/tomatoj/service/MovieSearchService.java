package com.tecacet.tomatoj.service;

import com.tecacet.tomatoj.model.Movie;

import java.io.IOException;
import java.util.List;

public interface MovieSearchService {

    /**
     * Movies search for plain text queries. Results are paginated if they go
     * past the specified page limit.
     *
     * @param query The plain text search query to search for a movie. Encoding is
     *              performed internally.
     * @param limit Limits the number of box office movies returned. The maximum
     *              value is 50, a request with a greater value is considered as
     *              if it were issued with a limit equal to 50.
     * @param page  The selected page of movie search results. Maximum vale is 25.
     *              A greater value is set to 25.
     * @return A list of movies matching the query.
     * @throws IOException
     */
    List<Movie> search(String query, int limit, int page) throws IOException;
}
