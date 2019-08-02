package com.tecacet.tomatoj.service.feed;

import com.google.api.client.util.Key;
import com.tecacet.tomatoj.model.Movie;

import java.util.ArrayList;


public class MovieFeed {

    private final String key = "movies";

    @Key(key)
    public ArrayList<Movie> movies;
}
