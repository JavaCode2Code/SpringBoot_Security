package com.scjp.dto;

import lombok.Getter;
import lombok.Setter;
//

public class ISPSubscriberRequest {

	/* @NotBlank(message = "Subscriber ID is required") */
    private String subscriberId;

  //  @NotBlank(message = "Name is required")
    private String name;

	/*
	 * @NotBlank(message = "Phone number is required")
	 * 
	 * @Pattern( regexp = "^[0-9]{10}$", message =
	 * "Phone number must contain 10 digits" )
	 */
    private String phoneNumber;

    //@NotBlank(message = "Status is required")
    private String status;

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

	public ISPSubscriberRequest(String subscriberId, String name, String phoneNumber, String status) {
		this.subscriberId = subscriberId;
		this.phoneNumber=phoneNumber;
		this.name = name;
		this.status = status;
	}
}