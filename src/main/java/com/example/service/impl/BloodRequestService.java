package com.example.service.impl;


import com.example.model.BloodRequest;
import com.example.repository.BloodRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodRequestService {

    private final BloodRequestRepository repository;

    public BloodRequestService(BloodRequestRepository repository) {
        this.repository = repository;
    }

    public List<BloodRequest> getAll() {
        return repository.findAll();
    }

    public Optional<BloodRequest> getById(Long id) {
        return repository.findById(id);
    }

    public List<BloodRequest> getByEmail(String email) {
        return repository.findByUserEmail(email);
    }

    public BloodRequest create(BloodRequest request) {
        return repository.save(request);
    }

    public BloodRequest updateById(Long id, BloodRequest updatedData) {
        Optional<BloodRequest> existingOpt = repository.findById(id);

        if (existingOpt.isEmpty()) return null;

        BloodRequest existing = existingOpt.get();

        existing.setUserEmail(updatedData.getUserEmail());
        existing.setUserName(updatedData.getUserName());
        existing.setUserType(updatedData.getUserType());
        existing.setRequiredBloodGroup(updatedData.getRequiredBloodGroup());
        existing.setQuantityRequired(updatedData.getQuantityRequired());
        existing.setTotalAmount(updatedData.getTotalAmount());
        existing.setUrgencyLevel(updatedData.getUrgencyLevel());
        existing.setHospitalName(updatedData.getHospitalName());
        existing.setReferredBy(updatedData.getReferredBy());
        existing.setPurposeOfIssue(updatedData.getPurposeOfIssue());

        return repository.save(existing);
    }
}

