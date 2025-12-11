package com.example.repository;

import com.example.model.BloodStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodStockRepository extends JpaRepository<BloodStock, String> {
}
