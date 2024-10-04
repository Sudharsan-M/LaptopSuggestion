package com.example.LaptopSuggestion.Controller;

import com.example.LaptopSuggestion.model.Laptop;
import com.example.LaptopSuggestion.repository.LaptopRepository;
import com.example.LaptopSuggestion.service.LaptopSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopSuggestionController {
    @Autowired
    private LaptopSuggestionService laptopSuggestionService;

    @PostMapping("/add")
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        return laptopSuggestionService.saveProduct(laptop);
    }

    @GetMapping("/suggest")
    public List<Laptop> suggestLaptops(
            @RequestParam String brand,
            @RequestParam double maxPrice,
            @RequestParam int minRam,
            @RequestParam String processor) {
        return laptopSuggestionService.suggestLaptops(brand, maxPrice, minRam, processor);
    }
}
