package com.scjp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="isp_subscriber")
       /* uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "subscriber_id"
                ),
                @UniqueConstraint(
                        columnNames = "phone_number"
                )
        }
)*/

public class ISPSubscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "subscriber_id",
            nullable = false
    )
    private String subscriberId;

    @Column(nullable = false)
    private String name;

    @Column(
            name = "phone_number",
            nullable = false
    )
    private String phoneNumber;

    @Column(nullable = false)
    private String status;

    public ISPSubscriber(String phoneNumber,String name, String subscriberId, String status) {
        this.subscriberId = subscriberId;
        this.phoneNumber=phoneNumber;
        this.status = status;
    }

    public ISPSubscriber() {

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