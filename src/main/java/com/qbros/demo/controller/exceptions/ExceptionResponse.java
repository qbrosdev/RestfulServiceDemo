package com.qbros.demo.controller.exceptions;

import lombok.Getter;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@Getter
public class ExceptionResponse {

    private String userErrorMsg;
    private String serverTime;

    public void setUserErrorMsg(String userErrorMsg, String serverTime) {
        this.userErrorMsg = userErrorMsg;
        this.serverTime = serverTime;
    }
}
