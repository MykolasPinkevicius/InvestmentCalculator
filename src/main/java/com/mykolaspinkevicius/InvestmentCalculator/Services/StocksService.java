package com.mykolaspinkevicius.InvestmentCalculator.Services;

import com.mykolaspinkevicius.InvestmentCalculator.Entities.Stock;
import com.mykolaspinkevicius.InvestmentCalculator.Http.HttpRequests;
import com.mykolaspinkevicius.InvestmentCalculator.JPA.StockRepository;
import com.mykolaspinkevicius.InvestmentCalculator.Market.Stack.MarketStackApiImplementation;
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
