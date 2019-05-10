package com.qbros.demo.service.exceptions;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class ServerException extends RuntimeException {

    protected String DefaultMessage;

    public ServerException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return DefaultMessage + super.getMessage();
    }
}
