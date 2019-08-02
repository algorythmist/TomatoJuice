package com.tecacet.tomatoj.service.feed;

import com.google.api.client.util.Key;
import com.tecacet.tomatoj.model.Review;

import java.util.List;

public class ReviewFeed {

    @Key
    public int total;

    @Key("reviews")
    public List<Review> reviews;
}
