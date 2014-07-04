package com.tecacet.tomatoj.model;

import com.google.api.client.util.Key;

public class Clip {

    @Key
    private String title;

    @Key
    private int duration;

    // TODO map to url
    @Key
    private String thumbnail;

    @Key("links")
    private Links links;

    public String getTitle() {
	return title;
    }

    public int getDuration() {
	return duration;
    }

    public String getThumbnail() {
	return thumbnail;
    }

    public Links getLinks() {
	return links;
    }

    @Override
    public String toString() {
	return title;
    }
}
