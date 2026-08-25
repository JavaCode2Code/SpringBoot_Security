package com.scjp.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scjp.dto.ISPSubscriberRequest;
import com.scjp.dto.ISPSubscriberResponse;
import com.scjp.entity.ISPSubscriber;
import com.scjp.exception.DuplicateResourceException;
import com.scjp.exception.ResourceNotFoundException;
import com.scjp.repository.ISPSubscriberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
public class ISPSubscriberService {


    private final ISPSubscriberRepository repository;

    public ISPSubscriberService(ISPSubscriberRepository repository) {
		this.repository = repository;
	}

	// CREATE
    public ISPSubscriberResponse create(
            ISPSubscriberRequest request) {

        if (repository.existsBySubscriberId(
                request.getSubscriberId())) {

            throw new DuplicateResourceException(
                    "Subscriber ID already exists: "
                            + request.getSubscriberId()
            );
        }

        if (repository.existsByPhoneNumber(
                request.getPhoneNumber())) {

            throw new DuplicateResourceException(
                    "Phone number already exists: "
                            + request.getPhoneNumber()
            );
        }

        ISPSubscriber subscriber =
                new ISPSubscriber(request.getSubscriberId(),request.getPhoneNumber(),request.getStatus(),request.getName());


        subscriber.setSubscriberId(
                request.getSubscriberId()
        );

        subscriber.setName(
                request.getName()
        );

        subscriber.setPhoneNumber(
                request.getPhoneNumber()
        );

        subscriber.setStatus(
                request.getStatus()
        );

        ISPSubscriber saved =
                repository.save(subscriber);

        return toResponse(saved);
    }

    // GET BY ID
    @Transactional(readOnly = true)
    public ISPSubscriberResponse getById(Long id) {

        ISPSubscriber subscriber =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Subscriber not found with id: "
                                                + id
                                )
                        );

        return toResponse(subscriber);
    }

    // GET ALL
    @Transactional(readOnly = true)
    public List<ISPSubscriberResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // UPDATE
    public ISPSubscriberResponse update(
            Long id,
            ISPSubscriberRequest request) {

        ISPSubscriber subscriber =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Subscriber not found with id: "
                                                + id
                                )
                        );

        if (repository.existsBySubscriberIdAndIdNot(
                request.getSubscriberId(),
                id)) {

            throw new DuplicateResourceException(
                    "Subscriber ID already exists: "
                            + request.getSubscriberId()
            );
        }

        if (repository.existsByPhoneNumberAndIdNot(
                request.getPhoneNumber(),
                id)) {

            throw new DuplicateResourceException(
                    "Phone number already exists: "
                            + request.getPhoneNumber()
            );
        }

        subscriber.setSubscriberId(
                request.getSubscriberId()
        );

        subscriber.setName(
                request.getName()
        );

        subscriber.setPhoneNumber(
                request.getPhoneNumber()
        );

        subscriber.setStatus(
                request.getStatus()
        );

        ISPSubscriber updated =
                repository.save(subscriber);

        return toResponse(updated);
    }

    // DELETE
    public void delete(Long id) {

        ISPSubscriber subscriber =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Subscriber not found with id: "
                                                + id
                                )
                        );

        repository.delete(subscriber);
    }

    private ISPSubscriberResponse toResponse(
            ISPSubscriber subscriber) {

        return new ISPSubscriberResponse(
                subscriber.getId(),
                subscriber.getSubscriberId(),
                subscriber.getName(),
                subscriber.getPhoneNumber(),
                subscriber.getStatus()
        );
    }
}