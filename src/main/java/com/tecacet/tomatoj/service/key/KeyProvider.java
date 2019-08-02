package com.tecacet.tomatoj.service.key;

/**
 * Abstraction to provide a Rotten Tomatoes API key at runtime
 */
public interface KeyProvider {

    String getApiKey();
}
