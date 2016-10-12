package com.chubb.rest.adapter.request;

import com.chubb.rest.adapter.connection.Connection;
import com.chubb.rest.adapter.util.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Created by vsafronovici on 10/11/2016.
 */
public final class RequestFactory {

    private RequestFactory() {}

    public static Request create(Connection connection, String requestJson) throws IOException {
        JsonNode requestNode = JsonUtil.convert(requestJson);
        String resource = requestNode.at("/request/Resource").asText();
        String url = connection.getServer().concat(resource);
        //String method = requestNode.get("method");

        Request request = new Request();
        request.setUrl(url);


        return request;
    }
}
