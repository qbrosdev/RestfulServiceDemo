package com.qbros.demo.service.exceptions;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

public class ServerEntityNotFoundException extends ServerException {

    private static final long serialVersionUID = 6636127651870265838L;

    {
        DefaultMessage = "### Entity not found";
    }

    public ServerEntityNotFoundException(String s) {
        super(s);
    }
}
