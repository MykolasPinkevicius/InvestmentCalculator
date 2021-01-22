package com.mykolaspinkevicius.investmentcalculator.services;

import com.mykolaspinkevicius.investmentcalculator.entities.Stock;
import com.mykolaspinkevicius.investmentcalculator.http.HttpRequests;
import com.mykolaspinkevicius.investmentcalculator.jpa.StockRepository;
import com.mykolaspinkevicius.investmentcalculator.market.stack.MarketStackApiImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class StocksService {

    public static final String WELCOME_MESSAGE = "Welcome to your investment calculator";
    @Autowired
    private StockRepository repository;
    @Autowired
    private MarketStackApiImplementation marketStack;
    @Autowired
    private HttpRequests request;


    public List<Stock> findAll() {
        return repository.findAll();
    }

    public void updateAllStocks() {
        List<Stock> allStocks = findAll();
        allStocks.forEach(x -> {
                    try {
                        Optional<String> stockPrice = request.getApacheHttpClientResponseFromURL
                                (marketStack.appendRequestWithSymbol(x.getTickerSymbol()));
                        stockPrice.ifPresent(y -> x.setLastPrice(new BigDecimal(y)));
                        repository.save(x);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    public void createStock(Stock stock) {
        repository.save(stock);
    }

    public String welcome() {
        return WELCOME_MESSAGE;

    }
}
