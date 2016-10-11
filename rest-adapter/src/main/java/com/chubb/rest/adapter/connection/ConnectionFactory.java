package com.chubb.rest.adapter.connection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ichistruga on 10/10/2016.
 */


public final class ConnectionFactory {

    private static final Map<String, Connection> pool = Collections.synchronizedMap(new HashMap<>());

    private ConnectionFactory() {

        }

    public static Connection getConnection(String url){
        Connection connection =  pool.get(url);
        if (connection == null) {
            connection = new Connection(url);
            pool.put(url, connection);
        }
        return connection;
    }

}
