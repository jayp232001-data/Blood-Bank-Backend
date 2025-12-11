package com.example.controller;

import com.example.model.BloodStock;
import com.example.service.impl.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood-stock")
public class BloodStockController {

    @Autowired
    private BloodStockService service;

    @GetMapping
    public List<BloodStock> getAllStock() {
        return service.getAll();
    }

    @PostMapping
    public BloodStock createStock(@RequestBody BloodStock stock) {
        return service.add(stock);
    }
}