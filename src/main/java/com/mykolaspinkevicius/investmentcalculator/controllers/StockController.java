package com.mykolaspinkevicius.investmentcalculator.controllers;

import com.mykolaspinkevicius.investmentcalculator.entities.Stock;
import com.mykolaspinkevicius.investmentcalculator.services.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StocksService stocksService;

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return stocksService.findAll();
    }

    @GetMapping("/updateStocksPrices")
    public void updateAllStocks() {
        stocksService.updateAllStocks();
    }

    @PostMapping("/addStock")
    public void addStock(@RequestBody Stock stock) {
        stocksService.createStock(stock);
    }

    @GetMapping("/")
    public String welcome() {
        return stocksService.welcome();
    }
}
