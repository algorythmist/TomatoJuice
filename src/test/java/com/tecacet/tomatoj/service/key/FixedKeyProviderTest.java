package com.tecacet.tomatoj.service.key;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FixedKeyProviderTest {

    @Test
    public void testGetApiKey() {
        KeyProvider keyProvider = new FixedKeyProvider("key");
        assertEquals("key", keyProvider.getApiKey());
    }

}
