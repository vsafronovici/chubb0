package com.chubb.testRunner.utils;

/**
 * Created by ichistruga on 10/11/2016.
 */
public class Response {

    private int status;

    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
