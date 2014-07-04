package com.tecacet.tomatoj.service.feed;

import java.util.List;

import com.google.api.client.util.Key;
import com.tecacet.tomatoj.model.Actor;

public class CastFeed {

    @Key("cast")
    public List<Actor> cast;
}
