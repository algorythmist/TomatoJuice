package com.tecacet.tomatoj.model;

public enum ReviewType {
    ALL("all"), TOP_CRITIC("top_critic"), DVD("dvd");

    private final String name;

    private ReviewType(String s) {
	name = s;
    }
    
    public String toString() {
	return name;
    }

}
