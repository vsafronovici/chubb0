package com.chubb.rest.adapter.util;

import com.chubb.rest.adapter.test.Test1;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Created by vsafronovici on 10/11/2016.
 */
public final  class JsonUtil {

    private static final String JACKSON_PATH_DELIMITER = "/";

    private JsonUtil() {
    }

    public static JsonNode convert(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.reader();
        JsonNode jsonNode = mapper.reader().readTree(json);
        return jsonNode;
    }

    public static JsonNode findNodeByPath(JsonNode jsonNode, String path) throws IOException {
        String jacksonPath = JACKSON_PATH_DELIMITER.concat(path.replaceAll("\\.", JACKSON_PATH_DELIMITER));
        return jsonNode.at(jacksonPath);
    }



}
