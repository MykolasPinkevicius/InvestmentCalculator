package com.mykolaspinkevicius.InvestmentCalculator.Configuration;

import com.mykolaspinkevicius.InvestmentCalculator.Entities.Stock;
import com.mykolaspinkevicius.InvestmentCalculator.JPA.StockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(StockRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Stock(new BigDecimal(0.00801).setScale(4, RoundingMode.HALF_DOWN), "ISOL", "1MAGE Software Inc.", "PINC")));
            log.info("Preloading " + repository.save(new Stock(new BigDecimal(0.00801).setScale(4, RoundingMode.HALF_DOWN), "EIHDF", "888 Holdings PLC", "PINC")));
        };
    }
}
