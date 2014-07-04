package com.tecacet.tomatoj.service;

import java.io.IOException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.tecacet.tomatoj.service.key.KeyProvider;

/**
 * Provides common functionality to all Rotten Tomato clients
 */
public abstract class AbstractTomatoService {

    protected static final String ROTTENTOMATOES_API = "http://api.rottentomatoes.com/api/public/v1.0/";

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private HttpTransport httpTransport = new NetHttpTransport();
    private JsonFactory jsonFactory = new JacksonFactory();

    private final KeyProvider keyProvider;

    public AbstractTomatoService(KeyProvider keyProvider) {
	super();
	this.keyProvider = keyProvider;
    }

    protected HttpResponse executeRequest(GenericUrl request)
	    throws IOException {
	HttpRequestFactory requestFactory = httpTransport
		.createRequestFactory(new HttpRequestInitializer() {
		    @Override
		    public void initialize(HttpRequest request) {
			request.setParser(new JsonObjectParser(jsonFactory));
		    }
		});

	HttpRequest httpRequest = requestFactory.buildGetRequest(request);
	return httpRequest.execute();

    }

    public GenericUrl getBaseRequest(String url) {
	GenericUrl request = new GenericUrl(url);
	request.set("apikey", getApiKey());
	return request;
    }

    protected GenericUrl getMovieRequest(String movieId, String url) {
	GenericUrl request = getBaseRequest(url);
	request.set("id", movieId);
	return request;
    }

    protected GenericUrl getMovieRequest(Locale country, int limit, String url) {
	GenericUrl request = new GenericUrl(url);
	request.set("apikey", getApiKey());
	request.set("country", country.getCountry());
	request.set("limit", limit);
	return request;
    }

    protected GenericUrl getPagedRequest(Locale country, int limit, int page,
	    String url) {
	GenericUrl request = getPagedRequest(limit, page, url);
	request.set("country", country.getCountry());
	return request;
    }

    protected GenericUrl getPagedRequest(int limit, int page, String url) {
	GenericUrl request = getBaseRequest(url);
	request.set("page_limit", limit);
	request.set("page", page);
	return request;
    }

    protected String getApiKey() {
	return keyProvider.getApiKey();
    }

    public HttpTransport getHttpTransport() {
	return httpTransport;
    }

    public void setHttpTransport(HttpTransport httpTransport) {
	this.httpTransport = httpTransport;
    }

    public JsonFactory getJsonFactory() {
	return jsonFactory;
    }

    public void setJsonFactory(JsonFactory jsonFactory) {
	this.jsonFactory = jsonFactory;
    }

    public KeyProvider getKeyProvider() {
	return keyProvider;
    }

}
