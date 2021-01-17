package com.mykolaspinkevicius.InvestmentCalculator.Market.Stack;

import com.mykolaspinkevicius.InvestmentCalculator.StockUtils.StocksUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MarketStackApiImplementation {
    private static final String MARKET_STACK_WEB_ADDRESS_FOR_REQUESTS = "http://api.marketstack.com/v1/eod?access_key=";
    private static final String LIMIT_TO_ONE_OBJECT = "&limit=1";
    public static final String SYMBOLS = "&symbols=";
    private static final String EXCHANGE = "&exchange=";

    public String appendRequestWithSymbol(String stockSymbol) {
        return appendRequest(
                MARKET_STACK_WEB_ADDRESS_FOR_REQUESTS,
                StocksUtils.getMarketStackApiKey(),
                SYMBOLS,
                stockSymbol,
                LIMIT_TO_ONE_OBJECT
                ).toString();
    }

    public String appendRequestWithSymbolAndExchange(String stockSymbol, String exchange) {
        StringBuilder sb = new StringBuilder(appendRequestWithSymbol(stockSymbol));
        sb.append(EXCHANGE);
        sb.append(exchange);
        return sb.toString();
    }

    private StringBuilder appendRequest(String... strings) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(strings).forEach(sb::append);
        return sb;
    }
}
