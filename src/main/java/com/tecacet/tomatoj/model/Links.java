package com.tecacet.tomatoj.model;

import com.google.api.client.util.Key;

public class Links {

    @Key("self")
    private String self;

    @Key("alternate")
    private String alternate;

    @Key("cast")
    private String cast;

    @Key("clips")
    private String clips;

    @Key("review")
    private String review;

    @Key("similar")
    private String similar;

    public String getSelf() {
        return self;
    }

    public String getAlternate() {
        return alternate;
    }

    public String getCast() {
        return cast;
    }

    public String getClips() {
        return clips;
    }

    public String getReview() {
        return review;
    }

    public String getSimilar() {
        return similar;
    }

}
