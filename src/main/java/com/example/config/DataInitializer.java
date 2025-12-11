package com.example.config;

import com.example.model.BloodStock;
import com.example.repository.BloodStockRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initBloodStock(BloodStockRepository repo) {
        return args -> {

            addStockIfNotExists(repo, "A+", 150);
            addStockIfNotExists(repo, "A-", 120);
            addStockIfNotExists(repo, "B+", 180);
            addStockIfNotExists(repo, "B-", 110);
            addStockIfNotExists(repo, "O+", 200);
            addStockIfNotExists(repo, "O-", 140);
            addStockIfNotExists(repo, "AB+", 130);
            addStockIfNotExists(repo, "AB-", 100);

            System.out.println("✅ Default 3-digit Blood Stock Loaded Successfully!");
        };
    }

    private void addStockIfNotExists(BloodStockRepository repo, String group, int qty) {

        // If blood group already exists → DO NOTHING, NO EXCEPTION
        Optional<BloodStock> existing = repo.findById(group);

        if (!existing.isPresent()) {
            BloodStock stock = new BloodStock();
            stock.setBloodGroup(group);
            stock.setUnits(qty);
            repo.save(stock);
        }
    }
}

