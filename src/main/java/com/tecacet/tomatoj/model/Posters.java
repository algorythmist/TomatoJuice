package com.tecacet.tomatoj.model;

import com.google.api.client.util.Key;

public class Posters {

    @Key("thumbnail")
    private String thumbnail;

    @Key("profile")
    private String profile;

    @Key("detailed")
    private String detailed;

    @Key("original")
    private String original;

    public String getThumbnail() {
        return thumbnail;
    }

    public String getProfile() {
        return profile;
    }

    public String getDetailed() {
        return detailed;
    }

    public String getOriginal() {
        return original;
    }

}
