package com.tecacet.tomatoj.service.feed;

import java.util.List;

import com.google.api.client.util.Key;
import com.tecacet.tomatoj.model.Clip;

public class ClipFeed {

    @Key
    public List<Clip> clips;
}
