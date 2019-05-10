package com.qbros.demo.controller.exceptions;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

public class ExceptionResponse {

    private String userErrorMsg;
    private String serverTime;

    public String getUserErrorMsg() {
        return userErrorMsg;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setUserErrorMsg(String userErrorMsg, String serverTime) {
        this.userErrorMsg = userErrorMsg;
        this.serverTime = serverTime;
    }
}
