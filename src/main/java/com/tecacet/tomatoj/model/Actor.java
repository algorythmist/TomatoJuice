package com.tecacet.tomatoj.model;

import com.google.api.client.util.Key;

import java.util.List;

public class Actor {

    @Key("id")
    private String id;

    @Key("name")
    private String name;

    @Key("characters")
    private List<String> characters;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCharacters() {
        return characters;
    }

    @Override
    public String toString() {
        return name;
    }
}
