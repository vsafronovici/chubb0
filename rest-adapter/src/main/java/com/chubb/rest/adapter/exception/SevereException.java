package com.chubb.rest.adapter.exception;

/**
 * Created by vsafronovici on 10/12/2016.
 */
public class SevereException extends RuntimeException {

    public SevereException(String message) {
        super(message);
    }

    public SevereException(String message, Throwable e) {
        super(message, e);
    }

}
