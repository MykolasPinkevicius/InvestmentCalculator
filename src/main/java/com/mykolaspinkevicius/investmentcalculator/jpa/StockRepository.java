package com.mykolaspinkevicius.investmentcalculator.jpa;

import com.mykolaspinkevicius.investmentcalculator.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
