package com.example.LaptopSuggestion.service;

import com.example.LaptopSuggestion.model.Laptop;
import com.example.LaptopSuggestion.repository.LaptopRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopSuggestionService {
    @Autowired
    private LaptopRepository laptoprepository;
    private final JPAStreamer jpaStreamer;

    public LaptopSuggestionService(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public Laptop saveProduct(Laptop laptop) {
        return laptoprepository.save(laptop);
    }
    public List<Laptop> suggestLaptops(String brand, double maxPrice, int minRam, String processorType) {
        return jpaStreamer.stream(Laptop.class)
                .filter(laptop -> laptop.getBrand().equalsIgnoreCase(brand))
                .filter(laptop -> laptop.getPrice() <= maxPrice)
                .filter(laptop -> laptop.getRam() >= minRam)
                .filter(laptop -> laptop.getProcessor().equalsIgnoreCase(processorType))
                .toList();
    }
}
