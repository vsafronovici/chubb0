package com.chubb.testRunner.utils;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ichistruga on 10/10/2016.
 */
public class UrlPropertyResolver{

     private final String urlKeyName = "url";

    private String filePath = "";

    public  UrlPropertyResolver(String path){
        this.filePath = path;
    }

    public  String getUrlValue() throws IOException {

        InputStream inputStream = null;

        try {
            Properties prop = new Properties();

            inputStream = getClass().getClassLoader().getResourceAsStream(this.filePath);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + this.filePath + "' not found in the classpath");
            }

           return prop.getProperty(urlKeyName);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return null;
    }
}
