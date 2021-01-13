package com.mykolaspinkevicius.InvestmentCalculator.Market.Stack;

import com.mykolaspinkevicius.InvestmentCalculator.StockUtils.StocksUtils;


public class MarketStackApiImplementation {
    private static final String MARKET_STACK_WEB_ADDRESS_FOR_REQUESTS = "http://api.marketstack.com/v1/eod?access_key=";
    private static final String LIMIT_TO_ONE_OBJECT = "&limit=1";

    public static String getStockPrices() {
            return buildRequestURL();
    }

    private static String buildRequestURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(MARKET_STACK_WEB_ADDRESS_FOR_REQUESTS);
        sb.append(StocksUtils.getMarketStackApiKey());
        sb.append(StocksUtils.getAppleStockSymbol());
        sb.append(LIMIT_TO_ONE_OBJECT);
        return sb.toString();
    }
}
