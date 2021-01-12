package com.mykolaspinkevicius.InvestmentCalculator;

import com.mykolaspinkevicius.InvestmentCalculator.Market.Stack.MarketStackApiImplementation;
import com.mykolaspinkevicius.InvestmentCalculator.StockUtils.StocksUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class InvestmentCalculatorApplication {

	public static final String APPLE_STOCK_SYMBOL = "AAPL";
	@Autowired
	private static MarketStackApiImplementation market;

	public static void main(String[] args) {
		SpringApplication.run(InvestmentCalculatorApplication.class, args);
		try {
			System.out.println(market.getStockPrices(StocksUtils.getMarketStackApiKey(), APPLE_STOCK_SYMBOL));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
