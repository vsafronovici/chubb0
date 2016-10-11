package com.chubb.testRunner;

import java.util.*;

/**
 * Created by ichistruga on 10/10/2016.
 */


public class ConnectionFactory {

    private static final Map<String, Connection> pool = Collections.synchronizedMap(new HashMap<>());

    private ConnectionFactory() {

        }

    public static Connection getConnection(String url){
        if (!pool.containsKey(url)) {
            Connection connection = new Connection();
            connection.setUrl(url);

            pool.put(url, connection);

            return connection;
        } else {
            return pool.get(url);
        }
    }

}
