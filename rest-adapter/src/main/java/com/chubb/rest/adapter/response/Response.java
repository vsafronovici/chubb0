package com.chubb.rest.adapter.response;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by ichistruga on 10/11/2016.
 */
public class Response {

    private final ResponseEntity<JsonNode> responseEntity;

    public Response(ResponseEntity<JsonNode> responseEntity) {
        this.responseEntity = responseEntity;
    }

    public int getStatusCode() {
        return responseEntity.getStatusCodeValue();
    }

    public HttpStatus getHttpStatus() {
        return responseEntity.getStatusCode();
    }

    public JsonNode getBody() {
        return responseEntity.getBody();
    }

    public String getBodyAsString() {
        return getBody().toString();
    }

}
