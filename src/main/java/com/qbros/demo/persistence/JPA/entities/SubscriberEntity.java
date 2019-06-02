package com.qbros.demo.persistence.JPA.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by QBros on Zero Hour ... Hooah!
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "subscriberTable")
public class SubscriberEntity extends BaseEntity {

    private long userId;
}