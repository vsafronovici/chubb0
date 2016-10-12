package com.chubb.rest.adapter.util;

import ch.qos.logback.core.util.FileUtil;
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

    public static synchronized Map<String, String> getProperties() {
        if (properties == null) {
            File file = new File(propertyFile);
            InputStream inputStream = null;

            try {
                inputStream = FileUtils.openInputStream(file);
                Properties prop = new Properties();
                if (inputStream != null) {
                    prop.load(inputStream);
                } else {
                    throw new FileNotFoundException("property file '" + propertyFile + "' not found in the classpath");
                }
                properties = new HashMap<>();
                prop.stringPropertyNames().forEach(
                        (key) ->{
                            properties.put(key, (prop.getProperty(key)));
                        }
                );
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
        return PropertyCache.properties;
    }
}
