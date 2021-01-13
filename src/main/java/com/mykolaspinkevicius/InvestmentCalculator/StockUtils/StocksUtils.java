package com.mykolaspinkevicius.InvestmentCalculator.StockUtils;

public class StocksUtils {
    private static final String MARKET_STACK_API_KEY = "c8f19ab30ce1fa640f1596832f1c2345";
    private static final String APPLE_STOCK_SYMBOL = "&symbols=AAPL";

    public static String getMarketStackApiKey() {
        return MARKET_STACK_API_KEY;
    }

    public static String getAppleStockSymbol() {
        return APPLE_STOCK_SYMBOL;
    }
}
