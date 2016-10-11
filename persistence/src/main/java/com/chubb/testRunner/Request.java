package com.chubb.testRunner;

import com.chubb.testRunner.utils.Response;

/**
 * Created by ichistruga on 10/10/2016.
 */
public class Request {

    private Connection connection;
    private String verb;
    private String body;

    public Request(Connection connection){
        this.connection = connection;
    }

    public Response makeRequest()
    {
        return new Response();
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
