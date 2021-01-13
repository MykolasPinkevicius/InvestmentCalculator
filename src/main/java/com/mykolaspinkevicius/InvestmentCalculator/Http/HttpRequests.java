package com.mykolaspinkevicius.InvestmentCalculator.Http;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mykolaspinkevicius.InvestmentCalculator.Market.Stack.MarketStack;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpRequests {
    private static final int STATUS_OK = 200;

    public static void getApacheHttpClientResponseFromURL(String marketStack) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        try(CloseableHttpClient client = HttpClients.createDefault()){
            HttpGet request = new HttpGet(marketStack);
            CloseableHttpResponse response = client.execute(request);
            if(response.getStatusLine().getStatusCode() == STATUS_OK){
                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String output;
                StringBuilder jsonFromRequest = new StringBuilder();
                while ((output = br.readLine()) != null) {
                    jsonFromRequest.append(output);
                }

                ObjectMapper jsonObjectMapper = new ObjectMapper();
                MarketStack paginationWithDataFromJson = jsonObjectMapper.readValue(jsonFromRequest.toString(), MarketStack.class);
                paginationWithDataFromJson.getData().forEach(
                        x -> System.out.println(x.getClose())
                );
                EntityUtils.consume(entity);
                response.close();
            }
        }
    }
}
