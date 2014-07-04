package com.tecacet.tomatoj.service.key;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.tecacet.tomatoj.service.key.FilesystemKeyProvider;
import com.tecacet.tomatoj.service.key.KeyProvider;

public class FilesystemKeyProviderTest {

    @Test
    public void testGetApiKey() throws IOException {
	KeyProvider keyProvider = 
		new FilesystemKeyProvider("local.properties", "key");
	assertEquals("DUMMY", keyProvider.getApiKey());
    }

    @Test(expected=IOException.class)
    public void testMissingResource() throws IOException {
	new FilesystemKeyProvider("missing.properties", "key");
    }

}
