package com.tecacet.tomatoj.service.key;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads a key from a classpath resource
 */
public class ResourceKeyProvider implements KeyProvider {

    private final String key;

    /**
     * Load a key from a classpath resource.
     * The resource is assumed to be a Standard Java properties file
     *
     * @param resourceName the name of the classpath resource
     * @param propertyName the name of the property containing the API KEY
     * @throws IOException
     */
    public ResourceKeyProvider(String resourceName, String propertyName)
            throws IOException {
        InputStream is = this.getClass()
                .getResourceAsStream("/" + resourceName);
        if (is == null) {
            throw new IOException("Resource not found: " + resourceName);
        }
        Properties properties = new Properties();
        properties.load(is);
        this.key = properties.getProperty(propertyName);
    }

    @Override
    public String getApiKey() {
        return key;
    }
}
