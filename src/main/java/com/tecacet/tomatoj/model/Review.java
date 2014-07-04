package com.tecacet.tomatoj.model;

import com.google.api.client.util.Key;

public class Review {

    @Key("critic")
    private String critic;

    @Key("date")
    private String date;

    @Key
    private String freshness;

    @Key
    private String publication;

    @Key
    private String quote;

    @Key
    private Links links;

    @Key("original_score")
    private String originalScore;

    public String getCritic() {
	return critic;
    }

    public String getDate() {
	return date;
    }

    public String getFreshness() {
	return freshness;
    }

    public String getPublication() {
	return publication;
    }

    public String getQuote() {
	return quote;
    }

    public Links getLinks() {
	return links;
    }

    public String getOriginalScore() {
	return originalScore;
    }

}
