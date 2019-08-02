package com.tecacet.tomatoj.service.key;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads a key from a file in the filesystem.
 */
public class FilesystemKeyProvider implements KeyProvider {

    private final String key;

    /**
     * Load a key from a classpath resource. The resource is assumed to be a
     * Standard Java properties file
     *
     * @param path         the name of the classpath resource
     * @param propertyName the name of the property containing the API KEY
     * @throws IOException
     */
    public FilesystemKeyProvider(String path, String propertyName)
            throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("File not found: " + path);
        }

        InputStream is = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(is);
        this.key = properties.getProperty(propertyName);
    }

    @Override
    public String getApiKey() {
        return key;
    }
}
