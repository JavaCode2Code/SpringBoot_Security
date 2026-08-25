package com.scjp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.scjp.entity.PhoneSubscriber;
import org.springframework.stereotype.Repository;

@Repository
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