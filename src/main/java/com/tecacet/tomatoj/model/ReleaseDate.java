package com.tecacet.tomatoj.model;

import com.google.api.client.util.Key;

//TODO Date instead of String
public class ReleaseDate {

    @Key("theater")
    public String theater;

    @Key("dvd")
    public String dvd;

    public String getDvd() {
        return dvd;
    }

    
}
