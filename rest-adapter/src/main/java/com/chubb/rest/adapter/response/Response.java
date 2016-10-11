package com.chubb.rest.adapter.response;

import org.apache.http.HttpResponse;

/**
 * Created by ichistruga on 10/11/2016.
 */
public class Response {

    private HttpResponse response;

    public Response(HttpResponse response) {
        this.response = response;
    }

    public HttpResponse getResponse() {
        return response;
    }

    public void setResponse(HttpResponse response) {
        this.response = response;
    }
}
