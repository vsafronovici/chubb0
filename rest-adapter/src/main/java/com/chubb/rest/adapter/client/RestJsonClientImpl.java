package com.chubb.rest.adapter.client;

import com.chubb.rest.adapter.request.Request;
import com.chubb.rest.adapter.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vsafronovici on 10/12/2016.
 */
@Service
public class RestJsonClientImpl implements RestJsonClient {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Response sendRequest(Request request) {
        HttpEntity<String> entity = new HttpEntity<String>(request.getBody(), request.getHeaders());
        ResponseEntity<JsonNode> responseEntity = restTemplate.exchange(request.getUrl(), request.getMethod(), entity, JsonNode.class);

        return new Response(responseEntity);
    }
}
