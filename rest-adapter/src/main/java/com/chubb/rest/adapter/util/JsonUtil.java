package com.chubb.rest.adapter.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;

/**
 * Created by vsafronovici on 10/11/2016.
 */
public final  class JsonUtil {

    private JsonUtil() {
    }

    public static JsonNode convert(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.reader();
        JsonNode jsonNode = mapper.reader().readTree(json);


        return jsonNode;
    }
}
