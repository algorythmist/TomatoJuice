package com.tecacet.tomatoj.service.feed;

import java.util.List;

import com.google.api.client.util.Key;
import com.tecacet.tomatoj.model.Review;

public class ReviewFeed {

    @Key
    public int total;
    
    @Key("reviews")
    public List<Review> reviews;
}
