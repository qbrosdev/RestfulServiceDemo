package com.qbros.demo.controller.exceptions;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class ControllerException extends RuntimeException {

    private static final long serialVersionUID = 708429865719324158L;
    protected String DefaultMessage;

    public ControllerException(String s) {
        super(s);
    }
}
