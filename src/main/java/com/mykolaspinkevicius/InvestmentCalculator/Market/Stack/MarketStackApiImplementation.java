package com.mykolaspinkevicius.InvestmentCalculator.Market.Stack;

import com.mykolaspinkevicius.InvestmentCalculator.StockUtils.StocksUtils;
import org.springframework.stereotype.Component;

@Component
public class MarketStackApiImplementation {
    private static final String MARKET_STACK_WEB_ADDRESS_FOR_REQUESTS = "http://api.marketstack.com/v1/eod?access_key=";
    private static final String LIMIT_TO_ONE_OBJECT = "&limit=1";

    public String appendRequest(String stockSymbol) {
        StringBuilder sb = new StringBuilder();
        sb.append(MARKET_STACK_WEB_ADDRESS_FOR_REQUESTS);
        sb.append(StocksUtils.getMarketStackApiKey());
        sb.append("&symbols=");
        sb.append(stockSymbol);
        sb.append(LIMIT_TO_ONE_OBJECT);
        return sb.toString();
    }
}
