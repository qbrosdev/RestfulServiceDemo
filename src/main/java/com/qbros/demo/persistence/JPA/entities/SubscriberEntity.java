package com.qbros.demo.persistence.JPA.entities;

import javax.persistence.*;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@Entity
@Table(name = "subscriberTable")
public class SubscriberEntity extends BaseEntity {

    private long userId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public SubscriberEntity() {
    }

    public SubscriberEntity(long userId, long subscriptionId) {
        this.userId = userId;
        this.id = subscriptionId;
    }
}