package com.qbros.demo.service.exceptions;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

public class ServerServiceNotSupportedException extends ServerException {
    private static final long serialVersionUID = -7221690756236423294L;

    {
        DefaultMessage = "Service not supported";
    }

    public ServerServiceNotSupportedException(String s) {
        super(s);
    }


}
