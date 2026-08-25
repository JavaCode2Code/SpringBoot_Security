package com.scjp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scjp.dto.PhoneSubscribeRequest;
import com.scjp.dto.PhoneSubscribeResponse;
import com.scjp.entity.PhoneSubscriber;
import com.scjp.exception.DuplicateResourceException;
import com.scjp.exception.ResourceNotFoundException;
import com.scjp.repository.PhoneSubscriberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
public class PhoneSubscriberService {

	
    private final PhoneSubscriberRepository repository;
    @Autowired
    public PhoneSubscriberService(PhoneSubscriberRepository repository) {
		this.repository = repository;
	}

	// CREATE
    public PhoneSubscribeResponse create(
            PhoneSubscribeRequest request) {

        if (repository.existsByPhoneNumber(
                request.getPhoneNumber())) {

            throw new DuplicateResourceException(
                    "Phone number already subscribed: "
                            + request.getPhoneNumber()
            );
        }

        PhoneSubscriber subscription =
                new PhoneSubscriber(request.getPhoneNumber(),request.getSubscriptionType(),request.getStatus());

        subscription.setPhoneNumber(
                request.getPhoneNumber()
        );

        subscription.setSubscriptionType(
                request.getSubscriptionType()
        );

        subscription.setStatus(
                request.getStatus()
        );

        PhoneSubscriber saved =
                repository.save(subscription);

        return toResponse(saved);
    }

    // GET BY ID
    @Transactional()
    public PhoneSubscribeResponse getById(Long id) {

        PhoneSubscriber subscription =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Phone subscription not found with id: "
                                                + id
                                )
                        );

        return toResponse(subscription);
    }

    // GET ALL


    // UPDATE
    public PhoneSubscribeResponse update(
            Long id,
            PhoneSubscribeRequest request) {

        PhoneSubscriber subscription =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Phone subscription not found with id: "
                                                + id
                                )
                        );

        if (repository.existsByPhoneNumberAndIdNot(
                request.getPhoneNumber(),
                id)) {

            throw new DuplicateResourceException(
                    "Phone number already subscribed: "
                            + request.getPhoneNumber()
            );
        }

        subscription.setPhoneNumber(
                request.getPhoneNumber()
        );

        subscription.setSubscriptionType(
                request.getSubscriptionType()
        );

        subscription.setStatus(
                request.getStatus()
        );

        PhoneSubscriber updated =
                repository.save(subscription);

        return toResponse(updated);
    }

    // DELETE
    public void delete(Long id) {

        PhoneSubscriber subscription =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Phone subscription not found with id: "
                                                + id
                                )
                        );

        repository.delete(subscription);
    }

    private PhoneSubscribeResponse toResponse(
            PhoneSubscriber subscription) {

        return new PhoneSubscribeResponse(
                subscription.getId(),
                subscription.getPhoneNumber(),
                subscription.getSubscriptionType(),
                subscription.getStatus()
        );
    }
}