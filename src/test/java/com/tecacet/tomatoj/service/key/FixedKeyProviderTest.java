package com.tecacet.tomatoj.service.key;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tecacet.tomatoj.service.key.FixedKeyProvider;
import com.tecacet.tomatoj.service.key.KeyProvider;

public class FixedKeyProviderTest {

    @Test
    public void testGetApiKey() {
	KeyProvider keyProvider = new FixedKeyProvider("key");
	assertEquals("key", keyProvider.getApiKey());
    }

}
