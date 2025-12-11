package com.example.service.impl;

import com.example.model.BloodStock;
import com.example.repository.BloodStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BloodStockService {

    @Autowired
    private BloodStockRepository repository;

    public List<BloodStock> getAll() {
        return repository.findAll();
    }

    public BloodStock add(BloodStock stock) {
        return repository.save(stock);
    }
}
