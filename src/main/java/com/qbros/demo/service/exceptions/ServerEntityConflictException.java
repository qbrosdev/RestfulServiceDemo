package com.qbros.demo.service.exceptions;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

public class ServerEntityConflictException extends ServerException {

    private static final long serialVersionUID = -2437696455995528911L;

    {
        DefaultMessage = "### Resource Conflict";
    }

    public ServerEntityConflictException(String s) {
        super(s);
    }


}
