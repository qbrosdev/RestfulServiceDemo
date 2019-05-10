package com.qbros.demo.controller.exceptions;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

public class BadParameterException extends ControllerException {

    private static final long serialVersionUID = 3676827844566701553L;

    {
        DefaultMessage = "invalid client input";
    }


    public BadParameterException(String s) {
        super(s);
    }
}
