package com.tecacet.tomatoj.service.feed;

import java.util.ArrayList;

import com.google.api.client.util.Key;
import com.tecacet.tomatoj.model.Movie;


public class MovieFeed {
    
    private final String key = "movies";

    @Key(key)
    public ArrayList<Movie> movies;
}
