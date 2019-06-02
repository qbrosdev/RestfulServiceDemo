package com.qbros.demo.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
@Getter
@Setter
public class SubscriberDTO extends BaseDTO {

    @NotNull (message = "not a valid user! valid users have ids :(")
    private long userId;
    private long subscriptionId;
    private Date createdAt;

}
