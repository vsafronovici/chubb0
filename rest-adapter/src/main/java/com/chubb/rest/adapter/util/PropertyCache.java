package com.chubb.rest.adapter.util;

import ch.qos.logback.core.util.FileUtil;
import com.chubb.rest.adapter.exception.CriticalException;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by ichistruga on 10/11/2016.
 */
public class PropertyCache {

    private final static String propertyFile = "rest-config.properties";

    private static Map<String, String> properties;

    private static synchronized Map<String, String> getProperties() {
        if (properties == null) {
            File file = new File(propertyFile);
            InputStream inputStream = null;

            try {
                inputStream = FileUtils.openInputStream(file);
                Properties prop = new Properties();
                prop.load(inputStream);
                properties = new HashMap<>();
                prop.stringPropertyNames().forEach(
                        (key) -> {
                            properties.put(key, (prop.getProperty(key)));
                        }
                );
            } catch (Exception e) {
                throw new CriticalException(e.getMessage(), e);
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
        return properties;
    }

    public static String getProperty(String key) {
        return getProperties().get(key);
    }
}
