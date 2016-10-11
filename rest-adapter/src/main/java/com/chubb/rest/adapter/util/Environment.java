package com.chubb.rest.adapter.util;

/**
 * Created by ichistruga on 10/11/2016.
 */
public class Environment {

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Environment.name = name;
    }

    private static String name;
}
