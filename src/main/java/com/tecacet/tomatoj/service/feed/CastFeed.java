package com.tecacet.tomatoj.service.feed;

import com.google.api.client.util.Key;
import com.tecacet.tomatoj.model.Actor;

import java.util.List;

public class CastFeed {

    @Key("cast")
    public List<Actor> cast;
}
