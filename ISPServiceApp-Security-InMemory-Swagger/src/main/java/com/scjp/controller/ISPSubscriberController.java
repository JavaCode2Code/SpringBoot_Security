package com.scjp.controller;


import com.scjp.dto.ISPSubscriberRequest;
import com.scjp.dto.ISPSubscriberResponse;
import com.scjp.service.impl.ISPSubscriberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ispSub")
//@RequiredArgsConstructor
@Tag(name = "ISP Subscribers", description = "Manage ISP subscribers")
public class ISPSubscriberController {


    private final ISPSubscriberService service;

    public ISPSubscriberController(ISPSubscriberService service) {
        this.service = service;
    }


    @Operation(summary = "Create a new ISP subscriber")
    @PostMapping("/create")
    public ResponseEntity<ISPSubscriberResponse> create(
            @RequestBody ISPSubscriberRequest request) {
        ISPSubscriberResponse created = service.create(request);
        return new ResponseEntity<>
                (created, HttpStatus.CREATED);
    }

    @Operation(summary = "Get ISP subscriber by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ISPSubscriberResponse> getById(
            @PathVariable Long id) {
        ISPSubscriberResponse ISPResponse = service.getById(id);
        return ResponseEntity.ok(ISPResponse);

    }

    @Operation(summary = "List all ISP subscribers")
    @GetMapping("getALL")
    public ResponseEntity<List<ISPSubscriberResponse>> getAll() {
        List<ISPSubscriberResponse> ISPList = service.getAll();
        return ResponseEntity.ok(ISPList
        );
    }

    @Operation(summary = "Update ISP subscriber by ID")
    @PutMapping("/{id}")
    public ResponseEntity<ISPSubscriberResponse> update(
            @PathVariable Long id,
            @RequestBody ISPSubscriberRequest request) {
        ISPSubscriberResponse ispResonse = service.update(id, request);
        return ResponseEntity.ok(ispResonse);

    }

    @Operation(summary = "Delete ISP subscriber by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @PathVariable Long id) {
        service.delete(id);
        Map<String, String> res = new HashMap<>();
        res.put("message", "ISP Successful deleting");
        return ResponseEntity.ok(res);
    }
}