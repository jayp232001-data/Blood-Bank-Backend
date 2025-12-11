package com.example.controller;


import com.example.model.BloodRequest;
import com.example.model.BloodStock;
import com.example.repository.BloodStockRepository;
import com.example.repository.UserRepository;
import com.example.service.impl.BloodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blood-requests")
public class BloodRequestController {

    private final BloodRequestService service;

    @Autowired
    private BloodStockRepository bloodStockRepository;

    @Autowired
    private UserRepository userRepository;

    public BloodRequestController(BloodRequestService service) {
        this.service = service;
    }

    // CREATE BLOOD REQUEST
    @PostMapping
    public ResponseEntity<BloodRequest> create(@RequestBody BloodRequest request) {

        if (userRepository.findByEmail(request.getUserEmail()).isEmpty()) {
            throw new RuntimeException("User not available, please create user account");
        }
        if (StringUtils.isEmpty(request.getRequiredBloodGroup())) {
            throw new RuntimeException("BloodStock is not available");
        }

        Optional<BloodStock> bloodStock = bloodStockRepository.findById(request.getRequiredBloodGroup());
        if (request.getUserType().equalsIgnoreCase("Donor")) {

            bloodStock.get().setUnits(bloodStock.get().getUnits() + request.getQuantityRequired());
        } else if (request.getUserType().equalsIgnoreCase("Receiver")) {
            bloodStock.get().setUnits(bloodStock.get().getUnits() - request.getQuantityRequired());
        }

        return ResponseEntity.ok(service.create(request));
    }

    // FIND ALL
    @GetMapping
    public ResponseEntity<List<BloodRequest>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Blood request not found"));

    }

    // GET BY EMAIL
    @GetMapping("/email/{email}")
    public ResponseEntity<List<BloodRequest>> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getByEmail(email));
    }

    // UPDATE BY ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(
            @PathVariable Long id,
            @RequestBody BloodRequest updated
    ) {
        BloodRequest result = service.updateById(id, updated);

        if (result == null) {
            return ResponseEntity.badRequest().body("Request not found");
        }

        return ResponseEntity.ok(result);
    }
}
