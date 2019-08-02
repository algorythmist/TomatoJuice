package com.tecacet.tomatoj.service.key;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FilesystemKeyProviderTest {

    @Test
    public void testGetApiKey() throws IOException {
        KeyProvider keyProvider =
                new FilesystemKeyProvider("local.properties", "key");
        assertEquals("DUMMY", keyProvider.getApiKey());
    }

    @Test(expected = IOException.class)
    public void testMissingResource() throws IOException {
        new FilesystemKeyProvider("missing.properties", "key");
    }

}
