package com.scjp.dto;

import lombok.Getter;
import lombok.Setter;


public class PhoneSubscribeRequest {

   // @NotBlank(message = "Phone number is required")
	/*
	 * @Pattern( regexp = "^[0-9]{10}$", message =
	 * "Phone number must contain 10 digits" )
	 */
    private String phoneNumber;

   // @NotBlank(message = "Subscription type is required")
    private String subscriptionType;

   // @NotBlank(message = "Status is required")
    private String status;

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