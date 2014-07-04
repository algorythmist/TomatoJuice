package com.tecacet.tomatoj.service.key;

/**
 * Use a fixed string for a key 
 */
public class FixedKeyProvider implements KeyProvider {

	private final String key;
	
	/**
	 * Initialize the provided with a fixed key
	 * @param key
	 */
	public FixedKeyProvider(String key) {
		super();
		this.key = key;
	}

	@Override
	public String getApiKey() {
		return key;
	}

}
