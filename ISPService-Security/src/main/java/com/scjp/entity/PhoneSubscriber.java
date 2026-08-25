package com.scjp.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "phone_subscribe"
     /*   uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "phone_number"
                )
        }*/
)

public class PhoneSubscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "phone_number",
            nullable = false
    )
    private String phoneNumber;

    @Column(
            name = "subscription_type",
            nullable = false
    )
    private String subscriptionType;

    @Column(nullable = false)
    private String status;

    public PhoneSubscriber(String phoneNumber, String subscriptionType, String status) {
        this.phoneNumber = phoneNumber;
        this.subscriptionType = subscriptionType;
        this.status = status;
        this.id = id;
    }

    public PhoneSubscriber() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}