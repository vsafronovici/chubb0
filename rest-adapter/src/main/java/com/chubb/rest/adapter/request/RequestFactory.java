package com.chubb.rest.adapter.request;

import com.chubb.rest.adapter.connection.Connection;
import com.chubb.rest.adapter.exception.SevereException;
import com.chubb.rest.adapter.util.FileUtil;
import com.chubb.rest.adapter.util.JsonUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by vsafronovici on 10/11/2016.
 */
public final class RequestFactory {

    private RequestFactory() {}

    public static Request create(Connection connection, String requestJson) throws IOException {
        JsonNode requestNode = JsonUtil.convert(requestJson);
        String resource = JsonUtil.findNodeByPath(requestNode, "request.Resource").asText();
        final String url = connection.getServer().concat(resource);
        //String method = requestNode.at("/request/Method").asText();
        final String method = JsonUtil.findNodeByPath(requestNode, "request.Method").asText();

        final HttpHeaders headers = new HttpHeaders();
        JsonNode headersNode = JsonUtil.findNodeByPath(requestNode, "request.Headers");
        if (!(headersNode instanceof MissingNode)) {
            Iterator<Map.Entry<String, JsonNode>> it = headersNode.fields();
            while(it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                headers.add(entry.getKey(), entry.getValue().asText());
            }
        }

        String bodyFile = JsonUtil.findNodeByPath(requestNode, "request.Body").textValue();
        String body = null;
        if (bodyFile != null) {
            //TODO read from Root (System property)
            String jsonFilePath = JsonUtil.class.getResource(String.format("/request/%s", bodyFile)).getFile();
            try {
                body = JsonUtil.loadFromFile(jsonFilePath).toString();
            } catch (FileNotFoundException e) {
                throw new SevereException(e.getMessage(), e);
            } catch (JsonParseException e) {
                throw new SevereException("Invalid Json format for file: " + jsonFilePath);
            }
        }

        Request request = new Request();
        request.setHeaders(headers);
        request.setUrl(url);
        request.setMethod(HttpMethod.resolve(method));
        request.setBody(body);


        return request;
    }
}
