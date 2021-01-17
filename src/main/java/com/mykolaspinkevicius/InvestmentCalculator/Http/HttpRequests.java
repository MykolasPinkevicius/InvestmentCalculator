package com.mykolaspinkevicius.InvestmentCalculator.Http;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mykolaspinkevicius.InvestmentCalculator.Entities.MarketStack;
import com.mykolaspinkevicius.InvestmentCalculator.Entities.MarketStackData;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

@Component
public class HttpRequests {
    private static final int STATUS_OK = 200;

    public Optional<String> getApacheHttpClientResponseFromURL(String formedMarketStackURL) throws IOException {
            HttpGet request = new HttpGet(formedMarketStackURL);
        try(CloseableHttpClient client = HttpClients.createDefault()) {
            CloseableHttpResponse response = client.execute(request);
            if(response.getStatusLine().getStatusCode() == STATUS_OK) {
                HttpEntity entity = response.getEntity();
                StringBuilder jsonFromRequest = responseToString(entity);
                MarketStack paginationWithDataFromJson = mapRequestStringToMarketStack(jsonFromRequest);
                EntityUtils.consume(entity);
                response.close();
                return Optional.of(paginationWithDataFromJson.getData().stream().findAny().orElseGet(MarketStackData::new).getClose());
            }
        }
        return Optional.empty();
    }

    private MarketStack mapRequestStringToMarketStack(StringBuilder jsonFromRequest) throws com.fasterxml.jackson.core.JsonProcessingException {
        ObjectMapper jsonObjectMapper = new ObjectMapper();
        MarketStack paginationWithDataFromJson = jsonObjectMapper.readValue(jsonFromRequest.toString(), MarketStack.class);
        return paginationWithDataFromJson;
    }

    private StringBuilder responseToString(HttpEntity entity) throws IOException {
        InputStream is = entity.getContent();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String output;
        StringBuilder jsonFromRequest = new StringBuilder();
        while ((output = br.readLine()) != null) {
            jsonFromRequest.append(output);
        }
        return jsonFromRequest;
    }
}
