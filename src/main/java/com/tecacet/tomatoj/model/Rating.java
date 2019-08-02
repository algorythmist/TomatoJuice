package com.tecacet.tomatoj.model;

import com.google.api.client.util.Key;

public class Rating {

    @Key("critics_rating")
    private String criticsRating;

    @Key("critics_score")
    private int criticsScore;

    @Key("audience_rating")
    private String audienceRating;

    @Key("audience_score")
    private int audienceScore;

    public String getCriticsRating() {
        return criticsRating;
    }

    public int getCriticsScore() {
        return criticsScore;
    }

    public String getAudienceRating() {
        return audienceRating;
    }

    public int getAudienceScore() {
        return audienceScore;
    }

}
