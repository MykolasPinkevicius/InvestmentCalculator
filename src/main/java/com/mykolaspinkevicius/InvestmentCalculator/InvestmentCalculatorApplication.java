package com.mykolaspinkevicius.InvestmentCalculator;

import com.mykolaspinkevicius.InvestmentCalculator.Http.HttpRequests;
import com.mykolaspinkevicius.InvestmentCalculator.Market.Stack.MarketStackApiImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class InvestmentCalculatorApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(InvestmentCalculatorApplication.class, args);
			HttpRequests.getApacheHttpClientResponseFromURL(MarketStackApiImplementation.getStockPrices());
	}

}
