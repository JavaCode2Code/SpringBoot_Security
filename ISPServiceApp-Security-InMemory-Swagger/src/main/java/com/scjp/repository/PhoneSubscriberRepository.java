package com.scjp.repository;

import com.scjp.entity.PhoneSubscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface PhoneSubscriberRepository
        extends JpaRepository<PhoneSubscriber, Long> {

    Optional<PhoneSubscriber> findByPhoneNumber(
            String phoneNumber
    );

    boolean existsByPhoneNumber(
            String phoneNumber
    );

    boolean existsByPhoneNumberAndIdNot(
            String phoneNumber,
            Long id
    );
}