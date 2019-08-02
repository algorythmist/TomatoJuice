package com.tecacet.tomatoj.model;

import com.google.api.client.util.Key;

import java.util.List;
import java.util.Map;

//TODO toString
public class Movie {

    @Key("id")
    private int id;

    @Key("title")
    private String title;

    @Key("genres")
    private List<String> genres;

    // Cannot be int because API sometimes return an emptystring ""
    @Key("year")
    private int year;

    @Key("mpaa_rating")
    private String mpaaRating;

    @Key("ratings")
    private Rating rating;

    @Key("release_dates")
    private ReleaseDate releaseDate;

    // TODO
    // Cannot be int because API sometimes return an emptystring ""
    // @Key("runtime")
    // public int runtime;

    @Key("critics_consensus")
    private String criticsConsensus;

    @Key("synopsis")
    private String synopsis;

    @Key("posters")
    private Posters posters;

    @Key("links")
    private Links links;

    @Key("abridged_cast")
    private List<Actor> abridgedCast;

    @Key("alternate_ids")
    private Map<String, String> alternateIds;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getYear() {
        return year;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public Rating getRating() {
        return rating;
    }

    public ReleaseDate getReleaseDate() {
        return releaseDate;
    }

    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Posters getPosters() {
        return posters;
    }

    public Links getLinks() {
        return links;
    }

    public List<Actor> getAbridgedCast() {
        return abridgedCast;
    }

    public Map<String, String> getAlternateIds() {
        return alternateIds;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", title, year);
    }

}
