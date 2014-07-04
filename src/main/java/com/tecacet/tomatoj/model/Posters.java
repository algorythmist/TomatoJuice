package com.tecacet.tomatoj.model;

import com.google.api.client.util.Key;
import com.google.common.base.Objects;

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

    @Override
    public String toString() {
	return Objects.toStringHelper(this.getClass())
		.add("thumbnail", thumbnail).add("profile", profile)
		.add("detail", detailed).toString();
    }
}
