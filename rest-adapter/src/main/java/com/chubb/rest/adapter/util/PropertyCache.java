package com.chubb.rest.adapter.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.InputStream;
import java.util.*;

/**
 * Created by ichistruga on 10/11/2016.
 */
public class PropertyCache {

    private final static String propertyFile = "config.properties";

    public final static String urlKey = "url";

    private static Map<String, String> properties;

    public static synchronized Map<String, String> getProperties() {
        if (properties == null) {
            File file = new File(
                    (Environment.getName().length() == 0 ? "" : Environment.getName() + "//")
                            + propertyFile);
            InputStream inputStream = null;

            try {
                inputStream = FileUtils.openInputStream(file);
                Properties prop = new Properties();
                prop.load(inputStream);
                properties = new HashMap<>();
                properties.put(urlKey, prop.getProperty(urlKey));
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
        return PropertyCache.properties;
    }
}
