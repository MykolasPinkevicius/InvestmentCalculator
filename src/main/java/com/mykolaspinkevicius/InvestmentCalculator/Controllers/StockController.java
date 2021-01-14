package com.mykolaspinkevicius.InvestmentCalculator.Controllers;

import com.mykolaspinkevicius.InvestmentCalculator.Entities.Stock;
import com.mykolaspinkevicius.InvestmentCalculator.Services.StocksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
