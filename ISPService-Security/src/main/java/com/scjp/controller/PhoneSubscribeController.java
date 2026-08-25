package com.scjp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scjp.dto.PhoneSubscribeRequest;
import com.scjp.dto.PhoneSubscribeResponse;
import com.scjp.service.impl.PhoneSubscriberService;


@RestController
@RequestMapping("/api/phoneSub")
//@RequiredArgsConstructor
public class PhoneSubscribeController {


    private final PhoneSubscriberService service;

    public PhoneSubscribeController(PhoneSubscriberService service) {
        this.service = service;
    }

    @PostMapping("create")
    public ResponseEntity<PhoneSubscribeResponse> create(
           // @Valid
            @RequestBody PhoneSubscribeRequest request) {
        PhoneSubscribeResponse response=service.create(request);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneSubscribeResponse> getById(
            @PathVariable Long id) {
        PhoneSubscribeResponse response=service.getById(id);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PhoneSubscribeResponse> update(
            @PathVariable Long id,
         //   @Valid
            @RequestBody PhoneSubscribeRequest request) {
        PhoneSubscribeResponse response=service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> delete(
            @PathVariable Long id) {

        service.delete(id);

        Map<String,String> resp=new HashMap<>();
        resp.put("message","PhoneSubscription Successfully Deleted");
        return ResponseEntity.ok(resp);
    }
}