package com.example.LaptopSuggestion.repository;

import org.springframework.stereotype.Repository;
import com.example.LaptopSuggestion.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
