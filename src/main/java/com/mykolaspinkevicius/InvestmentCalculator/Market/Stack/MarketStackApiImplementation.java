package com.mykolaspinkevicius.InvestmentCalculator.Market.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MarketStackApiImplementation {
    public static final int REQUEST_OK = 200;
    public static final String MARKET_STACK_WEB_ADDRESS_FOR_REQUESTS = "http://api.marketstack.com/v1/eod?access_key=";
    private static final Logger log = LoggerFactory.getLogger(MarketStackApiImplementation.class);
    private static final String LIMIT_TO_ONE_OBJECT = "&limit=1";

    public static String getStockPrices(String accessKey, String stockSymbol) throws IOException {
        try {
            URL stockPriceNowURL = new URL(MARKET_STACK_WEB_ADDRESS_FOR_REQUESTS + accessKey + "&symbols=" +
                    stockSymbol + LIMIT_TO_ONE_OBJECT);
            HttpURLConnection conn = (HttpURLConnection) stockPriceNowURL.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != REQUEST_OK) {
                throw new RuntimeException("HttpResponseCode " + responseCode);
            } else {
                Scanner sc = new Scanner(stockPriceNowURL.openStream());
                String sb = "";
                while(sc.hasNext()) {
                    sb += sc.nextLine();
                }
                System.out.println("\nJSON data in string format");
                System.out.println(sb);
                sc.close();
            return sb;
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
