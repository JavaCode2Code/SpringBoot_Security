package com.scjp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class ISPSubscriberResponse {

    private Long id;

    private String subscriberId;

    private String name;

    private String phoneNumber;

    private String status;

    public ISPSubscriberResponse(Long id, String subscriberId, String name, String phoneNumber, String status) {
        this.id = id;
        this.subscriberId = subscriberId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public ISPSubscriberResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}