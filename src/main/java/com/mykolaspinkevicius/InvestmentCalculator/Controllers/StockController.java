package com.mykolaspinkevicius.InvestmentCalculator.Controllers;

import com.mykolaspinkevicius.InvestmentCalculator.Entities.Stock;
import com.mykolaspinkevicius.InvestmentCalculator.JPA.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockRepository repository;

    @GetMapping("/stocks")
    List<Stock> all() {
        return repository.findAll();
    }
}
