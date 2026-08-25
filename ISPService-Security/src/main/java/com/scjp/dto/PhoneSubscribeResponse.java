package com.scjp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class PhoneSubscribeResponse {

    private Long id;
    private String phoneNumber;
    private String subscriptionType;
    private String status;

    public PhoneSubscribeResponse(Long id, String phoneNumber, String subscriptionType, String status) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.subscriptionType = subscriptionType;
        this.status = status;
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