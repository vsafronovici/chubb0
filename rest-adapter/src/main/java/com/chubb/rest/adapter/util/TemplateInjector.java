package com.chubb.rest.adapter.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vsafronovici on 10/11/2016.
 */
public class TemplateInjector {

    private static Map<String, String> csv_Line = new HashMap<String, String>() {
        {
            this.put("name", "name1");
            this.put("id", "1");
        }

    };

    private static Map<String, String> data_store = new HashMap<String, String>() {
        {
            this.put("token", "dadhsakjYYUKJNkjsfds");
            this.put("customerId", "1245");
        }

    };

    public static String inject(String template, Map<String, String> csv, Map<String, String> dataStore) {
        return null;
    }

}
