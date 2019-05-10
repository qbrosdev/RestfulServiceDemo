package com.qbros.demo.controller.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */
public class SubscriberDTO extends BaseDTO {

    @NotNull (message = "not a valid user! valid users have ids :(")
    private long userId;

    private long subscriptionId;

    private Date createdAt;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
