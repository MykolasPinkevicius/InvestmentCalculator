package com.mykolaspinkevicius.InvestmentCalculator.JPA;

import com.mykolaspinkevicius.InvestmentCalculator.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
