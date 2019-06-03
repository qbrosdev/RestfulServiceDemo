package com.qbros.demo.controller.exceptions;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@Getter
@Builder
public class ExceptionResponse {

    private String userErrorMsg;
    private String serverTime;

    public void setUserErrorMsg(String userErrorMsg, String serverTime) {
        this.userErrorMsg = userErrorMsg;
        this.serverTime = serverTime;
    }
}
