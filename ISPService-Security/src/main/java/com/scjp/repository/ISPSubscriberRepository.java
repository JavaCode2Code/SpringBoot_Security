package com.scjp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scjp.entity.ISPSubscriber;
import org.springframework.stereotype.Repository;

@Repository
public interface ISPSubscriberRepository
        extends JpaRepository<ISPSubscriber, Long> {

    Optional<ISPSubscriber> findBySubscriberId(
            String subscriberId
    );

    boolean existsBySubscriberId(
            String subscriberId
    );

    boolean existsByPhoneNumber(
            String phoneNumber
    );

    boolean existsBySubscriberIdAndIdNot(
            String subscriberId,
            Long id
    );

    boolean existsByPhoneNumberAndIdNot(
            String phoneNumber,
            Long id
    );
}