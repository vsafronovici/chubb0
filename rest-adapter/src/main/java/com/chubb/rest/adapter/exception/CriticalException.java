package com.chubb.rest.adapter.exception;

/**
 * Created by vsafronovici on 10/12/2016.
 */
public class CriticalException extends RuntimeException {

    public CriticalException(String message) {
        super(message);
    }
    public CriticalException(String message, Throwable e) {
        super(message, e);
    }
}
