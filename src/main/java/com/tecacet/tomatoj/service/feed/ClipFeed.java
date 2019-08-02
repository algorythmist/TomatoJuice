package com.tecacet.tomatoj.service.feed;

import com.google.api.client.util.Key;
import com.tecacet.tomatoj.model.Clip;

import java.util.List;

public class ClipFeed {

    @Key
    public List<Clip> clips;
}
