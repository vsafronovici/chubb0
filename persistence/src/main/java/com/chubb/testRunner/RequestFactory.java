package com.chubb.testRunner;

/**
 * Created by ichistruga on 10/10/2016.
 */
public class RequestFactory {

    public Request GetRequest(Connection connection){
       return new Request(connection);
    }
}
