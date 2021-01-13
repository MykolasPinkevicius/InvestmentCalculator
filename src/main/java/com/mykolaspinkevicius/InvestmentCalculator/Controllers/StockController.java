package com.mykolaspinkevicius.InvestmentCalculator.Controllers;

import com.mykolaspinkevicius.InvestmentCalculator.Entities.Stock;
import com.mykolaspinkevicius.InvestmentCalculator.Http.HttpRequests;
import com.mykolaspinkevicius.InvestmentCalculator.JPA.StockRepository;
import com.mykolaspinkevicius.InvestmentCalculator.Market.Stack.MarketStackApiImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class StockController {

    @Autowired
    private StockRepository repository;

    @GetMapping("/stocks")
    List<Stock> getAllStocks() {
        return repository.findAll();
    }

    @GetMapping("/updateStocksPrices")
    void updateAllStocks() {
        List<Stock> allStocks = getAllStocks();
        allStocks.stream().forEach(x -> {
            try {
                Optional<String> stockPrice = HttpRequests
                        .getApacheHttpClientResponseFromURL(
                                MarketStackApiImplementation.getStockPrices(x.getTickerSymbol()));
                stockPrice.ifPresent(y -> x.setLastPrice(new BigDecimal(y)));
                repository.save(x);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        );
    }

}
