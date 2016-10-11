package com.chubb.rest.adapter.request;

import com.chubb.rest.adapter.connection.Connection;
import com.chubb.rest.adapter.response.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ichistruga on 10/11/2016.
 */
public class Request {
    private static final Logger log = LoggerFactory.getLogger(Request.class);

    private String verb;

    public Map<String,String> getHeader() {
        return header;
    }

    private Map<String,String> header = new HashMap<>();
    private String body;

    public Request(){

    }

    public Response makeRequest(Connection connection) {

        try {

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(connection.getUrl());

            for (HashMap.Entry<String, String> headerPair : this.header.entrySet()) {
                getRequest.addHeader(headerPair.getKey(), headerPair.getValue());
            }

            // Execute your request and catch response
            HttpResponse httpResponse = httpClient.execute(getRequest);
            return new Response(httpResponse);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

}
